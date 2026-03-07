package ticket

import parkingspot.ParkingSpot
import vehicle.Vehicle
import java.time.Duration
import java.time.LocalDateTime

data class Ticket(
    val ticketId: String,
    val vehicle: Vehicle,
    val parkingSpot: ParkingSpot,
    val entryTime: LocalDateTime,
    val exitTime: LocalDateTime? = null,
) {
    fun calculateParkingDuration(): Long {
        return exitTime.let {
            Duration.between(entryTime, it).toHours()
        }
    }
}
