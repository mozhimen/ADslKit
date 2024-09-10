package com.mozhimen.dslk.anko.core.funs

import android.app.Activity
import com.mozhimen.dslk.anko.core.commons.Ui

/**
 * @ClassName Activity
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Activity.setContentView(ui: Ui): Unit =
    setContentView(ui.root)