package com.karacce.buttom

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet


/**
 * @user: omerkaraca
 * @date: 2019-06-10
 */

@SuppressLint("Recycle")
class Buttom @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = R.attr.buttonStyle)
    : AppCompatButton(context, attributeSet, defStyleAttr) {

    enum class Type(val value: Int) {
        FLAT(0),
        GRADIENT(1)
    }

    enum class GradientType(val value: Int) {
        LINEAR(0),
        RADIAL(1)
    }

    enum class GradientOrientation(val value: Int) {
        TOP_BOTTOM(0),
        RIGHT_LEFT(1),
        BOTTOM_TOP(2),
        LEFT_RIGHT(3),
    }

    private var type: Type = Type.FLAT
    private var gradientType: GradientType = GradientType.LINEAR
    private var cornerRadius: Float? = null
    private var backgroundColor: Int? = null
    private var strokeSize: Float? = null
    private var strokeColor: Int? = null
    private var gradientOrientation: GradientOrientation = GradientOrientation.TOP_BOTTOM // only linear gradient
    private var gradientRadius: Float? = null // only radial gradient
    private var gradientStartColor: Int? = null
    private var gradientEndColor: Int? = null

    init {
        val buttomAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Buttom)
        buttomAttributes.use {

            type = when(getIntOrNull(R.styleable.Buttom_buttom_type)) {
                0 -> Type.FLAT
                1 -> Type.GRADIENT
                else -> Type.FLAT
            }

            gradientType = when(getIntOrNull(R.styleable.Buttom_buttom_gradient_type)) {
                0 -> GradientType.LINEAR
                1 -> GradientType.RADIAL
                else -> GradientType.LINEAR
            }

            gradientOrientation = when(getIntOrNull(R.styleable.Buttom_buttom_gradient_orientation)) {
                0 -> GradientOrientation.TOP_BOTTOM
                1 -> GradientOrientation.RIGHT_LEFT
                2 -> GradientOrientation.BOTTOM_TOP
                3 -> GradientOrientation.LEFT_RIGHT
                else -> GradientOrientation.TOP_BOTTOM
            }

            cornerRadius = getDimensionOrNull(R.styleable.Buttom_buttom_corner_radius)
            backgroundColor = getColorOrNull(R.styleable.Buttom_buttom_background_color)
            strokeSize = getDimensionOrNull(R.styleable.Buttom_buttom_stroke_size)
            strokeColor = getColorOrNull(R.styleable.Buttom_buttom_stroke_color)
            gradientRadius = getFloatOrNull(R.styleable.Buttom_buttom_gradient_radius)
            gradientStartColor = getColorOrNull(R.styleable.Buttom_buttom_gradient_start_color)
            gradientEndColor = getColorOrNull(R.styleable.Buttom_buttom_gradient_end_color)
            applyAttributes()

        }
    }

    private fun applyAttributes() {
        val drawable = GradientDrawable()

        backgroundColor?.let {
            drawable.color = ColorStateList(arrayOf(
                intArrayOf(android.R.attr.state_enabled),
                intArrayOf(-android.R.attr.state_enabled),
                intArrayOf(-android.R.attr.state_checked),
                intArrayOf(android.R.attr.state_pressed)
            ), intArrayOf(it, it, it, it))
        }

        cornerRadius?.let {
            drawable.cornerRadius = it
        }

        if (strokeSize != null && strokeColor != null) {
            drawable.setStroke(strokeSize!!.toInt(), strokeColor!!)
        }

        if (gradientStartColor != null && gradientEndColor != null) {
            drawable.colors = intArrayOf(gradientStartColor!!, gradientEndColor!!)
            drawable.gradientType = when(gradientType) {
                GradientType.LINEAR -> GradientDrawable.LINEAR_GRADIENT
                GradientType.RADIAL -> GradientDrawable.RADIAL_GRADIENT
            }
            drawable.gradientRadius = gradientRadius ?: 0f
            drawable.orientation = when (gradientOrientation) {
                GradientOrientation.TOP_BOTTOM -> GradientDrawable.Orientation.TOP_BOTTOM
                GradientOrientation.RIGHT_LEFT -> GradientDrawable.Orientation.RIGHT_LEFT
                GradientOrientation.BOTTOM_TOP -> GradientDrawable.Orientation.BOTTOM_TOP
                GradientOrientation.LEFT_RIGHT -> GradientDrawable.Orientation.LEFT_RIGHT
            }
        }

        background = drawable
    }

}
