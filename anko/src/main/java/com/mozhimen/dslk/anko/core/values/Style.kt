package com.mozhimen.dslk.anko.core.values

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RatingBar
import androidx.annotation.AttrRes
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import com.mozhimen.dslk.anko.core.funs.invoke
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * @ClassName Style
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
@Suppress(
    "unused", // Type parameter is used externally for type inference. TODO: Move it on type parameter when supported in Kotlin.
)
@JvmInline
value class StyleXml<in V : View>(@AttrRes val styleAttr: Int)

@JvmInline
value class StyleAndroid(@PublishedApi internal val ctx: Context) {
    inline val progressBar get() = StyleAndroidProgressBar(ctx)
    inline val ratingBar get() = StyleAndroidRatingBar(ctx)
    inline val button get() = StyleAndroidButton(ctx)
}

@JvmInline
@OptIn(ExperimentalContracts::class)
value class StyleAndroidButton @PublishedApi internal constructor(@PublishedApi internal val ctx: Context) {
    /** Small Button style. */
    inline fun small(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = Theme.NO_THEME,
        initView: Button.() -> Unit = {}
    ): Button {
        contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
        return StyleXml<Button>(android.R.attr.buttonStyleSmall)(ctx, id, theme, initView)
    }

    /** Normal Button style. */
    inline fun default(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = Theme.NO_THEME,
        initView: Button.() -> Unit = {}
    ): Button {
        contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
        return StyleXml<Button>(android.R.attr.buttonStyle)(ctx, id, theme, initView)
    }

    /** Style for buttons without an explicit border, often used in groups. */
    inline fun borderless(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = Theme.NO_THEME,
        initView: Button.() -> Unit = {}
    ): Button {
        contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
        return StyleXml<Button>(android.R.attr.borderlessButtonStyle)(ctx, id, theme, initView)
    }

    /** Button style to inset into an EditText. */
    inline fun inset(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = Theme.NO_THEME,
        initView: Button.() -> Unit = {}
    ): Button {
        contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
        return StyleXml<Button>(android.R.attr.buttonStyleInset)(ctx, id, theme, initView)
    }
}

@JvmInline
@OptIn(ExperimentalContracts::class)
value class StyleAndroidRatingBar @PublishedApi internal constructor(@PublishedApi internal val ctx: Context) {
    inline fun small(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = Theme.NO_THEME,
        initView: RatingBar.() -> Unit = {}
    ): RatingBar {
        contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
        return StyleXml<RatingBar>(android.R.attr.ratingBarStyleSmall)(ctx, id, theme, initView)
    }

    inline fun default(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = Theme.NO_THEME,
        initView: RatingBar.() -> Unit = {}
    ): RatingBar {
        contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
        return StyleXml<RatingBar>(android.R.attr.ratingBarStyle)(ctx, id, theme, initView)
    }

    inline fun indicator(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = Theme.NO_THEME,
        initView: RatingBar.() -> Unit = {}
    ): RatingBar {
        contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
        return StyleXml<RatingBar>(android.R.attr.ratingBarStyleIndicator)(ctx, id, theme, initView)
    }
}

@JvmInline
@OptIn(ExperimentalContracts::class)
value class StyleAndroidProgressBar @PublishedApi internal constructor(@PublishedApi internal val ctx: Context) {
    inline fun small(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = Theme.NO_THEME,
        initView: ProgressBar.() -> Unit = {}
    ): ProgressBar {
        contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
        return StyleXml<ProgressBar>(android.R.attr.progressBarStyleSmall)(ctx, id, theme, initView)
    }

    inline fun default(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = Theme.NO_THEME,
        initView: ProgressBar.() -> Unit = {}
    ): ProgressBar {
        contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
        return StyleXml<ProgressBar>(android.R.attr.progressBarStyle)(ctx, id, theme, initView)
    }

    inline fun large(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = Theme.NO_THEME,
        initView: ProgressBar.() -> Unit = {}
    ): ProgressBar {
        contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
        return StyleXml<ProgressBar>(android.R.attr.progressBarStyleLarge)(ctx, id, theme, initView)
    }

    inline fun horizontal(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = Theme.NO_THEME,
        initView: ProgressBar.() -> Unit = {}
    ): ProgressBar {
        contract { callsInPlace(initView, InvocationKind.EXACTLY_ONCE) }
        return StyleXml<ProgressBar>(android.R.attr.progressBarStyleHorizontal)(ctx, id, theme, initView)
    }
}