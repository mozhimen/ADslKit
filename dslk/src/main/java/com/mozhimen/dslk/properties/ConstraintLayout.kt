package com.mozhimen.dslk.properties

import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.widget.Barrier
import androidx.constraintlayout.widget.ConstraintHelper
import com.mozhimen.dslk.utils.generateLayoutId
import com.mozhimen.kotlin.utilk.android.util.dp2pxI

/**
 * @ClassName ConstraintLayout
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/9/2 23:08
 * @Version 1.0
 */
inline var Barrier.barrier_direction: Int
    get() = -1
    set(value) {
        type = value
    }

///////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////
inline var ConstraintHelper.constraint_referenceIds: String
    get() = ""
    set(value) {
        referencedIds = value.split(",").map { it.generateLayoutId() }.toIntArray()
    }
inline var ConstraintHelper.reference_ids: List<String>
    get() = emptyList()
    set(value) {
        referencedIds = value.map { it.generateLayoutId() }.toIntArray()
    }

///////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////
inline var Flow.flow_horizontalGap: Int
    get() = 0
    set(value) {
        setHorizontalGap(value.dp2pxI())
    }

inline var Flow.flow_verticalGap: Int
    get() = 0
    set(value) {
        setVerticalGap(value.dp2pxI())
    }

inline var Flow.flow_wrapMode: Int
    get() = 0
    set(value) {
        setWrapMode(value)
    }

inline var Flow.flow_padding: Int
    get() = 0
    set(value) {
        setPadding(value.dp2pxI())
    }
inline var Flow.flow_paddingRight: Int
    get() = 0
    set(value) {
        setPaddingRight(value.dp2pxI())
    }

inline var Flow.flow_paddingTop: Int
    get() = 0
    set(value) {
        setPaddingTop(value.dp2pxI())
    }
inline var Flow.flow_paddingBottom: Int
    get() = 0
    set(value) {
        setPaddingBottom(value.dp2pxI())
    }
inline var Flow.flow_paddingLeft: Int
    get() = 0
    set(value) {
        setPaddingLeft(value.dp2pxI())
    }
inline var Flow.flow_orientation: Int
    get() = 0
    set(value) {
        setOrientation(value)
    }
inline var Flow.flow_horizontalStyle: Int
    get() = 0
    set(value) {
        setHorizontalStyle(value)
    }
inline var Flow.flow_verticalStyle: Int
    get() = 0
    set(value) {
        setVerticalStyle(value)
    }
inline var Flow.flow_horizontalBias: Float
    get() = 0f
    set(value) {
        setHorizontalBias(value)
    }
inline var Flow.flow_verticalBias: Float
    get() = 0f
    set(value) {
        setVerticalBias(value)
    }
inline var Flow.flow_horizontalAlign: Int
    get() = 0
    set(value) {
        setHorizontalAlign(value)
    }
inline var Flow.flow_verticalAlign: Int
    get() = 0
    set(value) {
        setVerticalAlign(value)
    }
inline var Flow.flow_maxElementWrap: Int
    get() = 0
    set(value) {
        setMaxElementsWrap(value)
    }