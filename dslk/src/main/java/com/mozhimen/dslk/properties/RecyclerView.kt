package com.mozhimen.dslk.properties

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mozhimen.dslk.funcs.setOnItemClickListener
import com.mozhimen.dslk.funcs.setOnItemLongClickListener

/**
 * @ClassName RecyclerView
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/9/2 23:09
 * @Version 1.0
 */
var RecyclerView.onItemClick: (View, Int, Float, Float) -> Boolean
    get() = { _, _, _, _ -> false }
    set(value) {
        setOnItemClickListener(value)
    }

var RecyclerView.onItemLongClick: (View, Int, Float, Float) -> Unit
    get() = { _, _, _, _ -> }
    set(value) {
        setOnItemLongClickListener(value)
    }

var RecyclerView.hasFixedSize: Boolean
    get() = false
    set(value) {
        setHasFixedSize(value)
    }