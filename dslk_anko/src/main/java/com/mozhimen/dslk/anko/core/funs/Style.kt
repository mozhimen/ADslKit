package com.mozhimen.dslk.anko.core.funs

import android.content.Context
import android.util.TypedValue
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import com.mozhimen.dslk.anko.core.proterties.viewFactory
import com.mozhimen.dslk.anko.core.values.StyleXml
import com.mozhimen.dslk.anko.core.values.Theme

/**
 * @ClassName Style
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
inline operator fun <reified V : View> StyleXml<V>.invoke(
    ctx: Context,
    @IdRes id: Int = View.NO_ID,
    @StyleRes theme: Int = Theme.NO_THEME,
    initView: V.() -> Unit = {}
): V =
    ctx.viewFactory.getThemeAttrStyledView<V>(ctx.wrapCtxIfNeeded(theme), null, styleAttr).also {
        it.id = id
    }.apply(initView)

internal fun TypedValue.unexpectedThemeAttributeTypeErrorMessage(expectedKind: String): String {
    val article = when (expectedKind.firstOrNull() ?: ' ') {
        in "aeio" -> "an"
        else -> "a"
    }
    return "Expected $article $expectedKind theme attribute but got type 0x${type.toString(16)} " +
            "(see what it corresponds to in android.util.TypedValue constants)"
}