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
    fun searchByKeyword(@Query("keyword_or") keyword: String): Single<ConnpassEvent>

    @GET("v1/event")
    fun searchByOrganizeDate(@Query("ymd") yyyymmdd: String): Single<ConnpassEvent>

    @GET("v1/event")
    fun searchByMonth(@Query("ym") yyyymm: String): Single<ConnpassEvent>

    @GET("v1/event")
    fun getSeries(@Query("count") count: Int? = 10): Single<ConnpassEvent>


}