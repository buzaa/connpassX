package giavu.co.jp.domain.usecase

import giavu.co.jp.domain.model.ConnpassSeries
import giavu.co.jp.repository.api.ConnpassApi
import giavu.co.jp.repository.model.ConnpassEvent
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-24
 */
class FetchConnpassEventUseCase(
    private val connpassApi: ConnpassApi
) {

    suspend operator fun invoke(): ConnpassSeries {
        return withContext(Dispatchers.IO) {
            seriesMapper(connpassApi.getSeries())
        }
    }

    private fun seriesMapper(connpassEvent: ConnpassEvent): ConnpassSeries {
        return ConnpassSeries(
            series = connpassEvent.events.map {
                it.series
            }
        )
    }
}
