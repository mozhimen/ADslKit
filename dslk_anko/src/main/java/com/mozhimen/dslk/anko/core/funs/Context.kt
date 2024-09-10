package com.mozhimen.dslk.anko.core.funs

import android.content.Context
import android.content.ContextWrapper
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import com.mozhimen.dslk.anko.core.commons.ViewFactory
import com.mozhimen.dslk.anko.core.values.Layout
import com.mozhimen.dslk.anko.core.values.Theme
import com.mozhimen.kotlin.elemk.commons.IABC_DListener

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

