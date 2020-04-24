package giavu.co.jp.connpassx.application

import android.app.Application
import giavu.co.jp.connpassx.BuildConfig
import giavu.co.jp.connpassx.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.EmptyLogger

/**
 * @Author: Hoang Vu
 * @Date:   2018/12/08
 */
class KoinInitializer(private val application: Application) {

    fun initialize() {
        startKoin {
            if (BuildConfig.DEBUG) {
                AndroidLogger()
            } else {
                EmptyLogger()
            }
            androidContext(application)
            modules(Modules().get())
        }

    }
}
