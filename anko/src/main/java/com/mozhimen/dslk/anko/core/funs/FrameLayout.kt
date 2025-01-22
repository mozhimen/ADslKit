package com.mozhimen.dslk.anko.core.funs

import android.annotation.SuppressLint
import android.view.Gravity
import android.widget.FrameLayout
import com.mozhimen.dslk.anko.core.proterties.wrapContent
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * @ClassName FrameLayout
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
/**
 * Default gravity is treated by FrameLayout as: [Gravity.TOP] or [Gravity.START].
 */
@OptIn(ExperimentalContracts::class)
inline fun FrameLayout.lParams(
    width: Int = wrapContent,
    height: Int = wrapContent,
    @SuppressLint("InlinedApi")
    gravity: Int = FrameLayout.LayoutParams.UNSPECIFIED_GRAVITY,
    initParams: FrameLayout.LayoutParams.() -> Unit = {}
): FrameLayout.LayoutParams {
    contract { callsInPlace(initParams, InvocationKind.EXACTLY_ONCE) }
    return FrameLayout.LayoutParams(width, height).also {
        it.gravity = gravity
    }.apply(initParams)
}