package com.mozhimen.dslk

import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.widget.Barrier
import androidx.constraintlayout.widget.ConstraintHelper

/**
 * @ClassName ConstraintLayout
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/9/2 23:08
 * @Version 1.0
 */
inline var Barrier.barrier_direction: Int
    get() {
        return -1
    }
    set(value) {
        type = value
    }

///////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////
inline var ConstraintHelper.referenceIds: String
    get() {
        return ""
    }
    set(value) {
        referencedIds = value.split(",").map { it.toLayoutId() }.toIntArray()
    }
inline var ConstraintHelper.reference_ids: List<String>
    get() {
        return emptyList()
    }
    set(value) {
        referencedIds = value.map { it.toLayoutId() }.toIntArray()
    }

///////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////
inline var Flow.flow_horizontalGap: Int
    get() {
        return 0
    }
    set(value) {
        setHorizontalGap(value.dp)
    }

inline var Flow.flow_verticalGap: Int
    get() {
        return 0
    }
    set(value) {
        setVerticalGap(value.dp)
    }

inline var Flow.flow_wrapMode: Int
    get() {
        return 0
    }
    set(value) {
        setWrapMode(value)
    }

inline var Flow.flow_padding: Int
    get() {
        return 0
    }
    set(value) {
        setPadding(value.dp)
    }
inline var Flow.flow_paddingRight: Int
    get() {
        return 0
    }
    set(value) {
        setPaddingRight(value.dp)
    }

inline var Flow.flow_paddingTop: Int
    get() {
        return 0
    }
    set(value) {
        setPaddingTop(value.dp)
    }
inline var Flow.flow_paddingBottom: Int
    get() {
        return 0
    }
    set(value) {
        setPaddingBottom(value.dp)
    }
inline var Flow.flow_paddingLeft: Int
    get() {
        return 0
    }
    set(value) {
        setPaddingLeft(value.dp)
    }
inline var Flow.flow_orientation: Int
    get() {
        return 0
    }
    set(value) {
        setOrientation(value)
    }
inline var Flow.flow_horizontalStyle: Int
    get() {
        return 0
    }
    set(value) {
        setHorizontalStyle(value)
    }
inline var Flow.flow_verticalStyle: Int
    get() {
        return 0
    }
    set(value) {
        setVerticalStyle(value)
    }
inline var Flow.flow_horizontalBias: Float
    get() {
        return 0f
    }
    set(value) {
        setHorizontalBias(value)
    }
inline var Flow.flow_verticalBias: Float
    get() {
        return 0f
    }
    set(value) {
        setVerticalBias(value)
    }
inline var Flow.flow_horizontalAlign: Int
    get() {
        return 0
    }
    set(value) {
        setHorizontalAlign(value)
    }
inline var Flow.flow_verticalAlign: Int
    get() {
        return 0
    }
    set(value) {
        setVerticalAlign(value)
    }
inline var Flow.flow_maxElementWrap: Int
    get() {
        return 0
    }
    set(value) {
        setMaxElementsWrap(value)
    }