package giavu.co.jp.domain.usecase

import giavu.co.jp.domain.model.ConnpassSeries
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

    fun fetchSeries(): Single<ConnpassSeries> {
        return connpassApi.getSeries().map(::seriesMapper)
    }

    fun searchByWord(): Single<ConnpassEvent> {
        return connpassApi.searchByKeyword(keyword = "android")
    }

    private fun seriesMapper(connpassEvent: ConnpassEvent): ConnpassSeries {
        return ConnpassSeries(
            series = connpassEvent.events.map {
                it.series
            }
        )
    }
}