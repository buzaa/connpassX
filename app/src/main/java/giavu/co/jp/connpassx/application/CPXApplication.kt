package giavu.co.jp.connpassx.application

import android.app.Application

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-21
 */
open class CPXApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(this).initialize()
    }
}