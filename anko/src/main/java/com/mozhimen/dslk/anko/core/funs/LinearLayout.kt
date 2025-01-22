package com.mozhimen.dslk.anko.core.funs

import android.widget.LinearLayout
import com.mozhimen.dslk.anko.core.proterties.wrapContent
import com.mozhimen.kotlin.elemk.commons.IExt_Listener
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * @ClassName LinearLayout
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
@OptIn(ExperimentalContracts::class)
inline fun LinearLayout.lParams(
    width: Int = wrapContent,
    height: Int = wrapContent,
    initParams: IExt_Listener<LinearLayout.LayoutParams> = {}
): LinearLayout.LayoutParams {
    contract { callsInPlace(initParams, InvocationKind.EXACTLY_ONCE) }
    return LinearLayout.LayoutParams(width, height).apply(initParams)
}

@OptIn(ExperimentalContracts::class)
inline fun LinearLayout.lParams(
    width: Int = wrapContent,
    height: Int = wrapContent,
    gravity: Int = -1,
    weight: Float = 0f,
    initParams: IExt_Listener<LinearLayout.LayoutParams> = {}
): LinearLayout.LayoutParams {
    contract { callsInPlace(initParams, InvocationKind.EXACTLY_ONCE) }
    return LinearLayout.LayoutParams(width, height).also {
        it.gravity = gravity
        it.weight = weight
    }.apply(initParams)
}