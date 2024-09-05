package com.mozhimen.dslk.widgets

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mozhimen.dslk.mos.User
import com.mozhimen.dslk.utils.find

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(user: User?) {
        itemView.apply {
            find<TextView>("tvContent")?.apply {
                text = user?.name ?: "no name"
                val color = if (user?.gender == 1) Color.parseColor("#b300ff00") else Color.parseColor("#b3ff00ff")
                setBackgroundColor(color)
            }
        }
    }
}