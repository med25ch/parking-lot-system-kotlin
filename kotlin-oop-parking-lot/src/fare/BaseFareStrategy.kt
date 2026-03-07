package fare


import ticket.Ticket
import vehicle.VehicleSize
import java.math.BigDecimal

abstract class BaseFareStrategy : FareStrategy {

    abstract val smallMultiplier: BigDecimal
    abstract val mediumMultiplier: BigDecimal
    abstract val largeMultiplier: BigDecimal

    override fun calculateParkingPrice(ticket: Ticket): BigDecimal {
        val multiplier = when (ticket.vehicle.size) {
            VehicleSize.SMALL -> smallMultiplier
            VehicleSize.MEDIUM -> mediumMultiplier
            VehicleSize.LARGE -> largeMultiplier
        }

        val hours = ticket.calculateParkingDuration()

        return multiplier.multiply(hours.toBigDecimal())
    }

}