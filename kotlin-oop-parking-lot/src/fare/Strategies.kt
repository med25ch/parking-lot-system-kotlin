package fare

import java.math.BigDecimal

object WeekdayFareStrategy : BaseFareStrategy() {

    override val smallMultiplier = BigDecimal("1.5")
    override val mediumMultiplier = BigDecimal("2.5")
    override val largeMultiplier = BigDecimal("3.5")
}

object WeekendFareStrategy : BaseFareStrategy() {
    override val smallMultiplier = BigDecimal("2.0")
    override val mediumMultiplier = BigDecimal("3.0")
    override val largeMultiplier = BigDecimal("4.0")
}