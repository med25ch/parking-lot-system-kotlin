package fare

import ticket.Ticket
import java.math.BigDecimal

interface FareStrategy {
    fun calculateParkingPrice(ticket: Ticket): BigDecimal
}