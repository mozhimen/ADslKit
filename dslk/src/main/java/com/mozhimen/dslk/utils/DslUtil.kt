package com.mozhimen.dslk.utils

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mozhimen.dslk.cons.CDsl
import kotlin.math.abs

/**
 * @ClassName DslUtil
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/9/2 22:53
 * @Version 1.0
 */
fun <T : View> View.find(id: String): T? =
    findViewById(id.generateLayoutId())

fun <T : View> AppCompatActivity.find(id: String): T? =
    findViewById(id.generateLayoutId())

fun String.generateLayoutId(): Int {
    var id = hashCode()
    if (this == CDsl.parent_id) id = 0
    return abs(id)
}