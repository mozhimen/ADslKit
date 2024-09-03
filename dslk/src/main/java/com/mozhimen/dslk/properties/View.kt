package com.mozhimen.dslk.properties

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.*
import androidx.core.content.ContextCompat
import androidx.core.view.MarginLayoutParamsCompat
import androidx.lifecycle.LiveData
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.mozhimen.dslk.funcs.observe
import com.mozhimen.dslk.values.parent_id
import com.mozhimen.dslk.funcs.setShakelessClickListener
import com.mozhimen.dslk.utils.generateLayoutId
import com.mozhimen.kotlin.utilk.android.util.dp2pxI
import com.mozhimen.kotlin.utilk.android.view.applyUpdateLayoutParams

//<editor-fold desc="View extend field">
inline var View.layout_id: String
    get() =""
    set(value) {
        id = value.generateLayoutId()
    }

inline var View.layout_width: Number
    get() =0
    set(value) {
        val w = if (value.dp2pxI() > 0) value.dp2pxI() else value.toInt()
        val h = layoutParams?.height ?: 0
        applyUpdateLayoutParams<ViewGroup.LayoutParams> {
            width = w
            height = h
        }
    }

inline var View.layout_height: Number
    get() =0
    set(value) {
        val w = layoutParams?.width ?: 0
        val h = if (value.dp2pxI() > 0) value.dp2pxI() else value.toInt()
        applyUpdateLayoutParams<ViewGroup.LayoutParams> {
            width = w
            height = h
        }
    }
inline var View.layout_visibility: Int
    get() =-1
    set(value) {
        visibility = value
    }

//////////////////////////////////////////////////////////////////////////////

inline var View.padding_top: Number
    get() =0
    set(value) {
        setPadding(paddingLeft, value.dp2pxI(), paddingRight, paddingBottom)
    }

inline var View.padding_bottom: Number
    get() =0
    set(value) {
        setPadding(paddingLeft, paddingTop, paddingRight, value.dp2pxI())
    }

inline var View.padding_start: Number
    get() =0
    set(value) {
        setPadding(value.dp2pxI(), paddingTop, paddingRight, paddingBottom)
    }

inline var View.padding_end: Number
    get() =0
    set(value) {
        setPadding(paddingLeft, paddingTop, value.dp2pxI(), paddingBottom)
    }

inline var View.padding: Number
    get() =0
    set(value) {
        setPadding(value.dp2pxI(), value.dp2pxI(), value.dp2pxI(), value.dp2pxI())
    }

inline var View.padding_horizontal: Number
    get() =0
    set(value) {
        padding_start = value
        padding_end = value
    }

inline var View.padding_vertical: Number
    get() =0
    set(value) {
        padding_top = value
        padding_bottom = value
    }

//////////////////////////////////////////////////////////////////////////////

inline var View.background_color: Int
    get() =0
    set(value) {
        setBackgroundColor(value)
    }

inline var View.background_color_str: String
    get() =""
    set(value) {
        setBackgroundColor(Color.parseColor(value))
    }

inline var View.background_color_res: Int
    get() =-1
    set(value) {
        setBackgroundColor(ContextCompat.getColor(context, value))
    }

inline var View.background_res: Int
    get() =-1
    set(value) {
        background = AppCompatResources.getDrawable(context, value)
    }

inline var View.background_vector: Int
    get() =-1
    set(value) {
        val drawable = VectorDrawableCompat.create(context.getResources(), value, null)
        background = drawable
    }

inline var View.background_drawable: Drawable?
    get() =null
    set(value) {
        value?.let { background = it }
    }

inline var View.background_drawable_state_list: List<Pair<IntArray, Drawable>>
    get() =listOf(intArrayOf() to GradientDrawable())
    set(value) {
        background = StateListDrawable().apply {
            value.forEach { pair ->
                addState(pair.first, pair.second)
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////

inline var View.margin_top: Number
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = value.dp2pxI()
        }
    }

inline var View.margin_bottom: Number
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ViewGroup.MarginLayoutParams> {
            bottomMargin = value.dp2pxI()
        }
    }

inline var View.margin_start: Number
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ViewGroup.MarginLayoutParams> {
            MarginLayoutParamsCompat.setMarginStart(this, value.dp2pxI())
        }
    }

