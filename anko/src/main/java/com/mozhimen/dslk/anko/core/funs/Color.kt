package com.mozhimen.dslk.anko.core.funs

import android.content.Context
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import com.mozhimen.kotlin.utilk.wrapper.UtilKRes

/**
 * @ClassName Color
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/11
 * @Version 1.0
 */
@ColorInt
fun Context.color(@ColorRes colorRes: Int): Int =
    UtilKRes.gainColor(colorRes)

@ColorInt
fun Context.styledColor(@AttrRes attr: Int): Int = withResolvedThemeAttribute(attr) {
    when {
        type in TypedValue.TYPE_FIRST_COLOR_INT..TypedValue.TYPE_LAST_COLOR_INT -> data
        type == TypedValue.TYPE_STRING && string.startsWith("res/color/") -> color(resourceId)
        else -> throw IllegalArgumentException(unexpectedThemeAttributeTypeErrorMessage(expectedKind = "color"))
    }
}

inline fun Fragment.styledColor(@AttrRes attr: Int) = context!!.styledColor(attr)
inline fun View.styledColor(@AttrRes attr: Int) = context.styledColor(attr)