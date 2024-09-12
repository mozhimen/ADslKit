package com.mozhimen.dslk.anko.idepreview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import com.mozhimen.dslk.anko.R
import com.mozhimen.dslk.anko.core.commons.Ui
import com.mozhimen.dslk.anko.core.funs.add
import com.mozhimen.dslk.anko.core.funs.injectAsAppCtx
import com.mozhimen.dslk.anko.core.funs.lParams
import com.mozhimen.dslk.anko.core.funs.styledColor
import com.mozhimen.dslk.anko.core.funs.withStyledAttributes
import com.mozhimen.dslk.anko.core.proterties.matchParent
import com.mozhimen.dslk.anko.core.textView
import com.mozhimen.kotlin.elemk.commons.IA_BListener
import com.mozhimen.kotlin.utilk.android.util.dp2pxI
import com.mozhimen.kotlin.utilk.android.view.applyPadding
import com.mozhimen.kotlin.utilk.android.widget.applyCompoundDrawables
import com.mozhimen.kotlin.utilk.wrapper.UtilKRes
import com.mozhimen.kotlin.utilk.wrapper.gainStringArray
import java.lang.reflect.Constructor
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * @ClassName UiPreview
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/2
 * @Version 1.0
 */
/**
 * This class is dedicated to previewing `Ui` subclasses in the IDE.
 *
 * You can enable the preview with code or a dedicated xml file.
 *
 * Here's an example in Kotlin:
 *
 * ```kotlin
 * //region IDE preview
 * @Deprecated("For IDE preview only", level = DeprecationLevel.HIDDEN)
 * private class MainUiImplPreview(
 *     context: Context,
 *     attrs: AttributeSet? = null,
 *     defStyleAttr: Int = 0
 * ) : UiPreView(
 *     context = context.withTheme(R.style.AppTheme),
 *     attrs = attrs,
 *     defStyleAttr = defStyleAttr,
 *     createUi = { MainUiImpl(it) }
 * )
 * //endregion
 * ```
 *
 * And here is an example xml layout file that would preview a `MainUi` class in the `main` package:
 *
 * ```xml
 * <splitties.views.dsl.idepreview.UiPreView
 *     xmlns:android="http://schemas.android.com/apk/res/android"
 *     xmlns:app="http://schemas.android.com/apk/res-auto"
 *     android:layout_width="match_parent"
 *     android:layout_height="match_parent"
 *     android:theme="@style/AppTheme.NoActionBar"
 *     app:class_package_name_relative="main.MainUi"/>
 * ```
 *
 * Note that only the Kotlin version is safe from refactorings (such as renames, package moving…).
 *
 * If you use the xml approach, it's recommended to add it to your debug sources straightaway.
 * For the Kotlin approach, R8 or proguard will see the class is unused and will strip it so long as you
 * have `minifyEnabled = true`.
 *
 * See the sample for complete examples.
 */
open class UiPreView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    open fun getUi(): IA_BListener<Context,Ui>? = null

    init {
        setBackgroundColor(styledColor(android.R.attr.colorBackground))
        require(isInEditMode) { "Only intended for use in IDE!" }
        this.context.injectAsAppCtx()
        try {
            if (getUi() == null) {
                init(this.context, attrs, defStyleAttr)
            } else {
                add(getUi()!!.invoke(this.context).root, lParams(matchParent, matchParent))
            }
        } catch (t: IllegalArgumentException) {
            setBackgroundColor(Color.WHITE)
            addView(textView {
                text = t.message ?: t.toString()
                applyCompoundDrawables(top = R.drawable.ic_warning_red_96dp)
                gravity = Gravity.CENTER_VERTICAL
                setTextColor(Color.BLUE)
                applyPadding(16.dp2pxI())
                textSize = 24f
            }, lParams(matchParent, matchParent))
        }
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        val uiClass: Class<out Ui> = withStyledAttributes(
            attrs = attrs,
            attrsRes = R.styleable.UiPreView,
            defStyleAttr = defStyleAttr,
            defStyleRes = 0
        ) { ta ->
            ta.getString(R.styleable.UiPreView_splitties_class_fully_qualified_name)?.let {
                try {
                    @Suppress("UNCHECKED_CAST")
                    Class.forName(it) as Class<out Ui>
                } catch (e: ClassNotFoundException) {
                    throw IllegalArgumentException("Did not find the specified class: $it")
                }
            } ?: ta.getString(R.styleable.UiPreView_splitties_class_package_name_relative)?.let {
                val packageName = context.packageName.removeSuffix(
                    suffix = UtilKRes.gainString(R.string.splitties_views_dsl_ide_preview_package_name_suffix)
                )
                try {
                    @Suppress("UNCHECKED_CAST")
                    Class.forName("$packageName.$it") as Class<out Ui>
                } catch (e: ClassNotFoundException) {
                    val otherPackages =
                        context.gainStringArray(R.array.splitties_ui_preview_base_package_names)
                    otherPackages.fold<String, Class<out Ui>?>(null) { foundOrNull, packageNameHierarchy ->
                        foundOrNull ?: try {
                            @Suppress("UNCHECKED_CAST")
                            Class.forName("$packageNameHierarchy.$it") as Class<out Ui>
                        } catch (e: ClassNotFoundException) {
                            null
                        }
                    } ?: throw IllegalArgumentException(
                        "Package-name relative class \"$it\" not found!\nDid you make a typo?\n\n" +
                                "Searched in the following root packages:\n" +
                                "- $packageName\n" +
                                otherPackages.joinToString(separator = "\n", prefix = "- ")
                    )
                }
            } ?: throw IllegalArgumentException("No class name attribute provided")
        }
        require(!uiClass.isInterface) { "$uiClass is not instantiable because it's an interface!" }
        require(Ui::class.java.isAssignableFrom(uiClass)) { "$uiClass is not a subclass of Ui!" }
        val ui = try {
            val uiConstructor: Constructor<out Ui> = uiClass.getConstructor(Context::class.java)
            uiConstructor.newInstance(context)
        } catch (e: NoSuchMethodException) {
            val uiConstructor = uiClass.constructors.firstOrNull {
                it.parameterTypes.withIndex().all { (i, parameterType) ->
                    (i == 0 && parameterType == Context::class.java) || parameterType.isInterface
                }
            } ?: run {
                throw IllegalArgumentException(
                    "No suitable constructor found. Need one with Context as " +
                            "first parameter, and only interface types for other parameters, if any."
                )
            }

            @Suppress("UNUSED_ANONYMOUS_PARAMETER")
            val parameters = mutableListOf<Any>(context).also { params ->
                uiConstructor.parameterTypes.forEachIndexed { index, parameterType ->
                    if (index != 0) params += when (parameterType) {
                        CoroutineContext::class.java -> EmptyCoroutineContext
                        else -> Proxy.newProxyInstance(
                            parameterType.classLoader,
                            arrayOf(parameterType)
                        ) { proxy: Any?, method: Method, args: Array<out Any>? ->
                            when (method.declaringClass.name) {
                                "kotlinx.coroutines.CoroutineScope" -> EmptyCoroutineContext
                                else -> throw UnsupportedOperationException("Edit mode: stub implementation.")
                            }
                        }
                    }
                }
            }.toTypedArray()
            uiConstructor.newInstance(*parameters) as Ui
        }
        addView(ui.root, lParams(matchParent, matchParent))
    }
}

