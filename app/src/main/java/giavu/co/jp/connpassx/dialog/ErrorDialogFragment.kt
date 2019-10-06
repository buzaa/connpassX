package giavu.co.jp.connpassx.dialog

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import giavu.co.jp.connpassx.R

/**
 * @Author: Hoang Vu
 * @Date:   2019-10-06
 */
class ErrorDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.AppTheme_Dialog)
    }
}