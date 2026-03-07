package parkinglot

import ParkingManager
import fare.FareCalculator
import ticket.Ticket
import vehicle.Vehicle
import java.math.BigDecimal
import java.sql.Time
import java.time.LocalDateTime

class ParkingLot(
    private val parkingManager: ParkingManager,
    private val fareCalculator: FareCalculator
) {

    fun enterVehicle(vehicle: Vehicle): ParkingResult<Ticket> {
        // find available spot for vehicle
        val spot = parkingManager.findAvailableSlotForVehicleSize(vehicle.size)
            ?: return ParkingResult.Failure("No available spot for ${vehicle.size}")

        // park vehicle
        parkingManager.parkVehicle(vehicle)

        // return Ticket
        return ParkingResult.Success(
            Ticket.create(
                vehicle,
                spot
            )
        )

    }

    fun leaveVehicle(ticket: Ticket): ParkingResult<BigDecimal> {

        // calculate price
        val price = fareCalculator.calculateParkingPrice(ticket)

        // release spot
        parkingManager.unparkVehicle(ticket.vehicle)

        // return final price
        return ParkingResult.Success(price)
    }
}

sealed class ParkingResult<out T> {
    data class Success<T>(val value: T) : ParkingResult<T>()
    data class Failure(val reason: String) : ParkingResult<Nothing>()
}