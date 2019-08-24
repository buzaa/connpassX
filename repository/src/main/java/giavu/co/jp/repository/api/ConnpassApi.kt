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
    fun fetch(): Single<ConnpassEvent>

    @GET("v1/event")
    fun get(
        @Query("keyword") keyword: String,
        @Query("count") count: Int
    ): Single<String>


}