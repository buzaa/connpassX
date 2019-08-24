package giavu.co.jp.connpassx.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import giavu.co.jp.domain.usecase.FetchConnpassEventUseCase
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-24
 */
class MainViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private lateinit var fetchConnpassEventUseCase: FetchConnpassEventUseCase

    fun init(fetchConnpassEventUseCase: FetchConnpassEventUseCase) {
        this.fetchConnpassEventUseCase = fetchConnpassEventUseCase
        fetchEvent()
        Timber.d("init")
        /*fetchConnpassEventUseCase.invoke()
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
            .addTo(compositeDisposable)*/
    }

    private fun fetchEvent() {
        viewModelScope.launch {

            runCatching {
                withContext(Dispatchers.IO) {
                    fetchConnpassEventUseCase.invoke().blockingGet()
                }
            }.onSuccess {
                Timber.d("Test Coroutine:%s", it.toString())
            }.onFailure {

            }

        }
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}