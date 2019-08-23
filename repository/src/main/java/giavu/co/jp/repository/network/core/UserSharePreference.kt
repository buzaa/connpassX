package giavu.co.jp.repository.network.core

import android.content.Context
import android.content.SharedPreferences

/**
 * @Author: Hoang Vu
 * @Date:   2019/01/14
 */
class UserSharePreference(private val context: Context) {

    private val BASE_PREFERENCE_NAME = "giavu_share_preferences"
    private val KEY_USER_NAME = BASE_PREFERENCE_NAME + "username"
    private val KEY_EMAIL = BASE_PREFERENCE_NAME + "email"
    private val KEY_SESSION = BASE_PREFERENCE_NAME + "session"

    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(BASE_PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    companion object {
        fun fromContext(context: Context): UserSharePreference {
            return UserSharePreference(context)
        }
    }

    fun updateUserSession() {
        // TODO
    }

    fun getUserSession(): String {
        return prefs.getString(KEY_SESSION, "")
    }

}