package com.mozhimen.dslk.funcs

import android.text.Editable
import android.view.KeyEvent
import android.widget.EditText
import android.widget.TextView
import com.mozhimen.dslk.editText
import com.mozhimen.dslk.properties.onTextChange
import com.mozhimen.kotlin.utilk.kotlinx.coroutines.applyAutoDispose
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

/**
 * @ClassName EditText
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/3
 * @Version 1.0
 */
/**
 * a debounce listener for [editText]'s text change event
 */
fun EditText.setDebounceListener(timeoutMillis: Long, action: (CharSequence) -> Unit) {
    val mainScope = MainScope()
    val textChangeActor = mainScope.actor<CharSequence>(capacity = Channel.UNLIMITED) {
        consumeAsFlow().debounce(timeoutMillis).collect { action.invoke(text) }
    }.applyAutoDispose(this)

    onTextChange = textWatcher {
        onTextChanged = change@{ text: CharSequence?, _: Int, _: Int, _: Int ->
            mainScope.launch {
                text.toString().trim().let { textChangeActor.send(it) }
            }.applyAutoDispose(this@setDebounceListener)
        }
    }
}

fun textWatcher(init: TextWatcher.() -> Unit): TextWatcher = TextWatcher().apply(init)

class TextWatcher(
    var beforeTextChanged: (
        text: CharSequence?,
        start: Int,
        count: Int,
        after: Int
    ) -> Unit = { _, _, _, _ -> },
    var onTextChanged: (
        text: CharSequence?,
        start: Int,
        count: Int,
        after: Int
    ) -> Unit = { _, _, _, _ -> },
    var afterTextChanged: (text: Editable?) -> Unit = {}
)

fun editorAction(init: EditorActionListener.() -> Unit): EditorActionListener =
    EditorActionListener().apply(init)

class EditorActionListener(
    var onEditorAction: (
        textView: TextView?,
        actionId: Int,
        keyEvent: KeyEvent?
    ) -> Boolean = { _, _, _ -> false }
)