package giavu.co.jp.domain.usecase

import giavu.co.jp.repository.api.ConnpassApi
import giavu.co.jp.repository.model.ConnpassEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchConnpassEventUseCase(
    private val connpassApi: ConnpassApi
) {

    suspend operator fun invoke(keyword: String): ConnpassEvent {
        return withContext(Dispatchers.IO) {
            connpassApi.searchByKeyword(keyword)
        }
    }
}
