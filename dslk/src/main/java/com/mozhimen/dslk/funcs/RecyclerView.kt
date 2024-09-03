package com.mozhimen.dslk.funcs

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @ClassName RecyclerView
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/3
 * @Version 1.0
 */
fun RecyclerView.setOnItemClickListener(listener: (View, Int, Float, Float) -> Boolean) {
    addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
        val gestureDetector = GestureDetector(context, object : GestureDetector.OnGestureListener {
            override fun onShowPress(e: MotionEvent) {
            }

            override fun onSingleTapUp(e: MotionEvent): Boolean {
                e.let {
                    findChildViewUnder(it.x, it.y)?.let { child ->
                        val realX = if (child.left >= 0 ) it.x - child.left else it.x
                        val realY = if (child.top >= 0) it.y - child.top else it.y
                        return listener(
                            child,
                            getChildAdapterPosition(child),
                            realX,
                            realY
                        )
                    }
                }
                return false
            }

            override fun onDown(e: MotionEvent): Boolean {
                return false
            }

            override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
                return false
            }

            override fun onScroll(e1: MotionEvent?, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
                return false
            }

            override fun onLongPress(e: MotionEvent) {
            }
        })

        override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

        }

        override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
            gestureDetector.onTouchEvent(e)
            return false
        }

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        }
    })
}

fun RecyclerView.setOnItemLongClickListener(listener: (View, Int, Float, Float) -> Unit) {
    addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
        val gestureDetector = GestureDetector(context, object : GestureDetector.OnGestureListener {
            override fun onShowPress(e: MotionEvent) {
            }

            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return false
            }

            override fun onDown(e: MotionEvent): Boolean {
                return false
            }

            override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
                return false
            }

            override fun onScroll(e1: MotionEvent?, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
                return false
            }

            override fun onLongPress(e: MotionEvent) {
                e.let {
                    findChildViewUnder(it.x, it.y)?.let { child ->
                        val realX = if (child.left >= 0 ) it.x - child.left else it.x
                        val realY = if (child.top >= 0) it.y - child.top else it.y
                        listener(
                            child,
                            getChildAdapterPosition(child),
                            realX,
                            realY
                        )
                    }
                }
            }
        })

        override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

        }

        override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
            gestureDetector.onTouchEvent(e)
            return false
        }

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        }
    })
}