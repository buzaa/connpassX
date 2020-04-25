package giavu.co.jp.connpassx.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import giavu.co.jp.domain.usecase.FetchConnpassEventUseCase
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-24
 */
class MainViewModel(
    private val fetchConnpassEventUseCase: FetchConnpassEventUseCase
) : ViewModel() {

    // private val compositeDisposable = CompositeDisposable()

    private fun fetchEvent() {
        viewModelScope.launch {
            runCatching {
                fetchConnpassEventUseCase()
            }.onSuccess {
                Timber.d("Test Coroutine:%s", it.toString())
            }.onFailure {

            }
        }
    }
/*
    private fun fetchEventByRx() {
        fetchConnpassEventUseCase.searchByWord()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                Timber.d("Do something")
            }
            .doFinally {
                Timber.d("Finish")
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = Timber::w,
                onSuccess = {
                    Timber.d("Result: %s", it.toString())
                }
            )
            .addTo(compositeDisposable)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }*/
}
