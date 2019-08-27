package giavu.co.jp.domain.usecase

import giavu.co.jp.repository.api.ConnpassApi
import giavu.co.jp.repository.model.ConnpassEvent
import io.reactivex.Single

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-24
 */
class FetchConnpassEventUseCase(
    private val connpassApi: ConnpassApi
) {

    operator fun invoke(): Single<ConnpassEvent> {
        return connpassApi.searchByKeyword()
    }
}