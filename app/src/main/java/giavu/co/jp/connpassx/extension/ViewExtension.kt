package giavu.co.jp.connpassx.extension

import android.view.View
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

fun View.setOnProtectBarrageClickListener(callback: () -> Unit) {
    RxView.clicks(this)
            .throttleFirst(1000L, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { callback() }
}

fun View.setOnProtectBarrageClickListener(listener: View.OnClickListener) {
    RxView.clicks(this)
        .throttleFirst(1000L, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { listener.onClick(this) }
}
