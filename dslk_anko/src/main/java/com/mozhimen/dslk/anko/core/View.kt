package com.mozhimen.dslk.anko.core

/**
 * @ClassName Views
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/2
 * @Version 1.0
 */
import android.content.Context
import android.view.View
import android.widget.*
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import com.mozhimen.dslk.anko.core.commons.Ui
import com.mozhimen.dslk.anko.core.values.Theme
import com.mozhimen.kotlin.elemk.commons.IA_BListener
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import com.mozhimen.dslk.anko.core.funs.wrapCtxIfNeeded
import com.mozhimen.dslk.anko.core.proterties.viewFactory

// TextView

@OptIn(ExperimentalContracts::class)
inline fun Context.textView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: TextView.() -> Unit = {}
): TextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.textView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: TextView.() -> Unit = {}
): TextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.textView(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.textView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: TextView.() -> Unit = {}
): TextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.textView(id, theme, initView)
}

// Button
@OptIn(ExperimentalContracts::class)

inline fun Context.button(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: Button.() -> Unit = {}
): Button {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.button(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: Button.() -> Unit = {}
): Button {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.button(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.button(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: Button.() -> Unit = {}
): Button {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.button(id, theme, initView)
}

// ImageView
@OptIn(ExperimentalContracts::class)

inline fun Context.imageView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: ImageView.() -> Unit = {}
): ImageView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.imageView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: ImageView.() -> Unit = {}
): ImageView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.imageView(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.imageView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: ImageView.() -> Unit = {}
): ImageView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.imageView(id, theme, initView)
}

// EditText
@OptIn(ExperimentalContracts::class)

