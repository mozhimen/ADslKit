package com.mozhimen.dslk.anko.core.funs

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.app.Service
import android.app.backup.BackupAgent
import android.content.Context
import android.content.ContextWrapper
import android.content.res.Resources
import android.util.AttributeSet
import android.util.TypedValue
import android.view.ContextThemeWrapper
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import com.mozhimen.dslk.anko.core.commons.ViewFactory
import com.mozhimen.dslk.anko.core.values.Layout
import com.mozhimen.dslk.anko.core.values.Theme
import com.mozhimen.kotlin.elemk.commons.IABC_DListener
import com.mozhimen.kotlin.utilk.android.content.isMainProcess

/**
 * @ClassName Context
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Context.withTheme(theme: Int): ContextThemeWrapper =
    ContextThemeWrapper(this, theme)

fun Context.wrapCtxIfNeeded(theme: Int): Context {
    return if (theme == Theme.NO_THEME) this else withTheme(theme)
}

inline fun <V : View> Context.styledView(
    newViewRef: IABC_DListener<Context, AttributeSet?,Int,V>/*NewViewWithStyleAttrRef<V>*/,
    @AttrRes styleAttr: Int,
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: V.() -> Unit = {}
): V =
    newViewRef(this.wrapCtxIfNeeded(theme), null, styleAttr).also {
        it.id = id
    }.apply(initView)
//typealias NewViewWithStyleAttrRef<V> = (Context, AttributeSet?, Int) -> V

//@InternalSplittiesApi
fun Context.withViewFactory(viewFactory: ViewFactory): Context = object : ContextWrapper(this) {
    override fun getSystemService(name: String): Any? = when (name) {
        Layout.VIEW_FACTORY -> viewFactory
        else -> super.getSystemService(name)
    }
}

inline fun <R> Context.withResolvedThemeAttribute(
    @AttrRes attrRes: Int,
    resolveRefs: Boolean = true,
    crossinline block: TypedValue.() -> R
): R = if (isMainProcess()) {
    if (theme.resolveAttribute(attrRes, uiThreadConfinedCachedTypedValue, resolveRefs).not()) {
        throw Resources.NotFoundException(
            "Couldn't resolve attribute resource #0x" + Integer.toHexString(attrRes)
                    + " from the theme of this Context."
        )
    }
    block(uiThreadConfinedCachedTypedValue)
} else synchronized(cachedTypeValue) {
    if (theme.resolveAttribute(attrRes, cachedTypeValue, resolveRefs).not()) {
        throw Resources.NotFoundException(
            "Couldn't resolve attribute resource #0x" + Integer.toHexString(attrRes)
                    + " from the theme of this Context."
        )
    }
    block(cachedTypeValue)
}

fun Context.injectAsAppCtx() {
    require(!canLeakMemory()) { "The passed Context($this) would leak memory!" }
    internalCtx = this
}

/**
 * This method will return true on [Context] implementations known to be able to leak memory.
 * This includes [Activity], [Service], the lesser used and lesser known [BackupAgent], as well as
 * any [ContextWrapper] having one of these as its base context.
 */
fun Context.canLeakMemory(): Boolean = when (this) {
    is Application -> false
    is Activity, is Service, is BackupAgent -> true
    is ContextWrapper -> if (baseContext === this) true else baseContext.canLeakMemory()
    else -> applicationContext === null
}

@PublishedApi
@JvmField
internal val uiThreadConfinedCachedTypedValue = TypedValue()
@PublishedApi
@JvmField
internal val cachedTypeValue = TypedValue()
@SuppressLint("StaticFieldLeak")
private var internalCtx: Context? = null