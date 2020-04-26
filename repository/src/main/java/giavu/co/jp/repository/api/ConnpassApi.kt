package giavu.co.jp.repository.api

import giavu.co.jp.repository.model.ConnpassEvent
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-21
 */
interface ConnpassApi {

    @GET("v1/event")
    suspend fun searchByKeyword(@Query("keyword_or") keyword: String): ConnpassEvent

    @GET("v1/event")
    suspend fun searchEvent(
        @Query("ymd") byDate: Int?,
        @Query("ym") byMonth: Int?,
        @Query("keyword_or") keyWord: String?
    ): ConnpassEvent
}
