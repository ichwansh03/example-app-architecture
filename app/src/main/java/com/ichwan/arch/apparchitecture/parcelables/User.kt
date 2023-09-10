package com.ichwan.arch.apparchitecture.parcelables

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
): Parcelable