package com.mozhimen.dslk.anko.core.proterties

import android.app.Activity
import android.view.View
import com.mozhimen.dslk.anko.core.values.Layout
import kotlin.DeprecationLevel.HIDDEN

/**
 * @ClassName Activity
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
/**
 * Usage example:
 * `@Deprecated(NO_GETTER, level = DeprecationLevel.HIDDEN) get() = noGetter`
 */
@PublishedApi
internal inline val noGetter: Nothing
    get() = throw UnsupportedOperationException(Layout.NO_GETTER)

inline var Activity.contentView: View
    @Deprecated(Layout.NO_GETTER, level = HIDDEN) get() = noGetter
    set(value) = setContentView(value)