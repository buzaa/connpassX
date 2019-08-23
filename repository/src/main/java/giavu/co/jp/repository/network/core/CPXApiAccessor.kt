package giavu.co.jp.repository.network.core

import android.content.Context
import giavu.co.jp.repository.R
import giavu.co.jp.repository.network.retrofit.ApiAccessor

/**
 * @Author: Hoang Vu
 * @Date:   2019/01/03
 */
class CPXApiAccessor(private val context: Context) : ApiAccessor(context = context) {
    override fun getBaseUrl(): String {
        return context.getString(R.string.app_name) + "://" + context.getString(R.string.app_name)
    }

    override fun onCreateHeaders(headers: MutableMap<String, String>) {
        headers.apply {
            put(ApiHeader.KEY_AUTHORIZATION, context.getString(R.string.app_name))
            put(ApiHeader.CONTENT_TYPE, ApiHeader.VALUE_ACCEPT_JSON)
            put(ApiHeader.KEY_USER_AGENT, UserSharePreference.fromContext(context).getUserSession())
        }
    }

    fun from(): ApiAccessor {
        return CPXApiAccessor(context)
    }
}