package giavu.co.jp.connpassx.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import giavu.co.jp.connpassx.R
import giavu.co.jp.domain.usecase.FetchConnpassEventUseCase
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by inject()
    private val fetchConnpassEventUseCase: FetchConnpassEventUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize() {
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.init(fetchConnpassEventUseCase)
    }
}
