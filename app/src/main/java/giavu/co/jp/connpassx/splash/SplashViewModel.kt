package giavu.co.jp.connpassx.splash

import androidx.lifecycle.*
import giavu.co.jp.domain.model.ConnpassSeries
import giavu.co.jp.domain.usecase.FetchConnpassEventUseCase
import giavu.co.jp.repository.model.ConnpassEvent
import giavu.co.jp.repository.model.Event
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-28
 */
class SplashViewModel(
    private val fetchConnpassEventUseCase: FetchConnpassEventUseCase
) : ViewModel(), LifecycleObserver {

    private val _seriesLoadedEvent = MutableLiveData<ConnpassEvent>()
    private val _loadFailureEvent = MutableLiveData<Unit>()

    val seriesLoadedEvent: LiveData<ConnpassEvent>
        get() = _seriesLoadedEvent
    val loadFailureEvent: LiveData<Unit>
        get() = _loadFailureEvent

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun initialize() {
        Timber.d("Initialize!")
        fetchSeries()
    }

    private fun fetchSeries() {
        viewModelScope.launch {
            runCatching {
                fetchConnpassEventUseCase()
            }.onSuccess {
                _seriesLoadedEvent.value = it
            }.onFailure {
                _loadFailureEvent.value = Unit
                Timber.w(it)
            }
        }
    }

}
