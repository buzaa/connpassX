package giavu.co.jp.repository.model

import java.io.Serializable

data class Series(
    val id: Int,
    val title: String,
    val url: String
) : Serializable