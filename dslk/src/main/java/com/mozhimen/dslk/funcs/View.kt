package com.mozhimen.dslk.funcs

import android.annotation.SuppressLint
import android.graphics.Rect
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.TouchDelegate
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.ViewGroupUtils
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.mozhimen.dslk.recyclerView
import com.mozhimen.dslk.utils.find
import com.mozhimen.dslk.values.visible
import com.mozhimen.dslk.view
import com.mozhimen.kotlin.utilk.android.graphics.relativeTo
import com.mozhimen.kotlin.utilk.kotlinx.coroutines.applyAutoDispose
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.launch
import kotlin.math.abs

/**
 * @ClassName View
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/3
 * @Version 1.0
 */
fun ViewGroup.MarginLayoutParams.toConstraintLayoutParam() =
    ConstraintLayout.LayoutParams(width, height).also { it ->
        it.topMargin = this.topMargin
        it.bottomMargin = this.bottomMargin
        it.marginStart = this.marginStart
        it.marginEnd = this.marginEnd
    }

@SuppressLint("ClickableViewAccessibility")
fun ViewGroup.setOnItemClickListener(listener: (View, Int) -> Unit) {
    val gestureDetector = GestureDetector(context, object : GestureDetector.OnGestureListener {
        private val touchFrame = Rect()
        fun pointToPosition(x: Int, y: Int): Int {
            (0 until childCount).map { getChildAt(it) }.forEachIndexed { index, child ->
                if (child.visibility == visible  && child !is Flow) {
                    child.getHitRect(touchFrame)
                    if (touchFrame.contains(x, y)) return index
                }
            }
            return -1
        }

        override fun onShowPress(e: MotionEvent) {
        }

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            pointToPosition(e.x.toInt(), e.y.toInt()).takeIf { it != -1 }?.let { index ->
                listener(getChildAt(index), index)
            }
            return false
        }

        override fun onDown(e: MotionEvent): Boolean {
            return true
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

    setOnTouchListener { _, event ->
        gestureDetector.onTouchEvent(event)
        true
    }
}

fun View.isChildOf(view: View?) = view?.findViewById<View>(this.id) != null

fun <T> View.observe(liveData: LiveData<T>?, action: (T) -> Unit) {
    (context as? LifecycleOwner)?.let { owner ->
        liveData?.observe(owner, { action(it) })
    }
}

@SuppressLint("RestrictedApi")
fun View.expand(dx: Int, dy: Int) {
    class MultiTouchDelegate(bound: Rect? = null, delegateView: View) : TouchDelegate(bound, delegateView) {
        val delegateViewMap = mutableMapOf<View, Rect>()
        private var delegateView: View? = null

        override fun onTouchEvent(event: MotionEvent): Boolean {
            val x = event.x.toInt()
            val y = event.y.toInt()
            var handled = false
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    delegateView = findDelegateViewUnder(x, y)
                }
                MotionEvent.ACTION_CANCEL -> {
                    delegateView = null
                }
            }
            delegateView?.let {
                event.setLocation(it.width / 2f, it.height / 2f)
                handled = it.dispatchTouchEvent(event)
            }
            return handled
        }

        private fun findDelegateViewUnder(x: Int, y: Int): View? {
            delegateViewMap.forEach { entry -> if (entry.value.contains(x, y)) return entry.key }
            return null
        }
    }

    val parentView = parent as? ViewGroup
    parentView ?: return

    if (parentView.touchDelegate == null) parentView.touchDelegate = MultiTouchDelegate(delegateView = this)
    post {
        val rect = Rect()
        ViewGroupUtils.getDescendantRect(parentView, this, rect)
        rect.inset(- dx, - dy)
        (parentView.touchDelegate as? MultiTouchDelegate)?.delegateViewMap?.put(this, rect)
    }
}

/**
 * get relative position of this [view] relative to [otherView]
 */
fun View.getRelativeRectTo(otherView: View): Rect {
    val parentRect = Rect().also { otherView.getGlobalVisibleRect(it) }
    val childRect = Rect().also { getGlobalVisibleRect(it) }
    return childRect.relativeTo(parentRect)
}

/**
 *  listen click action for the child view of [recyclerView]'s item
 */
inline fun View.onChildViewClick(
    vararg layoutId: String, // the id of the child view of RecyclerView's item
    x: Float, // the x coordinate of click point
    y: Float,// the y coordinate of click point,
    clickAction: ((View?) -> Unit)
) {
    var clickedView: View? = null
    layoutId
        .map { id ->
            find<View>(id)?.takeIf { it.visibility == visible }?.let { view ->
                view.getRelativeRectTo(this).also { rect ->
                    if (rect.contains(x.toInt(), y.toInt())) {
                        clickedView = view
                    }
                }
            } ?: Rect()
        }
        .fold(Rect()) { init, rect -> init.apply { union(rect) } }
        .takeIf { it.contains(x.toInt(), y.toInt()) }
        ?.let { clickAction.invoke(clickedView) }
}

/**
 *  listen click action for the child view of [recyclerView]'s item
 */
inline fun View.onChildViewClick(
    vararg layoutId: Int, // the id of the child view of RecyclerView's item
    x: Float, // the x coordinate of click point
    y: Float,// the y coordinate of click point,
    clickAction: ((View?) -> Unit)
) {
    var clickedView: View? = null
    layoutId
        .map { id ->
            findViewById<View>(id)?.takeIf { it.visibility == visible }?.let { view ->
                view.getRelativeRectTo(this).also { rect ->
                    if (rect.contains(x.toInt(), y.toInt())) {
                        clickedView = view
                    }
                }
            } ?: Rect()
        }
        .fold(Rect()) { init, rect -> init.apply { union(rect) } }
        .takeIf { it.contains(x.toInt(), y.toInt()) }
        ?.let { clickAction.invoke(clickedView) }
}

/**
 * a new View.OnClickListener which prevents click shaking
 */
fun View.setShakelessClickListener(threshold: Long, onClick: (View) -> Unit) {
    class Click(
        var view: View? = null,
        var clickTime: Long = -1,
        var onClick: ((View?) -> Unit)? = null
    ) {
        fun isShake(click: Click) = abs(clickTime - click.clickTime) < threshold
    }

    val mainScope = MainScope()
    val clickActor = mainScope.actor<Click>(capacity = Channel.UNLIMITED) {
        var preClick: Click = Click()
        for (click in channel) {
            if (!click.isShake(preClick)) {
                click.onClick?.invoke(click.view)
            }
            preClick = click
        }
    }.applyAutoDispose(this)
    setOnClickListener { view ->
        mainScope.launch {
            clickActor.send(
                Click(view, System.currentTimeMillis()) { onClick(view) }
            )
        }.applyAutoDispose(this)
    }
}