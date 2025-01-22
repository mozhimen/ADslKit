package com.mozhimen.dslk.anko.core

/**
 * @ClassName ViewGroups
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/2
 * @Version 1.0
 */
import android.content.Context
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RadioGroup
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import com.mozhimen.dslk.anko.core.commons.Ui
import com.mozhimen.dslk.anko.core.values.Theme
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

// LinearLayout (vertical)

@OptIn(ExperimentalContracts::class)
inline fun Context.verticalLayout(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: LinearLayout.() -> Unit = {}
): LinearLayout {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(::LinearLayout, id, theme) {
        orientation = LinearLayout.VERTICAL
        initView()
    }
}

@OptIn(ExperimentalContracts::class)
inline fun View.verticalLayout(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: LinearLayout.() -> Unit = {}
): LinearLayout {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.verticalLayout(id, theme, initView)
}

@OptIn(ExperimentalContracts::class)
inline fun Ui.verticalLayout(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: LinearLayout.() -> Unit = {}
): LinearLayout {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.verticalLayout(id, theme, initView)
}

// LinearLayout (horizontal)
@OptIn(ExperimentalContracts::class)

inline fun Context.horizontalLayout(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: LinearLayout.() -> Unit = {}
): LinearLayout {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(::LinearLayout, id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.horizontalLayout(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: LinearLayout.() -> Unit = {}
): LinearLayout {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.horizontalLayout(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.horizontalLayout(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: LinearLayout.() -> Unit = {}
): LinearLayout {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.horizontalLayout(id, theme, initView)
}

// FrameLayout
@OptIn(ExperimentalContracts::class)

inline fun Context.frameLayout(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: FrameLayout.() -> Unit = {}
): FrameLayout {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(::FrameLayout, id, theme, initView)
}

@OptIn(ExperimentalContracts::class)
inline fun View.frameLayout(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: FrameLayout.() -> Unit = {}
): FrameLayout {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.frameLayout(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.frameLayout(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: FrameLayout.() -> Unit = {}
): FrameLayout {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.frameLayout(id, theme, initView)
}

// RadioGroup
@OptIn(ExperimentalContracts::class)

inline fun Context.radioGroup(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: RadioGroup.() -> Unit = {}
): RadioGroup {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(::RadioGroup, id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.radioGroup(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: RadioGroup.() -> Unit = {}
): RadioGroup {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.radioGroup(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.radioGroup(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: RadioGroup.() -> Unit = {}
): RadioGroup {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.radioGroup(id, theme, initView)
}