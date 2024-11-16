package com.softyorch.navigationcompose.ui.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String)
