package giavu.co.jp.connpassx.main


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import giavu.co.jp.connpassx.R
import giavu.co.jp.connpassx.databinding.ActivityMainBinding
import giavu.co.jp.repository.model.ConnpassEvent
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.simpleName
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
        observeViewModel()
    }

    private fun initDataBinding() {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).apply {
            viewModel = this@MainActivity.viewModel.apply {
                init(data = data)
            }
            lifecycleOwner = this@MainActivity
            listEvent.adapter = ConnpassEventAdapter(
                lifecycleOwner = this@MainActivity
            )
        }
    }

    private fun initViewModel() {
        viewModel.testSingleLiveData.observe(this@MainActivity, Observer {
            Log.d(TAG, "Single Live Data InitViewModel")
        })
    }

    private fun observeViewModel() {
        with(viewModel) {
            testSingleLiveData.observe(this@MainActivity, Observer {
                Log.d(TAG, "Single Live Data observeViewModel")
            })
        }
    }

}