inline fun Context.editText(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: EditText.() -> Unit = {}
): EditText {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.editText(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: EditText.() -> Unit = {}
): EditText {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.editText(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.editText(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: EditText.() -> Unit = {}
): EditText {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.editText(id, theme, initView)
}

// Spinner
@OptIn(ExperimentalContracts::class)

inline fun Context.spinner(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: Spinner.() -> Unit = {}
): Spinner {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.spinner(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: Spinner.() -> Unit = {}
): Spinner {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.spinner(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.spinner(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: Spinner.() -> Unit = {}
): Spinner {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.spinner(id, theme, initView)
}

// ImageButton
@OptIn(ExperimentalContracts::class)

inline fun Context.imageButton(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: ImageButton.() -> Unit = {}
): ImageButton {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.imageButton(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: ImageButton.() -> Unit = {}
): ImageButton {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.imageButton(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.imageButton(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: ImageButton.() -> Unit = {}
): ImageButton {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.imageButton(id, theme, initView)
}

// CheckBox
@OptIn(ExperimentalContracts::class)

inline fun Context.checkBox(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: CheckBox.() -> Unit = {}
): CheckBox {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.checkBox(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: CheckBox.() -> Unit = {}
): CheckBox {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.checkBox(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.checkBox(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: CheckBox.() -> Unit = {}
): CheckBox {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.checkBox(id, theme, initView)
}

// RadioButton
@OptIn(ExperimentalContracts::class)

inline fun Context.radioButton(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: RadioButton.() -> Unit = {}
): RadioButton {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.radioButton(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: RadioButton.() -> Unit = {}
): RadioButton {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.radioButton(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.radioButton(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: RadioButton.() -> Unit = {}
): RadioButton {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.radioButton(id, theme, initView)
}

// CheckedTextView
@OptIn(ExperimentalContracts::class)

inline fun Context.checkedTextView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: CheckedTextView.() -> Unit = {}
): CheckedTextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.checkedTextView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: CheckedTextView.() -> Unit = {}
): CheckedTextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.checkedTextView(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.checkedTextView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: CheckedTextView.() -> Unit = {}
): CheckedTextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.checkedTextView(id, theme, initView)
}

// AutoCompleteTextView
@OptIn(ExperimentalContracts::class)

inline fun Context.autoCompleteTextView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: AutoCompleteTextView.() -> Unit = {}
): AutoCompleteTextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.autoCompleteTextView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: AutoCompleteTextView.() -> Unit = {}
): AutoCompleteTextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.autoCompleteTextView(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.autoCompleteTextView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: AutoCompleteTextView.() -> Unit = {}
): AutoCompleteTextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.autoCompleteTextView(id, theme, initView)
}

// MultiAutoCompleteTextView
@OptIn(ExperimentalContracts::class)

inline fun Context.multiAutoCompleteTextView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: MultiAutoCompleteTextView.() -> Unit = {}
): MultiAutoCompleteTextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.multiAutoCompleteTextView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: MultiAutoCompleteTextView.() -> Unit = {}
): MultiAutoCompleteTextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.multiAutoCompleteTextView(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.multiAutoCompleteTextView(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: MultiAutoCompleteTextView.() -> Unit = {}
): MultiAutoCompleteTextView {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.multiAutoCompleteTextView(id, theme, initView)
}

// RatingBar
@OptIn(ExperimentalContracts::class)

inline fun Context.ratingBar(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: RatingBar.() -> Unit = {}
): RatingBar {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.ratingBar(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: RatingBar.() -> Unit = {}
): RatingBar {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.ratingBar(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.ratingBar(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: RatingBar.() -> Unit = {}
): RatingBar {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.ratingBar(id, theme, initView)
}

// SeekBar
@OptIn(ExperimentalContracts::class)

inline fun Context.seekBar(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: SeekBar.() -> Unit = {}
): SeekBar {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.seekBar(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: SeekBar.() -> Unit = {}
): SeekBar {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.seekBar(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.seekBar(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: SeekBar.() -> Unit = {}
): SeekBar {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.seekBar(id, theme, initView)
}

// Space
@OptIn(ExperimentalContracts::class)

inline fun Context.space(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: Space.() -> Unit = {}
): Space {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun View.space(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: Space.() -> Unit = {}
): Space {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.space(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun Ui.space(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: Space.() -> Unit = {}
): Space {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.space(id, theme, initView)
}

//////////////////////////////////////////////////////////////

/**
 * Most of the time, you should use a non [InternalSplittiesApi] overload of this function that
 * takes a function of type `(Context) -> V` where V is a `View` or one of its subtypes, where
 * using a reference to the constructor (e.g. `v(::MapView)`) is possible.
 *
 * This function is meant to be used when the type of View [V] is supported by an installed
 * [ViewFactory]. This inline function is usually hidden under other inline functions such as
 * the function [textView], which define the type.
 */
//@InternalSplittiesApi
@OptIn(ExperimentalContracts::class)
inline fun <reified V : View> Context.view(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: V.() -> Unit = {}
): V {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return viewFactory(V::class.java, wrapCtxIfNeeded(theme)).also {
        it.id = id
    }.apply(initView)
}

/**
 * Most of the time, you should use a non [InternalSplittiesApi] overload of this function that
 * takes a function of type `(Context) -> V` where V is a `View` or one of its subtypes, where
 * using a reference to the constructor (e.g. `v(::MapView)`) is possible.
 *
 * This function is meant to be used when the type of View [V] is supported by an installed
 * [ViewFactory]. This inline function is usually hidden under other inline functions such as
 * the function [textView], which define the type.
 */
//@InternalSplittiesApi
@OptIn(ExperimentalContracts::class)
inline fun <reified V : View> View.view(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: V.() -> Unit = {}
): V {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.view(id, theme, initView)
}

/**
 * Most of the time, you should use a non [InternalSplittiesApi] overload of this function that
 * takes a function of type `(Context) -> V` where V is a `View` or one of its subtypes, where
 * using a reference to the constructor (e.g. `v(::MapView)`) is possible.
 *
 * This function is meant to be used when the type of View [V] is supported by an installed
 * [ViewFactory]. This inline function is usually hidden under other inline functions such as
 * the function [textView], which define the type.
 */
//@InternalSplittiesApi
@OptIn(ExperimentalContracts::class)

inline fun <reified V : View> Ui.view(
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: V.() -> Unit = {}
): V {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.view(id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun <V : View> Context.view(
    createView: IA_BListener<Context,V>,
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: V.() -> Unit = {}
): V {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return createView(wrapCtxIfNeeded(theme)).also { it.id = id }.apply(initView)
}
@OptIn(ExperimentalContracts::class)

inline fun <V : View> View.view(
    createView: IA_BListener<Context,V>,
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: V.() -> Unit = {}
): V {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return context.view(createView, id, theme, initView)
}
@OptIn(ExperimentalContracts::class)

inline fun <V : View> Ui.view(
    createView: IA_BListener<Context,V>,
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: V.() -> Unit = {}
): V {
    contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
    return ctx.view(createView, id, theme, initView)
}

/** Called so to remind that function references (that are inlined) are recommended for [view]. */
//typealias NewViewRef<V> = (Context) -> V
