package giavu.co.jp.repository.model

import java.io.Serializable

data class Event(
    val `catch`: String,
    val accepted: Int,
    val address: String,
    val description: String,
    val ended_at: String,
    val event_id: Int,
    val event_type: String,
    val event_url: String,
    val hash_tag: String,
    val lat: String,
    val limit: Int,
    val lon: String,
    val owner_display_name: String,
    val owner_id: Int,
    val owner_nickname: String,
    val place: String,
    val series: Series,
    val started_at: String,
    val title: String,
    val updated_at: String,
    val waiting: Int
) : Serializable
