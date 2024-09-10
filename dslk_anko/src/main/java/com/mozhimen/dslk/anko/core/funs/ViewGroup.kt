package com.mozhimen.dslk.anko.core.funs

import android.view.View
import android.view.ViewGroup

/**
 * @ClassName ViewGroup
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */


@Suppress("NOTHING_TO_INLINE")
inline fun <V : View> ViewGroup.add(
    view: V,
    lp: ViewGroup.LayoutParams
): V = view.also { addView(it, lp) }

@Suppress("CONFLICTING_OVERLOADS")
@JvmName("addBefore")
fun <V : View> ViewGroup.add(
    view: V,
    lp: ViewGroup.LayoutParams,
    beforeChild: View
): V {
    val index = indexOfChild(beforeChild).also {
        check(it != -1) { "Value passed in beforeChild is not a child of the ViewGroup!" }
    }
    return view.also { addView(it, index, lp) }
}

@Suppress("CONFLICTING_OVERLOADS")
@JvmName("addAfter")
fun <V : View> ViewGroup.add(
    view: V,
    lp: ViewGroup.LayoutParams,
    afterChild: View
): V {
    val index = indexOfChild(afterChild).also {
        check(it != -1) { "Value passed in beforeChild is not a child of the ViewGroup!" }
    } + 1
    return view.also { addView(it, index, lp) }
}