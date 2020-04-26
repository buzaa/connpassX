package giavu.co.jp.domain.usecase

import giavu.co.jp.repository.api.ConnpassApi
import giavu.co.jp.repository.model.ConnpassEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-24
 */
class FetchConnpassEventUseCase(
    private val connpassApi: ConnpassApi
) {

    suspend operator fun invoke(
        eventOpenByDate: Int? = null,
        eventOpenByMonth: Int? = null,
        keyWord: String? = null
    ): ConnpassEvent {
        return withContext(Dispatchers.IO) {
            connpassApi.searchEvent(
                byDate = eventOpenByDate,
                byMonth = eventOpenByMonth,
                keyWord = keyWord
            )
        }
    }
}