inline var View.margin_end: Number
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ViewGroup.MarginLayoutParams> {
            MarginLayoutParamsCompat.setMarginEnd(this, value.dp2pxI())
        }
    }

inline var View.margin_horizontal: Number
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ViewGroup.MarginLayoutParams> {
            MarginLayoutParamsCompat.setMarginEnd(this, value.dp2pxI())
            MarginLayoutParamsCompat.setMarginStart(this, value.dp2pxI())
        }
    }

inline var View.margin_vertical: Number
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = value.dp2pxI()
            bottomMargin = value.dp2pxI()
        }
    }

//////////////////////////////////////////////////////////////////////////////

inline var View.fitsSystemWindows: Boolean
    get() =false
    set(value) {
        fitsSystemWindows = value
    }

/**
 * use this attribute to build shape dynamically, getting rid of "shape.xml"
 */
inline var View.shape: GradientDrawable
    get()= GradientDrawable()
    set(value) {
        background = value
    }

//////////////////////////////////////////////////////////////////////////////

/**
 * bind async data
 */
inline var View.bindLiveData: LiveDataBinder?
    get() =null
    set(value) {
        observe(value?.liveData) {
            value?.action?.invoke(it)
        }
    }

/**
 * old fashion for binding data
 */
inline var View.bind: Binder?
    get() =null
    set(value) {
        value?.action?.invoke(this, value.data)
    }

/**
 * bind sync data
 */
inline var View.bindData: () -> Unit
    get() ={}
    set(value) {
        value()
    }

var View.onClick: (View) -> Unit
    get() ={}
    set(value) {
        setOnClickListener { v -> value(v) }
    }

var View.shakelessClick: (View) -> Unit
    get() ={}
    set(value) {
        setShakelessClickListener(1000) {
            value(it)
        }
    }

//////////////////////////////////////////////////////////////////////////////
//RelativeLayout
//////////////////////////////////////////////////////////////////////////////

inline var View.alignParentStart: Boolean
    get() = false
    set(value) {
        if (!value) return
        layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
            (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
                addRule(index, i)
            }
            addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE)
        }
    }

inline var View.alignParentEnd: Boolean
    get() = false
    set(value) {
        if (!value) return
        layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
            (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
                addRule(index, i)
            }
            addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE)
        }
    }

inline var View.centerVertical: Boolean
    get() = false
    set(value) {
        if (!value) return
        layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
            (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
                addRule(index, i)
            }
            addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
        }
    }

inline var View.centerInParent: Boolean
    get() = false
    set(value) {
        if (!value) return
        layoutParams = RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height).apply {
            (layoutParams as? RelativeLayout.LayoutParams)?.rules?.forEachIndexed { index, i ->
                addRule(index, i)
            }
            addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
        }
    }

//////////////////////////////////////////////////////////////////////////////
//LinearLayout
//////////////////////////////////////////////////////////////////////////////

inline var View.weight: Float
    get() =0f
    set(value) {
        applyUpdateLayoutParams<LinearLayout.LayoutParams> {
            gravity = (layoutParams as? LinearLayout.LayoutParams)?.gravity ?: -1
            weight = value
        }
    }
inline var View.layout_gravity: Int
    get() =-1
    set(value) {
        applyUpdateLayoutParams<LinearLayout.LayoutParams> {
            weight = (layoutParams as? LinearLayout.LayoutParams)?.weight ?: 0f
            gravity = value
        }
    }

//////////////////////////////////////////////////////////////////////////////
//ConstraintLayout
//////////////////////////////////////////////////////////////////////////////

inline var View.toCircleOf: String
    get() =""
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            circleConstraint = value.generateLayoutId()
        }
    }

inline var View.circle_radius: Int
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            circleRadius = value.dp2pxI()
        }
    }

inline var View.circle_angle: Float
    get() =-1f
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            circleAngle = value
        }
    }

inline var View.start_toStartOf: String
    get() =""
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            startToStart = value.generateLayoutId()
            startToEnd = -1
        }
    }

inline var View.start_toStartViewOf: View?
    get() =null
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            startToStart = value?.id ?: -1
            startToEnd = -1
        }
    }

inline var View.start_toEndOf: String
    get() =""
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            startToEnd = value.generateLayoutId()
            startToStart = -1
        }
    }

inline var View.start_toEndViewOf: View?
    get() =null
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            startToEnd = value?.id ?: -1
            startToStart = -1
        }
    }

