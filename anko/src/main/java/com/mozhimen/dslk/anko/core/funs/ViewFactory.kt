package com.mozhimen.dslk.anko.core.funs

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.AttrRes
import com.mozhimen.dslk.anko.core.commons.ViewFactory

/**
 * @ClassName ViewFactory
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
inline fun <reified V : View> ViewFactory.getThemeAttrStyledView(
    context: Context,
    attrs: AttributeSet?,
    @AttrRes styleThemeAttribute: Int
): V =
    getThemeAttributeStyledView(V::class.java, context, attrs, styleThemeAttribute)
