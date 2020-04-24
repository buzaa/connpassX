package giavu.co.jp.connpassx.di

import giavu.co.jp.domain.usecase.FetchConnpassEventUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-21
 */
class UseCaseModule {
    val module: Module = module {
        single { FetchConnpassEventUseCase(connpassApi = get()) }
    }
}
