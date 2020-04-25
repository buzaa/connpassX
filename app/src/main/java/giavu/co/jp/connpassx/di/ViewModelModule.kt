package giavu.co.jp.connpassx.di

import giavu.co.jp.connpassx.main.MainViewModel
import giavu.co.jp.connpassx.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


/**
 * @Author: Hoang Vu
 * @Date:   2019/01/04
 */
class ViewModelModule {

    val module: Module = module {
        viewModel { MainViewModel(fetchConnpassEventUseCase = get()) }
        viewModel { SplashViewModel(fetchConnpassEventUseCase = get()) }
    }
}
