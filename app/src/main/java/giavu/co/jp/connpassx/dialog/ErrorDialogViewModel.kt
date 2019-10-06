package giavu.co.jp.connpassx.dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shopify.livedataktx.PublishLiveDataKtx
import timber.log.Timber

class ErrorDialogViewModel : ViewModel() {

    private val _closeEvent: PublishLiveDataKtx<Unit> = PublishLiveDataKtx()

    val closeEvent: LiveData<Unit>
        get() = _closeEvent

    fun notifyCloseEvent() {
        Timber.d("close request")
        _closeEvent.value = Unit
    }
}
