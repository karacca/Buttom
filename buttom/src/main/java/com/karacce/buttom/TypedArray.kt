package com.karacce.buttom

import android.content.res.TypedArray
import android.support.annotation.StyleableRes

/**
 * @user: omerkaraca
 * @date: 2019-06-10
 */


fun TypedArray.use(block: TypedArray.() -> Unit) {
    try {
        block()
    } finally {
        this.recycle()
    }
}

fun TypedArray.getIntOrNull(@StyleableRes index: Int): Int? {
    return if (hasValue(index)) {
        getInt(index, 0)
    }else {
        null
    }
}

fun TypedArray.getColorOrNull(@StyleableRes index: Int): Int? {
    return if (hasValue(index)) {
        getColor(index, 0)
    }else {
        null
    }
}


fun TypedArray.getFloatOrNull(@StyleableRes index: Int): Float? {
    return if (hasValue(index)) {
        getFloat(index, 0f)
    }else {
        null
    }
}

fun TypedArray.getDimensionOrNull(@StyleableRes index: Int): Float? {
    return if (hasValue(index)) {
        getDimension(index, 0f)
    }else {
        null
    }
}