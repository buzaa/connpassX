package giavu.co.jp.repository.local

import java.util.*

object DatetimeUtils {

    fun getIntegerToday(): Int {
        return with(Calendar.getInstance()) {
            this.get(Calendar.YEAR).toString()
                .plus(this.get(Calendar.MONTH).toString())
                .plus(this.get(Calendar.DATE).toString())
                .toInt()
        }
    }
    fun getIntegerThisMonth(): Int {
        return with(Calendar.getInstance()) {
            this.get(Calendar.YEAR).toString()
                .plus(this.get(Calendar.MONTH).toString())
                .toInt()
        }
    }
}
