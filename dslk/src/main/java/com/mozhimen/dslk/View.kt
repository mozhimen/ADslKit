package com.mozhimen.dslk

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.text.Editable
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.widget.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.MarginLayoutParamsCompat
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.mozhimen.dslk.utils.generateLayoutId

//<editor-fold desc="View extend field">
inline var View.layout_id: String
    get() {
        return ""
    }
    set(value) {
        id = value.generateLayoutId()
    }

inline var View.layout_width: Number
    get() {
        return 0
    }
    set(value) {
        val w = if (value.dp > 0) value.dp else value.toInt()
        val h = layoutParams?.height ?: 0
        updateLayoutParams<ViewGroup.LayoutParams> {
            width = w
            height = h
        }
    }

inline var View.layout_height: Number
    get() {
        return 0
    }
    set(value) {
        val w = layoutParams?.width ?: 0
        val h = if (value.dp > 0) value.dp else value.toInt()
        updateLayoutParams<ViewGroup.LayoutParams> {
            width = w
            height = h
        }
    }

inline var View.layout_visibility: Int
    get() {
        return -1
    }
    set(value) {
        visibility = value
    }

//////////////////////////////////////////////////////////////////////////////

inline var View.padding_top: Number
    get() {
        return 0
    }
    set(value) {
        setPadding(paddingLeft, value.dp, paddingRight, paddingBottom)
    }

inline var View.padding_bottom: Number
    get() {
        return 0
    }
    set(value) {
        setPadding(paddingLeft, paddingTop, paddingRight, value.dp)
    }

inline var View.padding_start: Number
    get() {
        return 0
    }
    set(value) {
        setPadding(value.dp, paddingTop, paddingRight, paddingBottom)
    }

inline var View.padding_end: Number
    get() {
        return 0
    }
    set(value) {
        setPadding(paddingLeft, paddingTop, value.dp, paddingBottom)
    }

inline var View.padding: Number
    get() {
        return 0
    }
    set(value) {
        setPadding(value.dp, value.dp, value.dp, value.dp)
    }

inline var View.padding_horizontal: Number
    get() {
        return 0
    }
    set(value) {
        padding_start = value
        padding_end = value
    }

inline var View.padding_vertical: Number
    get() {
        return 0
    }
    set(value) {
        padding_top = value
        padding_bottom = value
    }

inline var View.background_color: String
    get() {
        return ""
    }
    set(value) {
        setBackgroundColor(Color.parseColor(value))
    }

inline var View.background_color_res: Int
    get() {
        return -1
    }
    set(value) {
        setBackgroundColor(ContextCompat.getColor(context, value))
    }

inline var View.background_res: Int
    get() {
        return -1
    }
    set(value) {
        background = AppCompatResources.getDrawable(context, value)
    }

inline var View.background_vector: Int
    get() {
        return -1
    }
    set(value) {
        val drawable = VectorDrawableCompat.create(context.getResources(), value, null)
        background = drawable
    }

inline var View.background_drawable: Drawable?
    get() {
        return null
    }
    set(value) {
        value?.let { background = it }
    }

inline var View.background_drawable_state_list: List<Pair<IntArray, Drawable>>
    get() {
        return listOf(intArrayOf() to GradientDrawable())
    }
    set(value) {
        background = StateListDrawable().apply {
            value.forEach { pair ->
                addState(pair.first, pair.second)
            }
        }
    }

inline var View.margin_top: Number
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = value.dp
        }
    }

inline var View.margin_bottom: Number
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            bottomMargin = value.dp
        }
    }

inline var View.margin_start: Number
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            MarginLayoutParamsCompat.setMarginStart(this, value.dp)
        }
    }

inline var View.margin_end: Number
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            MarginLayoutParamsCompat.setMarginEnd(this, value.dp)
        }
    }

inline var View.margin_horizontal: Number
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            MarginLayoutParamsCompat.setMarginEnd(this, value.dp)
            MarginLayoutParamsCompat.setMarginStart(this, value.dp)
        }
    }

inline var View.margin_vertical: Number
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = value.dp
            bottomMargin = value.dp
        }
    }

//////////////////////////////////////////////////////////////////////////////
//RelativeLayout
//////////////////////////////////////////////////////////////////////////////

inline var View.alignParentStart: Boolean
    get() {
        return false
    }
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
    get() {
        return false
    }
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
    get() {
        return false
    }
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
    get() {
        return false
    }
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
    get() {
        return 0f
    }
    set(value) {
        updateLayoutParams<LinearLayout.LayoutParams> {
            gravity = (layoutParams as? LinearLayout.LayoutParams)?.gravity ?: -1
            weight = value
        }
    }
inline var View.layout_gravity: Int
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<LinearLayout.LayoutParams> {
            weight = (layoutParams as? LinearLayout.LayoutParams)?.weight ?: 0f
            gravity = value
        }
    }

//////////////////////////////////////////////////////////////////////////////
//ConstraintLayout
//////////////////////////////////////////////////////////////////////////////

inline var View.toCircleOf: String
    get() {
        return ""
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            circleConstraint = value.toLayoutId()
        }
    }

inline var View.circle_radius: Int
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            circleRadius = value.dp
        }
    }

inline var View.circle_angle: Float
    get() {
        return -1f
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            circleAngle = value
        }
    }

inline var View.start_toStartOf: String
    get() {
        return ""
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            startToStart = value.toLayoutId()
            startToEnd = -1
        }
    }

inline var View.start_toStartViewOf: View?
    get() {
        return null
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            startToStart = value?.id ?: -1
            startToEnd = -1
        }
    }

