package giavu.co.jp.connpassx.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import giavu.co.jp.connpassx.R
import giavu.co.jp.connpassx.dialog.ErrorDialogContents
import giavu.co.jp.connpassx.dialog.ErrorDialogViewModel
import giavu.co.jp.connpassx.extension.showErrorDialog
import giavu.co.jp.connpassx.main.MainActivity
import org.koin.android.ext.android.inject
import timber.log.Timber

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val TAG_DIALOG_ERROR = "tag_dialog_error"
    }

    private val viewModel: SplashViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lifecycle.addObserver(viewModel)
        observeDialog()
        observeViewModel()
    }

    private fun observeDialog() {
        with(ViewModelProvider(this).get(TAG_DIALOG_ERROR, ErrorDialogViewModel::class.java)) {
            closeEvent.observe(this@SplashActivity, Observer {
                this@SplashActivity.finish()
            })
        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            seriesLoadedEvent.observe(this@SplashActivity, Observer {
                startActivity(MainActivity.createIntent(this@SplashActivity, it))
                finish()
            })
            loadFailureEvent.observe(this@SplashActivity, Observer {
                Timber.d("Come here")
                showErrorDialog(
                    contents = ErrorDialogContents(
                        title = "Network error",
                        message = "Please check your network connection !"
                    ),
                    tag = TAG_DIALOG_ERROR
                )
            })
        }
    }
}
