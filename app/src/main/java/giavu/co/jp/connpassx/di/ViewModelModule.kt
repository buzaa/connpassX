package giavu.co.jp.connpassx.di

import giavu.co.jp.connpassx.main.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module

/**
 * @Author: Hoang Vu
 * @Date:   2019/01/04
 */
class ViewModelModule {

    val module: Module = org.koin.dsl.module.module {
        viewModel { MainViewModel() }
    }
}
