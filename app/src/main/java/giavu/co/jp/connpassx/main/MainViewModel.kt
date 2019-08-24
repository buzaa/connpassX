package giavu.co.jp.connpassx.main

import android.util.Log
import androidx.lifecycle.ViewModel
import giavu.co.jp.domain.usecase.FetchConnpassEventUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-24
 */
class MainViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun init(fetchConnpassEventUseCase: FetchConnpassEventUseCase) {
        Log.d("HH", "Ko hieu")
        Timber.d("init")
        fetchConnpassEventUseCase.invoke()
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
    }
}