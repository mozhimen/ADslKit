package com.mozhimen.dslk.anko.core.proterties

import android.view.View
import android.view.ViewGroup
import androidx.core.view.get

/**
 * @ClassName ViewGroup
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
inline val ViewGroup.lastChild: View
    get() = this[childCount - 1]