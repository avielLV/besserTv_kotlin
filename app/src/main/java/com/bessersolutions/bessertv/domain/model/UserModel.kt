package com.bessersolutions.bessertv.domain.model

data class UserModel(
    val userInfo: UserInfo?,
    val serverInfo: ServerInfo?
)

data class UserInfo(
    val username: String?,
    val password: String?,
    val message: String?,
    val auth: Int?,
    val status: String?,
    val expDate: String?,
    val isTrial: String?,
    val activeCons: String?,
    val createdAt: String?,
    val maxConnections: String?,
    val allowedOutputFormats: List<String>?
)

data class ServerInfo(
    val url: String?,
    val port: String?,
    val httpsPort: String?,
    val serverProtocol: String?,
    val rtmpPort: String?,
    val timezone: String?,
    val timestampNow: Int?,
    val timeNow: String?
)
