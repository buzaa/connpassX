package giavu.co.jp.connpassx.main


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import giavu.co.jp.connpassx.R
import giavu.co.jp.connpassx.databinding.ActivityMainBinding
import giavu.co.jp.repository.model.ConnpassEvent
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    companion object {
        private const val KEY_DATA = "key_data"

        fun createIntent(context: Context, data: ConnpassEvent): Intent {
            return Intent(context, MainActivity::class.java).apply {
                putExtra(KEY_DATA, data)
            }
        }
    }

    private val data: ConnpassEvent? by lazy {
        intent.getSerializableExtra(KEY_DATA) as? ConnpassEvent
    }

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        initViewModel()
    }

    private fun initDataBinding() {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).apply {
            /*viewModel = this@MainActivity.viewModel.apply {
                init(data = data)
            }*/
            lifecycleOwner = this@MainActivity
            // slistEvent.adapter =
        }
    }

    private fun initViewModel() {

    }

}
