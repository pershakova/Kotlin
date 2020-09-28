package com.kotlin.example.extensions

import android.view.View

inline fun View.dip(value: Int) = context.dip(value)
