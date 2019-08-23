package giavu.co.jp.connpassx.di

import giavu.co.jp.repository.api.ConnpassApi
import giavu.co.jp.repository.network.core.CPXApiAccessor
import giavu.co.jp.repository.network.retrofit.ApiAccessor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.Module

/**
 * @Author: Hoang Vu
 * @Date:   2019/01/03
 */
class ApiModule {

    val module: Module = org.koin.dsl.module.module {
        single { CPXApiAccessor(androidApplication()).from() }
        single { get<ApiAccessor>().using(ConnpassApi::class.java) }

    }
}