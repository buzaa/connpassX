package giavu.co.jp.connpassx.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import giavu.co.jp.connpassx.R
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initialize()
        observeViewModel()
    }

    private fun initialize() {

    }

    private fun observeViewModel() {
        with(viewModel) {
            seriesEvent.observe(this@SplashActivity, Observer {

            })
        }
    }
}
