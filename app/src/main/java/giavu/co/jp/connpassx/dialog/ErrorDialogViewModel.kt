package giavu.co.jp.connpassx.dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shopify.livedataktx.PublishLiveDataKtx

class ErrorDialogViewModel : ViewModel() {

    private val _closeEvent: PublishLiveDataKtx<Unit> = PublishLiveDataKtx()

    val closeEvent: LiveData<Unit>
        get() = _closeEvent

    fun notifyCloseEvent() {
        _closeEvent.value = Unit
    }
}
