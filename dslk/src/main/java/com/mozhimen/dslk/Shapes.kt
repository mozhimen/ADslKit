package com.mozhimen.dslk

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.os.Build
import androidx.annotation.RequiresApi
import com.mozhimen.kotlin.utilk.android.util.dp2px
import com.mozhimen.kotlin.utilk.android.util.dp2pxI

/**
 * helper attribute for building [GradientDrawable]
 */
inline var GradientDrawable.solid_color: String
    get() =""
    set(value) {
        setColor(Color.parseColor(value))
    }

/**
 * color res should be returned by ContextCompat.getColor()
 */
inline var GradientDrawable.solid_color_res: Int
    get() =-1
    set(value) {
        setColor(value)
    }

inline var GradientDrawable.corner_radius: Int
    get() =-1
    set(value) {
        cornerRadius = value.dp2px()
    }

inline var GradientDrawable.corner_radii: IntArray
    get() =intArrayOf()
    set(value) {
        cornerRadii = value.map { it.dp2px() }.toFloatArray()
    }

inline var GradientDrawable.gradient_colors: List<String>
    get() =emptyList()
    set(value) {
        colors = value.map { Color.parseColor(it) }.toIntArray()
    }

/**
 * color res should be returned by ContextCompat.getColor()
 */
inline var GradientDrawable.gradient_colors_res: List<Int>
    get() =emptyList()
    set(value) {
        colors = value.toIntArray()
    }

inline var GradientDrawable.padding_start: Int
    get() =-1
    @RequiresApi(Build.VERSION_CODES.Q)
    set(value) {
        val paddingRect = Rect().also { getPadding(it) }
        setPadding(value.dp2pxI(), paddingRect.top, paddingRect.right, paddingRect.bottom)
    }

inline var GradientDrawable.padding_end: Int
    get() =-1
    @RequiresApi(Build.VERSION_CODES.Q)
    set(value) {
        val paddingRect = Rect().also { getPadding(it) }
        setPadding(paddingRect.left, paddingRect.top, value.dp2pxI(), paddingRect.bottom)
    }

inline var GradientDrawable.padding_top: Int
    get() =-1
    @RequiresApi(Build.VERSION_CODES.Q)
    set(value) {
        val paddingRect = Rect().also { getPadding(it) }
        setPadding(paddingRect.left, value.dp2pxI(), paddingRect.right, paddingRect.bottom)
    }

inline var GradientDrawable.padding_bottom: Int
    get() =-1
    @RequiresApi(Build.VERSION_CODES.Q)
    set(value) {
        val paddingRect = Rect().also { getPadding(it) }
        setPadding(paddingRect.left, paddingRect.top, paddingRect.right, value.dp2pxI())
    }

inline var GradientDrawable.strokeAttr: Stroke?
    get() =null
    set(value) {
        value?.apply { setStroke(width.toFloat().dp2pxI(), Color.parseColor(color), dashWidth.dp2px(), dashGap.dp2px()) }
    }

inline var GradientDrawable.strokeAttr_res: Stroke?
    get() =null
    set(value) {
        value?.apply { setStroke(width.toFloat().dp2pxI(), color_res, dashWidth.dp2px(), dashGap.dp2px()) }
    }

inline var GradientDrawable.color_state_list: List<Pair<IntArray, String>>
    get() =listOf(intArrayOf() to "#000000")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(value) {
        val states = mutableListOf<IntArray>()
        val colors = mutableListOf<Int>()
        value.forEach { pair ->
            states.add(pair.first)
            colors.add(Color.parseColor(pair.second))
        }
        color = ColorStateList(states.toTypedArray(), colors.toIntArray())
    }

/**
 * color res should be returned by ContextCompat.getColor()
 */
inline var GradientDrawable.color_state_list_res: List<Pair<IntArray, Int>>
    get() =listOf(intArrayOf() to 0)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(value) {
        val states = mutableListOf<IntArray>()
        val colors = mutableListOf<Int>()
        value.forEach { pair ->
            states.add(pair.first)
            colors.add(pair.second)
        }
        color = ColorStateList(states.toTypedArray(), colors.toIntArray())
    }

inline var StateListDrawable.items: Map<IntArray, Drawable>
    get() {
        return emptyMap()
    }
    set(value) {
        value.forEach { entry -> addState(entry.key, entry.value) }
    }

/**
 * helper function for building [GradientDrawable]
 */
inline fun shape(init: GradientDrawable.() -> Unit) = GradientDrawable().apply(init)

/**
 * helper function for building [StateListDrawable]
 */
inline fun selector(init: StateListDrawable.() -> Unit) = StateListDrawable().apply(init)

/**
 * helper class for set stroke for [GradientDrawable]
 * color res should be returned by ContextCompat.getColor()
 */
data class Stroke(
    var width: Number = 0f,
    var color: String = "#000000",
    var color_res:Int = 0,
    var dashWidth: Float = 0f,
    var dashGap: Float = 0f
)
