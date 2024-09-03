package com.mozhimen.dslk

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.*
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.helper.widget.Layer
import androidx.constraintlayout.widget.Barrier
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

/**
 * the extension functions and field in this file help you to build layout dynamically,
 * which has a better performance than xml files and more readable than normal java and kotlin code
 *
 * using this dsl to build view in kotlin like the following:
 * private val rootView by lazy {
 *   ConstraintLayout {
 *      layout_width = match_parent
 *      layout_height = match_parent
 *
 *       ImageView {
 *          layout_id = "ivBack"
 *          layout_width = 40
 *          layout_height = 40
 *          margin_start = 20
 *          margin_top = 20
 *          src = R.drawable.ic_back_black
 *          start_toStartOf = parent_id
 *          top_toTopOf = parent_id
 *          onClick = onBackClick
 *       }
 *
 *       TextView {
 *          layout_width = wrap_content
 *          layout_height = wrap_content
 *          text = "commit"
 *          textSize = 30f
 *          layout_visibility = gone
 *          textStyle = bold
 *          align_vertical_to = "ivBack"
 *          center_horizontal = true
 *       }
 *   }
 * }
 */

/**
 * create [AppCompatTextView] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [AppCompatTextView] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.textView(style: Int? = null, autoAdd: Boolean = true, init: AppCompatTextView.() -> Unit): TextView {
    val textView = if (style != null) AppCompatTextView(ContextThemeWrapper(context, style)) else AppCompatTextView(context)
    return textView.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.textView(style: Int? = null, init: AppCompatTextView.() -> Unit): AppCompatTextView {
    val textView = if (style != null) AppCompatTextView(ContextThemeWrapper(this, style)) else AppCompatTextView(this)
    return textView.apply(init)
}

inline fun Fragment.textView(style: Int? = null, init: AppCompatTextView.() -> Unit): AppCompatTextView? =
    context?.let { if (style != null) AppCompatTextView(ContextThemeWrapper(it, style)) else AppCompatTextView(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [AppCompatImageView] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [AppCompatImageView] into [ViewGroup] automatically
 *  @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.imageView(style: Int? = null, autoAdd: Boolean = true, init: AppCompatImageView.() -> Unit): ImageView {
    val imageView = if (style != null) AppCompatImageView(ContextThemeWrapper(context, style)) else AppCompatImageView(context)
    return imageView.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.imageView(style: Int? = null, init: AppCompatImageView.() -> Unit): AppCompatImageView {
    val imageView = if (style != null) AppCompatImageView(ContextThemeWrapper(this, style)) else AppCompatImageView(this)
    return imageView.apply(init)
}

inline fun Fragment.imageView(style: Int? = null, init: AppCompatImageView.() -> Unit): AppCompatImageView? =
    context?.let { if (style != null) AppCompatImageView(ContextThemeWrapper(it, style)) else AppCompatImageView(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [AppCompatButton] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [AppCompatButton] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.button(style: Int? = null, autoAdd: Boolean = true, init: AppCompatButton.() -> Unit): Button {
    val button = if (style != null) AppCompatButton(ContextThemeWrapper(context, style)) else AppCompatButton(context)
    return button.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.button(style: Int? = null, init: AppCompatButton.() -> Unit): AppCompatButton {
    val button = if (style != null) AppCompatButton(ContextThemeWrapper(this, style)) else AppCompatButton(this)
    return button.apply(init)
}

inline fun Fragment.button(style: Int? = null, init: AppCompatButton.() -> Unit): AppCompatButton? =
    context?.let { if (style != null) AppCompatButton(ContextThemeWrapper(it, style)) else AppCompatButton(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [view] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [view] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.view(style: Int? = null, autoAdd: Boolean = true, init: View.() -> Unit): View {
    val view = if (style != null) View(ContextThemeWrapper(context, style)) else View(context)
    return view.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.view(style: Int? = null, init: View.() -> Unit): View {
    val view = if (style != null) View(ContextThemeWrapper(this, style)) else View(this)
    return view.apply(init)
}

inline fun Fragment.view(style: Int? = null, init: View.() -> Unit): View? =
    context?.let { if (style != null) View(ContextThemeWrapper(it, style)) else View(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [relativeLayout] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [relativeLayout] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.relativeLayout(style: Int? = null, autoAdd: Boolean = true, init: RelativeLayout.() -> Unit): RelativeLayout {
    val relativeLayout = if (style != null) RelativeLayout(ContextThemeWrapper(context, style)) else RelativeLayout(context)
    return relativeLayout.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.relativeLayout(style: Int? = null, init: RelativeLayout.() -> Unit): RelativeLayout {
    val relativeLayout = if (style != null) RelativeLayout(ContextThemeWrapper(this, style)) else RelativeLayout(this)
    return relativeLayout.apply(init)
}

inline fun Fragment.relativeLayout(style: Int? = null, init: RelativeLayout.() -> Unit): RelativeLayout? =
    context?.let { if (style != null) RelativeLayout(ContextThemeWrapper(it, style)) else RelativeLayout(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [linearLayout] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [LinearLayoutCompat] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.linearLayout(style: Int? = null, autoAdd: Boolean = true, init: LinearLayout.() -> Unit): LinearLayout {
    val linearLayout = if (style != null) LinearLayout(ContextThemeWrapper(context, style)) else LinearLayout(context)
    return linearLayout.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.linearLayout(style: Int? = null, init: LinearLayout.() -> Unit): LinearLayout {
    val linearLayout = if (style != null) LinearLayout(ContextThemeWrapper(this, style)) else LinearLayout(this)
    return linearLayout.apply(init)
}

inline fun Fragment.linearLayout(style: Int? = null, init: LinearLayout.() -> Unit): LinearLayout? =
    context?.let { if (style != null) LinearLayout(ContextThemeWrapper(it, style)) else LinearLayout(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [nestedScrollView] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [nestedScrollView] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.nestedScrollView(style: Int? = null, autoAdd: Boolean = true, init: NestedScrollView.() -> Unit): NestedScrollView {
    val nestedScrollView = if (style != null) NestedScrollView(ContextThemeWrapper(context, style)) else NestedScrollView(context)
    return nestedScrollView.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.nestedScrollView(style: Int? = null, init: NestedScrollView.() -> Unit): NestedScrollView {
    val nestedScrollView = if (style != null) NestedScrollView(ContextThemeWrapper(this, style)) else NestedScrollView(this)
    return nestedScrollView.apply(init)
}

inline fun Fragment.nestedScrollView(style: Int? = null, init: FrameLayout.() -> Unit): NestedScrollView? =
    context?.let { if (style != null) NestedScrollView(ContextThemeWrapper(it, style)) else NestedScrollView(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [recyclerView] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [recyclerView] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.recyclerView(style: Int? = null, autoAdd: Boolean = true, init: RecyclerView.() -> Unit): RecyclerView {
    val recyclerView = if (style != null) RecyclerView(ContextThemeWrapper(context, style)) else RecyclerView(context)
    return recyclerView.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.recyclerView(style: Int? = null, init: RecyclerView.() -> Unit): RecyclerView {
    val recyclerView = if (style != null) RecyclerView(ContextThemeWrapper(this, style)) else RecyclerView(this)
    return recyclerView.apply(init)
}

inline fun Fragment.recyclerView(style: Int? = null, init: RecyclerView.() -> Unit): RecyclerView? =
    context?.let { if (style != null) RecyclerView(ContextThemeWrapper(it, style)) else RecyclerView(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [constraintLayout] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [constraintLayout] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.constraintLayout(style: Int? = null, autoAdd: Boolean = true, init: ConstraintLayout.() -> Unit): ConstraintLayout {
    val constraintLayout = if (style != null) ConstraintLayout(ContextThemeWrapper(context, style)) else ConstraintLayout(context)
    return constraintLayout.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.constraintLayout(style: Int? = null, init: ConstraintLayout.() -> Unit): ConstraintLayout {
    val constraintLayout = if (style != null) ConstraintLayout(ContextThemeWrapper(this, style)) else ConstraintLayout(this)
    return constraintLayout.apply(init)
}

inline fun Fragment.constraintLayout(style: Int? = null, init: ConstraintLayout.() -> Unit): ConstraintLayout? =
    context?.let { if (style != null) ConstraintLayout(ContextThemeWrapper(it, style)) else ConstraintLayout(it) }?.apply(init)

inline fun ConstraintLayout.guideline(style: Int? = null, autoAdd: Boolean = true, init: Guideline.() -> Unit): Guideline {
    val guideline = if (style != null) Guideline(ContextThemeWrapper(context, style)) else Guideline(context)
    return guideline.apply(init).also { if (autoAdd) addView(it) }
}

inline fun ConstraintLayout.barrier(style: Int? = null, autoAdd: Boolean = true, init: Barrier.() -> Unit): Barrier {
    val barrier = if (style != null) Barrier(ContextThemeWrapper(context, style)) else Barrier(context)
    return barrier.apply(init).also { if (autoAdd) addView(it) }
}

inline fun ConstraintLayout.flow(style: Int? = null, autoAdd: Boolean = true, init: Flow.() -> Unit): Flow {
    val flow = if (style != null) Flow(ContextThemeWrapper(context, style)) else Flow(context)
    return flow.apply(init).also { if (autoAdd) addView(it) }
}

inline fun ConstraintLayout.layer(style: Int? = null, autoAdd: Boolean = true, init: Layer.() -> Unit): Layer {
    val layer = if (style != null) Layer(ContextThemeWrapper(context, style)) else Layer(context)
    return layer.apply(init).also { if (autoAdd) addView(it) }
}

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [frameLayout] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [frameLayout] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.frameLayout(style: Int? = null, autoAdd: Boolean = true, init: FrameLayout.() -> Unit): FrameLayout {
    val frameLayout = if (style != null) FrameLayout(ContextThemeWrapper(context, style)) else FrameLayout(context)
    return frameLayout.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.frameLayout(style: Int? = null, init: FrameLayout.() -> Unit): FrameLayout {
    val frameLayout = if (style != null) FrameLayout(ContextThemeWrapper(this, style)) else FrameLayout(this)
    return frameLayout.apply(init)
}

inline fun Fragment.frameLayout(style: Int? = null, init: FrameLayout.() -> Unit): FrameLayout? =
    context?.let { if (style != null) FrameLayout(ContextThemeWrapper(it, style)) else FrameLayout(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [viewFlipper] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [viewFlipper] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.viewFlipper(style: Int? = null, autoAdd: Boolean = true, init: ViewFlipper.() -> Unit): ViewFlipper {
    val viewFlipper = if (style != null) ViewFlipper(ContextThemeWrapper(context, style)) else ViewFlipper(context)
    return viewFlipper.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.viewFlipper(style: Int? = null, init: ViewFlipper.() -> Unit): ViewFlipper {
    val viewFlipper = if (style != null) ViewFlipper(ContextThemeWrapper(this, style)) else ViewFlipper(this)
    return viewFlipper.apply(init)
}

inline fun Fragment.viewFlipper(style: Int? = null, init: ViewFlipper.() -> Unit): ViewFlipper? =
    context?.let { if (style != null) ViewFlipper(ContextThemeWrapper(it, style)) else ViewFlipper(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [AppCompatEditText] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [AppCompatEditText] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.editText(style: Int? = null, autoAdd: Boolean = true, init: AppCompatEditText.() -> Unit): AppCompatEditText {
    val editText = if (style != null) AppCompatEditText(ContextThemeWrapper(context, style)) else AppCompatEditText(context)
    return editText.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.editText(style: Int? = null, init: AppCompatEditText.() -> Unit): AppCompatEditText {
    val editText = if (style != null) AppCompatEditText(ContextThemeWrapper(this, style)) else AppCompatEditText(this)
    return editText.apply(init)
}

inline fun Fragment.editText(style: Int? = null, init: AppCompatEditText.() -> Unit): AppCompatEditText? =
    context?.let { if (style != null) AppCompatEditText(ContextThemeWrapper(it, style)) else AppCompatEditText(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [horizontalScrollView] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [horizontalScrollView] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.horizontalScrollView(style: Int? = null, autoAdd: Boolean = true, init: HorizontalScrollView.() -> Unit): HorizontalScrollView {
    val horizontalScrollView = if (style != null) HorizontalScrollView(ContextThemeWrapper(context, style)) else HorizontalScrollView(context)
    return horizontalScrollView.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.horizontalScrollView(style: Int? = null, init: HorizontalScrollView.() -> Unit): HorizontalScrollView {
    val horizontalScrollView = if (style != null) HorizontalScrollView(ContextThemeWrapper(this, style)) else HorizontalScrollView(this)
    return horizontalScrollView.apply(init)
}

inline fun Fragment.horizontalScrollView(style: Int? = null, init: HorizontalScrollView.() -> Unit): HorizontalScrollView? =
    context?.let { if (style != null) HorizontalScrollView(ContextThemeWrapper(it, style)) else HorizontalScrollView(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [viewPager2] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [viewPager2] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.viewPager2(style: Int? = null, autoAdd: Boolean = true, init: ViewPager2.() -> Unit): ViewPager2 {
    val viewPager2 = if (style != null) ViewPager2(ContextThemeWrapper(context, style)) else ViewPager2(context)
    return viewPager2.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.viewPager2(style: Int? = null, init: ViewPager2.() -> Unit): ViewPager2 {
    val viewPager2 = if (style != null) ViewPager2(ContextThemeWrapper(this, style)) else ViewPager2(this)
    return viewPager2.apply(init)
}

inline fun Fragment.viewPager2(style: Int? = null, init: ViewPager2.() -> Unit): ViewPager2? =
    context?.let { if (style != null) ViewPager2(ContextThemeWrapper(it, style)) else ViewPager2(it) }?.apply(init)

//////////////////////////////////////////////////////////////////////////////////////////////

/**
 * create [fragmentContainerView] instance within a [ViewGroup]
 * @param style an style int value defined in xml
 * @param autoAdd whether add [fragmentContainerView] into [ViewGroup] automatically
 * @param init set attributes for this view in this lambda
 */
inline fun ViewGroup.fragmentContainerView(style: Int? = null, autoAdd: Boolean = true, init: FragmentContainerView.() -> Unit): FragmentContainerView {
    val fragmentContainerView = if (style != null) FragmentContainerView(ContextThemeWrapper(context, style)) else FragmentContainerView(context)
    return fragmentContainerView.apply(init).also { if (autoAdd) addView(it) }
}

inline fun Context.fragmentContainerView(style: Int? = null, init: FragmentContainerView.() -> Unit): FragmentContainerView {
    val fragmentContainerView = if (style != null) FragmentContainerView(ContextThemeWrapper(this, style)) else FragmentContainerView(this)
    return fragmentContainerView.apply(init)
}

inline fun Fragment.fragmentContainerView(style: Int? = null, init: FragmentContainerView.() -> Unit): FragmentContainerView? =
    context?.let { if (style != null) FragmentContainerView(ContextThemeWrapper(it, style)) else FragmentContainerView(it) }?.apply(init)



































