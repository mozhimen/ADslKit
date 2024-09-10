package com.mozhimen.dslk.anko.core.commons

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.AttrRes
import com.mozhimen.dslk.anko.core.experimental.ViewFactoryImpl

/**
 * @ClassName ViewFactory
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
//@InternalSplittiesApi
interface ViewFactory {
    companion object {
        val appInstance: ViewFactory = ViewFactoryImpl.appInstance
    }

    operator fun <V : View> invoke(clazz: Class<out V>, context: Context): V
    fun <V : View> getThemeAttributeStyledView(
        clazz: Class<out V>,
        context: Context,
        @Suppress("UNUSED_PARAMETER") attrs: AttributeSet?,
        @AttrRes styleThemeAttribute: Int
    ): V
}