package giavu.co.jp.connpassx.splash

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import giavu.co.jp.connpassx.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initializeView()
    }

    private fun initializeView() {
        app_name.startAnimation(
            AnimationUtils.loadAnimation(
                this,
                R.anim.transition_up
            ).apply {
                startOffset = 600L
            }
        )
    }
}