inline var View.start_toEndOf: String
    get() {
        return ""
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            startToEnd = value.toLayoutId()
            startToStart = -1
        }
    }

inline var View.start_toEndViewOf: View?
    get() {
        return null
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            startToEnd = value?.id ?: -1
            startToStart = -1
        }
    }

inline var View.top_toBottomOf: String
    get() {
        return ""
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            topToBottom = value.toLayoutId()
            topToTop = -1
        }
    }

inline var View.top_toBottomViewOf: View?
    get() {
        return null
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            topToBottom = value?.id ?: -1
            topToTop = -1
        }
    }

inline var View.top_toTopOf: String
    get() {
        return ""
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            topToTop = value.toLayoutId()
            topToBottom = -1
        }
    }

inline var View.top_toTopViewOf: View?
    get() {
        return null
    }
    set(value) {

        updateLayoutParams<ConstraintLayout.LayoutParams> {
            topToTop = value?.id ?: -1
            topToBottom = -1
        }
    }

inline var View.end_toEndOf: String
    get() {
        return ""
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            endToEnd = value.toLayoutId()
            endToStart = -1
        }
    }

inline var View.end_toEndViewOf: View?
    get() {
        return null
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            endToEnd = value?.id ?: -1
            endToStart = -1
        }
    }

inline var View.end_toStartOf: String
    get() {
        return ""
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            endToStart = value.toLayoutId()
            endToEnd = -1
        }
    }

inline var View.end_toStartViewOf: View?
    get() {
        return null
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            endToStart = value?.id ?: -1
            endToEnd = -1
        }
    }

inline var View.bottom_toBottomOf: String
    get() {
        return ""
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            bottomToBottom = value.toLayoutId()
            bottomToTop = -1
        }
    }

inline var View.bottom_toBottomViewOf: View?
    get() {
        return null
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            bottomToBottom = value?.id ?: -1
            bottomToTop = -1
        }
    }

inline var View.bottom_toTopOf: String
    get() {
        return ""
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            bottomToTop = value.toLayoutId()
            bottomToBottom = -1
        }
    }

inline var View.bottom_toTopViewOf: View?
    get() {
        return null
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            bottomToTop = value?.id ?: -1
            bottomToBottom = -1
        }
    }

inline var View.horizontal_chain_style: Int
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            horizontalChainStyle = value
        }
    }

inline var View.vertical_chain_style: Int
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            verticalChainStyle = value
        }
    }

inline var View.horizontal_bias: Float
    get() {
        return -1f
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            horizontalBias = value
        }
    }

inline var View.dimension_radio: String
    get() {
        return ""
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            dimensionRatio = value
        }
    }

inline var View.vertical_bias: Float
    get() {
        return -1f
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            verticalBias = value
        }
    }

inline var View.center_horizontal: Boolean
    get() {
        return false
    }
    set(value) {
        if (!value) return
        start_toStartOf = parent_id
        end_toEndOf = parent_id
    }

inline var View.center_vertical: Boolean
    get() {
        return false
    }
    set(value) {
        if (!value) return
        top_toTopOf = parent_id
        bottom_toBottomOf = parent_id
    }

inline var View.align_vertical_to: String
    get() {
        return ""
    }
    set(value) {
        top_toTopOf = value
        bottom_toBottomOf = value
    }

inline var View.align_horizontal_to: String
    get() {
        return ""
    }
    set(value) {
        start_toStartOf = value
        end_toEndOf = value
    }

inline var View.width_percentage: Float
    get() {
        return -1f
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            width = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
            matchConstraintPercentWidth = value
        }
    }

inline var View.height_percentage: Float
    get() {
        return -1f
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            height = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
            matchConstraintPercentHeight = value
        }
    }

inline var View.gone_margin_end: Number
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            goneEndMargin = value.dp
        }
    }

inline var View.gone_margin_start: Number
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            goneStartMargin = value.dp
        }
    }

inline var View.gone_margin_top: Number
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            goneTopMargin = value.dp
        }
    }

inline var View.gone_margin_bottom: Number
    get() {
        return -1
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            goneBottomMargin = value.dp
        }
    }

inline var View.guide_percentage: Float
    get() {
        return -1f
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            guidePercent = value
        }
    }

inline var View.guide_orientation: Int
    get() {
        return 1
    }
    set(value) {
        updateLayoutParams<ConstraintLayout.LayoutParams> {
            orientation = value
        }
    }



/**
 * bind async data
 */
inline var View.bindLiveData: LiveDataBinder?
    get() {
        return null
    }
    set(value) {
        observe(value?.liveData) {
            value?.action?.invoke(it)
        }
    }

/**
 * old fashion for binding data
 */
inline var View.bind: Binder?
    get() {
        return null
    }
    set(value) {
        value?.action?.invoke(this, value.data)
    }

/**
 * bind sync data
 */
inline var View.bindData: () -> Unit
    get() {
        return {}
    }
    set(value) {
        value()
    }

inline var View.fitsSystemWindows: Boolean
    get() {
        return false
    }
    set(value) {
        fitsSystemWindows = value
    }

/**
 * use this attribute to build shape dynamically, getting rid of "shape.xml"
 */
inline var View.shape: GradientDrawable
    get() {
        return GradientDrawable()
    }
    set(value) {
        background = value
    }

var View.onClick: (View) -> Unit
    get() {
        return {}
    }
    set(value) {
        setOnClickListener { v -> value(v) }
    }

var View.shakelessClick: (View) -> Unit
    get() {
        return {}
    }
    set(value) {
        setShakelessClickListener(1000) {
            value(it)
        }
    }

//</editor-fold>