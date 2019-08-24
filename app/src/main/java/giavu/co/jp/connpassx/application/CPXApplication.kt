package giavu.co.jp.connpassx.application

import android.app.Application
import giavu.co.jp.connpassx.BuildConfig
import timber.log.Timber

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-21
 */
open class CPXApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        KoinInitializer(this).initialize()
    }
}