package giavu.co.jp.connpassx.extension

import androidx.fragment.app.FragmentActivity
import giavu.co.jp.connpassx.dialog.ErrorDialogContents
import giavu.co.jp.connpassx.dialog.ErrorDialogFragment

/**
 * @Author: Hoang Vu
 * @Date:   2019-10-06
 */
@JvmOverloads
fun FragmentActivity.showErrorDialog(contents: ErrorDialogContents, tag: String? = null) {

    if (supportFragmentManager.findFragmentByTag(tag) != null || supportFragmentManager.isStateSaved) {
        return
    }
    ErrorDialogFragment.newInstance(contents = contents).showNow(supportFragmentManager, tag)
}