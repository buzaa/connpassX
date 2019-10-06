package giavu.co.jp.connpassx.dialog

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import giavu.co.jp.connpassx.R
import giavu.co.jp.connpassx.databinding.DialogErrorFragmentBinding
import giavu.co.jp.connpassx.extension.setOnProtectBarrageClickListener

/**
 * @Author: Hoang Vu
 * @Date:   2019-10-06
 */
class ErrorDialogFragment : DialogFragment() {

    companion object {
        private const val KEY_CONTENTS = "key_contents"

        fun newInstance(contents: ErrorDialogContents): DialogFragment {
            return ErrorDialogFragment().apply {
                arguments = bundleOf(
                    KEY_CONTENTS to contents
                )
            }
        }
    }

    private var viewModel: ErrorDialogViewModel? = null
    private val data: ErrorDialogContents by lazy { arguments?.getSerializable(KEY_CONTENTS) as ErrorDialogContents }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.AppTheme_Dialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<DialogErrorFragmentBinding>(
            inflater,
            R.layout.dialog_error_fragment,
            container,
            false
        ).apply {
            lifecycleOwner = this@ErrorDialogFragment
            contents = data
            closeButton.setOnProtectBarrageClickListener {
                dismiss()
            }
        }.root
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        viewModel?.notifyCloseEvent()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = findViewModel()
    }

    override fun onDetach() {
        super.onDetach()
        viewModel = null
    }

    private fun findViewModel(): ErrorDialogViewModel? {
        return activity?.let {
            when (val key = tag) {
                null -> ViewModelProvider(it).get(ErrorDialogViewModel::class.java)
                else -> ViewModelProvider(it).get(key, ErrorDialogViewModel::class.java)
            }
        }
    }
}