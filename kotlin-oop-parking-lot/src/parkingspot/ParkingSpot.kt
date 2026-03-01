package parkingspot

import vehicle.Vehicle
import vehicle.VehicleSize

interface ParkingSpot {
    fun isAvailable() : Boolean
    fun occupy(vehicle: Vehicle) : Boolean
    fun vacate()
    val spotNumber : Int
    val size : VehicleSize
}