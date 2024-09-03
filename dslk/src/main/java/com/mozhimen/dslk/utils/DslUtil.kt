package com.mozhimen.dslk.utils

import com.mozhimen.dslk.cons.CDsl
import kotlin.math.abs

/**
 * @ClassName DslUtil
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/9/2 22:53
 * @Version 1.0
 */
fun String.generateLayoutId(): Int {
    var id = hashCode()
    if (this == CDsl.parent_id) id = 0
    return abs(id)
}