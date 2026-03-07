import fare.FareCalculator
import fare.WeekdayFareStrategy
import parkingspot.CompactSPot
import ticket.Ticket
import vehicle.Vehicle
import java.math.BigDecimal
import java.time.LocalDateTime


fun main() {
    val car = Vehicle.Car("ABC-123")

    val compactSPot = CompactSPot(4)

    val ticket = Ticket(
        "dddd",
        car,
        compactSPot,
        LocalDateTime.now(),
        LocalDateTime.now().plusHours(5)
    )

    val fareCalculator = FareCalculator(WeekdayFareStrategy)

    val price = fareCalculator.calculateParkingPrice(ticket)

    print(price)
}