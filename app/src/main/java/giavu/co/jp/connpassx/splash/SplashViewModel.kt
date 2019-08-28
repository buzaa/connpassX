package giavu.co.jp.connpassx.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import giavu.co.jp.domain.usecase.FetchConnpassEventUseCase
import giavu.co.jp.repository.model.Series
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.rx2.await
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-28
 */
class SplashViewModel(
    private val fetchConnpassEventUseCase: FetchConnpassEventUseCase
) : ViewModel() {

    enum class State {
        SUCCESS,
        FAILURE
    }

    private val _requestStateEvent = MutableLiveData<State>()
    val requestStateEvent: LiveData<State>
        get() = _requestStateEvent

    private val _seriesEvent = MutableLiveData<List<Series>>()
    val seriesEvent: LiveData<List<Series>>
        get() = _seriesEvent

    fun fetchSeries() {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    fetchConnpassEventUseCase.fetchSeries().await()
                }
            }.onSuccess {
                _seriesEvent.value = it
            }.onFailure {
                Timber.e(it)
            }
        }

    }

}