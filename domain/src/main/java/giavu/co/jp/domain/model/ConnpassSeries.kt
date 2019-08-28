package giavu.co.jp.domain.model

import giavu.co.jp.repository.model.Series
import java.io.Serializable

/**
 * @Author: Hoang Vu
 * @Date:   2019-08-29
 */
data class ConnpassSeries(
    val series: List<Series>
) : Serializable