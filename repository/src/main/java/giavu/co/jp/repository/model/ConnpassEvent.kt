package giavu.co.jp.repository.model

data class ConnpassEvent(
    val events: List<Event>,
    val results_available: Int,
    val results_returned: Int,
    val results_start: Int
)