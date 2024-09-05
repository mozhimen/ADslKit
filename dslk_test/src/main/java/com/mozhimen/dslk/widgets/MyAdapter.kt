package com.mozhimen.dslk.widgets

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mozhimen.dslk.mos.User
import com.mozhimen.dslk.*
import com.mozhimen.dslk.properties.align_vertical_to
import com.mozhimen.dslk.properties.background_color_str
import com.mozhimen.dslk.properties.end_toEndOf
import com.mozhimen.dslk.properties.layout_height
import com.mozhimen.dslk.properties.layout_id
import com.mozhimen.dslk.properties.layout_width
import com.mozhimen.dslk.properties.margin_end
import com.mozhimen.dslk.properties.margin_start
import com.mozhimen.dslk.properties.margin_top
import com.mozhimen.dslk.properties.start_toStartOf
import com.mozhimen.dslk.properties.textColor
import com.mozhimen.dslk.properties.top_toBottomOf
import com.mozhimen.dslk.properties.top_toTopOf
import com.mozhimen.dslk.values.gravity_center
import com.mozhimen.dslk.values.match_parent
import com.mozhimen.dslk.values.parent_id
import com.mozhimen.dslk.values.wrap_content

/**
 * show how use layout dsl in [recyclerView.Adapter]
 */
class MyAdapter(var myBean: List<User>?) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = parent.context.run {
            constraintLayout {
                layout_height = 90
                layout_width = match_parent
                margin_end = 20
                margin_start =20
                background_color_str = "#eeeeee"

                textView {
                    layout_id = "tvContent"
                    layout_width = match_parent
                    layout_height = wrap_content
                    textSize = 15f
                    gravity = gravity_center
                    start_toStartOf = parent_id
                    top_toTopOf = parent_id
                }

                view {
                    layout_id = "vDivider"
                    layout_width = match_parent
                    layout_height = 1
                    top_toBottomOf = "tvContent"
                    background_color_str = "#888888"
                }

                textView {
                    layout_id = "tvStart"
                    layout_width = wrap_content
                    layout_height = wrap_content
                    textSize = 26f
                    textColor ="#3F4658"
                    text = "start"
                    start_toStartOf = parent_id
                    top_toBottomOf = "vDivider"
                    margin_top = 20
                }

                textView {
                    layout_id = "tvEnd"
                    layout_width = wrap_content
                    layout_height = wrap_content
                    textSize = 26f
                    textColor ="#3F4658"
                    text = "end"
                    end_toEndOf = parent_id
                    align_vertical_to = "tvStart"
                }


            }
        }
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return myBean?.size ?: 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        myBean?.get(position)?.let { holder.bind(it) }
    }
}