package com.mozhimen.dslk

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
inline var ImageView.src: Int
    get() {
        return -1
    }
    set(value) {
        setImageDrawable(AppCompatResources.getDrawable(context, value))
    }

inline var ImageView.imageDrawable: Drawable?
    get() {
        return null
    }
    set(value) {
        setImageDrawable(value)
    }

inline var ImageView.bitmap: Bitmap?
    get() {
        return null
    }
    set(value) {
        setImageBitmap(value)
    }