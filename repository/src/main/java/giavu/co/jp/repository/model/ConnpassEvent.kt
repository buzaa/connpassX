package giavu.co.jp.repository.model

import java.io.Serializable

data class ConnpassEvent(
    val events: List<Event>,
    val results_available: Int,
    val results_returned: Int,
    val results_start: Int
) : Serializable
