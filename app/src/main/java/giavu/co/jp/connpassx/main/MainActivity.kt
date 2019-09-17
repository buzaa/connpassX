package giavu.co.jp.connpassx.main


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import giavu.co.jp.connpassx.R
import giavu.co.jp.domain.model.ConnpassSeries
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    companion object {
        private const val KEY_DATA = "key_data"

        fun createIntent(context: Context, data: ConnpassSeries): Intent {
            return Intent(context, MainActivity::class.java).apply {
                putExtra(KEY_DATA, data)
            }
        }
    }

    private val data: ConnpassSeries? by lazy {
        intent.getSerializableExtra(KEY_DATA) as? ConnpassSeries
    }

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize() {
        initView()
        initViewModel()
    }

    private fun initView(){
        Timber.d("Loading data is : %s", data?.toString())
    }
    private fun initViewModel() {
    }
}
