package com.mozhimen.dslk.anko.core.proterties

import android.annotation.SuppressLint
import android.content.Context
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import com.mozhimen.dslk.anko.core.commons.ViewFactory
import com.mozhimen.dslk.anko.core.funs.withResolvedThemeAttribute
import com.mozhimen.dslk.anko.core.values.Layout

/**
 * @ClassName Context
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
//@InternalSplittiesApi
val Context.viewFactory: ViewFactory
    @SuppressLint("WrongConstant")
    get() = try {
        getSystemService(Layout.VIEW_FACTORY) as ViewFactory? ?: ViewFactory.appInstance
    } catch (t: Throwable) {
        ViewFactory.appInstance
    }

