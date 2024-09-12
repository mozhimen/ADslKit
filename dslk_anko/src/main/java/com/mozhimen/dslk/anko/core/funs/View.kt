package com.mozhimen.dslk.anko.core.funs

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ScrollView
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import com.mozhimen.dslk.anko.core.commons.Ui
import com.mozhimen.dslk.anko.core.values.Theme
import com.mozhimen.dslk.anko.core.values.Layout
import com.mozhimen.dslk.anko.core.proterties.matchParent
import com.mozhimen.dslk.anko.core.proterties.wrapContent
import com.mozhimen.dslk.anko.core.view
import com.mozhimen.kotlin.utilk.android.content.UtilKContext
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * @ClassName View
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
@OptIn(ExperimentalContracts::class)
inline fun <reified V : View> Context.inflate(
    @LayoutRes layoutResId: Int,
    @IdRes id: Int = Layout.XML_DEFINED_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: V.() -> Unit = {}
): V {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return( UtilKContext.getLayoutInflater(wrapCtxIfNeeded(theme)).inflate(layoutResId,null,false) as V).also { inflatedView ->
        if (id != Layout.XML_DEFINED_ID) inflatedView.id = id
    }.apply(initView)
}

@OptIn(ExperimentalContracts::class)
inline fun <reified V : View> View.inflate(
    @LayoutRes layoutResId: Int,
    @IdRes id: Int = Layout.XML_DEFINED_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: V.() -> Unit = {}
): V {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.inflate(layoutResId, id, theme, initView)
}

@OptIn(ExperimentalContracts::class)
inline fun <reified V : View> Ui.inflate(
    @LayoutRes layoutResId: Int,
    @IdRes id: Int = Layout.XML_DEFINED_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: V.() -> Unit = {}
): V {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.inflate(layoutResId, id, theme, initView)
}

@OptIn(ExperimentalContracts::class)
inline fun View.wrapInScrollView(
    @IdRes id: Int = View.NO_ID,
    height: Int = wrapContent,
    initView: ScrollView.() -> Unit = {}
): ScrollView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(::ScrollView, id) {
        add(this@wrapInScrollView, lParams(width = matchParent, height = height))
    }.apply(initView)
}

@OptIn(ExperimentalContracts::class)
inline fun View.wrapInHorizontalScrollView(
    @IdRes id: Int = View.NO_ID,
    height: Int = wrapContent,
    initView: HorizontalScrollView.() -> Unit = {}
): HorizontalScrollView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(::HorizontalScrollView, id) {
        add(this@wrapInHorizontalScrollView, lParams(width = matchParent, height = height))
    }.apply(initView)
}

@OptIn(ExperimentalContracts::class)
inline fun <R> View.withStyledAttributes(
    attrs: AttributeSet?,
    attrsRes: IntArray,
    defStyleAttr: Int,
    defStyleRes: Int = 0,
    func: (styledAttrs: TypedArray) -> R
): R {
    contract { callsInPlace(func, InvocationKind.EXACTLY_ONCE) }
    val styledAttrs = context.obtainStyledAttributes(attrs, attrsRes, defStyleAttr, defStyleRes)
    return func(styledAttrs).also { styledAttrs.recycle() }
}