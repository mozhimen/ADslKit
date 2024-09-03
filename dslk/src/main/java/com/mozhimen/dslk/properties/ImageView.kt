package com.mozhimen.dslk.properties

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources

/**
 * @ClassName ImageView
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/9/2 23:05
 * @Version 1.0
 */
inline var ImageView.image_src: Int
    get() =-1
    set(value) {
        setImageDrawable(AppCompatResources.getDrawable(context, value))
    }

inline var ImageView.image_drawable: Drawable?
    get() =null
    set(value) {
        setImageDrawable(value)
    }

inline var ImageView.image_bitmap: Bitmap?
    get() =null
    set(value) {
        setImageBitmap(value)
    }