inline var View.top_toBottomOf: String
    get() =""
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            topToBottom = value.generateLayoutId()
            topToTop = -1
        }
    }

inline var View.top_toBottomViewOf: View?
    get() =null
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            topToBottom = value?.id ?: -1
            topToTop = -1
        }
    }

inline var View.top_toTopOf: String
    get() =""
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            topToTop = value.generateLayoutId()
            topToBottom = -1
        }
    }

inline var View.top_toTopViewOf: View?
    get() =null
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            topToTop = value?.id ?: -1
            topToBottom = -1
        }
    }

inline var View.end_toEndOf: String
    get() =""
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            endToEnd = value.generateLayoutId()
            endToStart = -1
        }
    }

inline var View.end_toEndViewOf: View?
    get() =null
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            endToEnd = value?.id ?: -1
            endToStart = -1
        }
    }

inline var View.end_toStartOf: String
    get() =""
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            endToStart = value.generateLayoutId()
            endToEnd = -1
        }
    }

inline var View.end_toStartViewOf: View?
    get() =null
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            endToStart = value?.id ?: -1
            endToEnd = -1
        }
    }

inline var View.bottom_toBottomOf: String
    get() =""
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            bottomToBottom = value.generateLayoutId()
            bottomToTop = -1
        }
    }

inline var View.bottom_toBottomViewOf: View?
    get() =null
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            bottomToBottom = value?.id ?: -1
            bottomToTop = -1
        }
    }

inline var View.bottom_toTopOf: String
    get() =""
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            bottomToTop = value.generateLayoutId()
            bottomToBottom = -1
        }
    }

inline var View.bottom_toTopViewOf: View?
    get() =null
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            bottomToTop = value?.id ?: -1
            bottomToBottom = -1
        }
    }

inline var View.horizontal_chain_style: Int
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            horizontalChainStyle = value
        }
    }

inline var View.vertical_chain_style: Int
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            verticalChainStyle = value
        }
    }

inline var View.horizontal_bias: Float
    get() = -1f
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            horizontalBias = value
        }
    }

inline var View.dimension_radio: String
    get() =""
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            dimensionRatio = value
        }
    }

inline var View.vertical_bias: Float
    get() =-1f
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            verticalBias = value
        }
    }

inline var View.center_horizontal: Boolean
    get() =false
    set(value) {
        if (!value) return
        start_toStartOf = parent_id
        end_toEndOf = parent_id
    }

inline var View.center_vertical: Boolean
    get() =false
    set(value) {
        if (!value) return
        top_toTopOf = parent_id
        bottom_toBottomOf = parent_id
    }

inline var View.align_vertical_to: String
    get() =""
    set(value) {
        top_toTopOf = value
        bottom_toBottomOf = value
    }

inline var View.align_horizontal_to: String
    get() =""
    set(value) {
        start_toStartOf = value
        end_toEndOf = value
    }

inline var View.width_percentage: Float
    get() =-1f
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            width = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
            matchConstraintPercentWidth = value
        }
    }

inline var View.height_percentage: Float
    get() =-1f
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            height = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
            matchConstraintPercentHeight = value
        }
    }

inline var View.gone_margin_end: Number
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            goneEndMargin = value.dp2pxI()
        }
    }

inline var View.gone_margin_start: Number
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            goneStartMargin = value.dp2pxI()
        }
    }

inline var View.gone_margin_top: Number
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            goneTopMargin = value.dp2pxI()
        }
    }

inline var View.gone_margin_bottom: Number
    get() =-1
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            goneBottomMargin = value.dp2pxI()
        }
    }

inline var View.guide_percentage: Float
    get() =-1f
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            guidePercent = value
        }
    }

inline var View.guide_orientation: Int
    get() =1
    set(value) {
        applyUpdateLayoutParams<ConstraintLayout.LayoutParams> {
            orientation = value
        }
    }

/**
 * helper class for data binding
 */
class LiveDataBinder(var liveData: LiveData<*>? = null, var action: ((Any?) -> Unit)? = null)

fun liveDataBinder(liveData: LiveData<*>?, init: LiveDataBinder.() -> Unit): LiveDataBinder =
    LiveDataBinder(liveData).apply(init)

class Binder(var data: Any?, var action: ((View, Any?) -> Unit)? = null)

//</editor-fold>