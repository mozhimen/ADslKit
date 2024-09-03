package com.mozhimen.dslk.properties

import androidx.core.widget.NestedScrollView

/**
 * @ClassName NestedScrollView
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/9/2 23:07
 * @Version 1.0
 */
inline var NestedScrollView.fadeScrollBar: Boolean
    get() = false
    set(value) {
        isScrollbarFadingEnabled = true
    }