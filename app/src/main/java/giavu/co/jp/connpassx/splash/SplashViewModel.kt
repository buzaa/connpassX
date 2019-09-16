package giavu.co.jp.connpassx.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import giavu.co.jp.domain.model.ConnpassSeries
import giavu.co.jp.domain.usecase.FetchConnpassEventUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-28
 */
class SplashViewModel(
    private val fetchConnpassEventUseCase: FetchConnpassEventUseCase
) : ViewModel() {

    private val _seriesLoadedEvent = MutableLiveData<ConnpassSeries>()
    private val _loadFailureEvent = MutableLiveData<Unit>()

    val seriesLoadedEvent: LiveData<ConnpassSeries>
        get() = _seriesLoadedEvent
    val loadFailureEvent: LiveData<Unit>
        get() = _loadFailureEvent

    fun initialize() {
        fetchSeries()
    }

    private fun fetchSeries() {
        viewModelScope.launch {
            kotlin.runCatching {
                withContext(Dispatchers.IO) {
                    fetchConnpassEventUseCase.fetchSeries()
                }
            }.onSuccess {
                _seriesLoadedEvent.value = it
            }.onFailure {
                _loadFailureEvent.value = Unit
                Timber.w(it)
            }
        }
    }

}