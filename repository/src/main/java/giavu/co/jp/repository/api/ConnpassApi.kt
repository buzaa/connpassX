package giavu.co.jp.repository.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-21
 */
interface ConnpassApi {

    @GET("quotes")
    fun fetch(@Query("page") page: Int): Single<String>
}