package com.mozhimen.dslk

import android.widget.Button

/**
 * @ClassName Button
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/9/2 23:06
 * @Version 1.0
 */
inline var Button.textAllCaps: Boolean
    get() {
        return false
    }
    set(value) {
        isAllCaps = value
    }
