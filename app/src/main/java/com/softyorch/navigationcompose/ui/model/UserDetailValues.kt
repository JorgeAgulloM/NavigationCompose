package com.softyorch.navigationcompose.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class UserDetailValues(val name: String, val age: Int, val email: String) : Parcelable
