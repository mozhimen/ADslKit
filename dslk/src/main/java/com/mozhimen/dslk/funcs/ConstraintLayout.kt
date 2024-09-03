package com.mozhimen.dslk.funcs

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintProperties
import androidx.constraintlayout.widget.ConstraintSet
import com.mozhimen.dslk.constraintLayout
import com.mozhimen.dslk.values.constraint_bottom
import com.mozhimen.dslk.values.constraint_end
import com.mozhimen.dslk.values.constraint_start
import com.mozhimen.dslk.values.constraint_top
import com.mozhimen.dslk.values.horizontal

/**
 * @ClassName ConstraintLayout
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/3
 * @Version 1.0
 */
/**
 * build a horizontal or vertical chain in [constraintLayout]
 * [startView] is the starting point of the chain
 * [endView] is the endding point of the chain
 * [views] is the body of the chain
 * [orientation] could be [horizontal] or [vertical]
 */
fun ConstraintLayout.buildChain(
    startView: View,
    views: List<View>,
    endView: View?,
    orientation: Int,
    outMarginStart: Int,
    outMarinEnd: Int,
    innerMargin: Int
) {
    if (views.isEmpty()) return
    var preView = startView
    val startSide = if (orientation == horizontal) constraint_start else constraint_top
    val endSide = if (orientation == horizontal) constraint_end else constraint_bottom

    val firstView = views.first()
    val isStartViewParent = firstView.isChildOf(startView)
    val isEndViewParent = firstView.isChildOf(endView)

    // deal with the first view
    ConstraintProperties(firstView)
        .connect(
            startSide,
            if (isStartViewParent) ConstraintProperties.PARENT_ID else preView.id,
            if (isStartViewParent) startSide else endSide,
            outMarginStart
        )
        .apply()

    preView = firstView

    (1 until views.size).map { views[it] }.forEach { currentView ->
        ConstraintProperties(currentView)
            .connect(startSide, preView.id, endSide, innerMargin)
            .apply()
        ConstraintProperties(preView)
            .connect(endSide, currentView.id, startSide, innerMargin)
            .apply()
        preView = currentView
    }

    // deal with the last view
    ConstraintProperties(preView)
        .connect(
            endSide,
            if (isEndViewParent) ConstraintProperties.PARENT_ID else endView?.id
                ?: ConstraintSet.UNSET,
            if (isEndViewParent) endSide else startSide,
            outMarinEnd
        )
        .apply()
}