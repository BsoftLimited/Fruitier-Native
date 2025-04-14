package com.bsoft.fruitier_native.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Orders(
    @SerialName("id") val id: String,
    @SerialName("user_id") val userID: String
)