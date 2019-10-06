package giavu.co.jp.connpassx.dialog

import java.io.Serializable

data class ErrorDialogContents(
    val title: String? = null,
    val message: String
) : Serializable
