package com.softyorch.navigationcompose.ui.core.navigation

import com.softyorch.navigationcompose.ui.model.UserDetailValues
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String)

@Serializable
data class UserDetail(val values: UserDetailValues)
