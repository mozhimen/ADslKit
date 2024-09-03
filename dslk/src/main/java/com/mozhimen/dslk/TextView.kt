package com.mozhimen.dslk

import android.content.res.Resources
import android.graphics.Color
import android.text.Editable
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.view.KeyEvent
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

/**
 * @ClassName TextView
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/9/2 23:06
 * @Version 1.0
 */
inline var TextView.maxLength: Int
    get() {
        return 1
    }
    set(value) {
        filters = arrayOf<InputFilter>(LengthFilter(value))
    }

inline var TextView.text_res: Int
    get() {
        return -1
    }
    set(value) {
        setText(value)
    }

inline var TextView.hint_color: String
    get() {
        return ""
    }
    set(value) {
        setHintTextColor(Color.parseColor(value))
    }

inline var TextView.hint_color_res: Int
    get() {
        return -1
    }
    set(value) {
        setHintTextColor(ContextCompat.getColor(context, value))
    }

inline var TextView.hint_text_res: Int
    get() {
        return -1
    }
    set(value) {
        setHint(value)
    }

inline var TextView.hint_text: String
    get() {
        return ""
    }
    set(value) {
        setHint(value)
    }
inline var TextView.line_space_multiplier: Float
    get() {
        return -1f
    }
    set(value) {
        setLineSpacing(lineSpacingExtra, value)
    }

inline var TextView.line_space_extra: Float
    get() {
        return -1f
    }
    set(value) {
        setLineSpacing(value, lineSpacingMultiplier)
    }

inline var TextView.textStyle: Int
    get() {
        return -1
    }
    set(value) = setTypeface(typeface, value)

inline var TextView.textColor: String
    get() {
        return ""
    }
    set(value) {
        setTextColor(Color.parseColor(value))
    }

inline var TextView.text_color_res: Int
    get() {
        return -1
    }
    set(value) {
        setTextColor(ContextCompat.getColor(context, value))
    }

inline var TextView.fontFamily: Int
    get() {
        return 1
    }
    set(value) {
        try {
            typeface = ResourcesCompat.getFont(context, value)
        } catch (e: Resources.NotFoundException) {
        }
    }
inline var TextView.drawable_start: Int
    get() {
        return -1
    }
    set(value) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(value, 0, 0, 0)
    }

inline var TextView.drawable_end: Int
    get() {
        return -1
    }
    set(value) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, value, 0)
    }

inline var TextView.drawable_top: Int
    get() {
        return -1
    }
    set(value) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(0, value, 0, 0)
    }

inline var TextView.drawable_bottom: Int
    get() {
        return -1
    }
    set(value) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, value)
    }

inline var TextView.drawable_padding: Int
    get() {
        return 0
    }
    set(value) {
        compoundDrawablePadding = value.dp
    }
inline var TextView.onTextChange: TextWatcher
    get() {
        return TextWatcher()
    }
    set(value) {
        val textWatcher = object : android.text.TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                value.afterTextChanged.invoke(s)
            }

            override fun beforeTextChanged(
                text: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                value.beforeTextChanged.invoke(text, start, count, after)
            }

            override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
                value.onTextChanged.invoke(text, start, before, count)
            }
        }
        addTextChangedListener(textWatcher)
    }
inline var TextView.onEditorAction: EditorActionListener
    get() {
        return EditorActionListener()
    }
    set(value) {
        val editorActionListener = object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                return value.onEditorAction(v, actionId, event)
            }
        }
        setOnEditorActionListener(editorActionListener)
    }