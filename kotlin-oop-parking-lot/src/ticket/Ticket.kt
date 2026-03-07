package ticket

import parkingspot.ParkingSpot
import vehicle.Vehicle
import java.time.Duration
import java.time.LocalDateTime
import java.util.UUID

data class Ticket(
    val ticketId: String,
    val vehicle: Vehicle,
    val parkingSpot: ParkingSpot,
    val entryTime: LocalDateTime,
    val exitTime: LocalDateTime? = null,
) {
    companion object {
        fun create(vehicle: Vehicle, parkingSpot: ParkingSpot): Ticket = Ticket(
            ticketId = UUID.randomUUID().toString(),
            vehicle = vehicle,
            parkingSpot = parkingSpot,
            entryTime = LocalDateTime.now()
        )
    }

    fun calculateParkingDuration(): Long =
        Duration.between(entryTime, exitTime ?: LocalDateTime.now()).toHours()
}
