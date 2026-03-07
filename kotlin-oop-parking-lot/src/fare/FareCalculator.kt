package fare

import ticket.Ticket
import java.math.BigDecimal

class FareCalculator(private val strategy: FareStrategy) {

    fun calculateParkingPrice(ticket: Ticket): BigDecimal = strategy.calculateParkingPrice(ticket)

}