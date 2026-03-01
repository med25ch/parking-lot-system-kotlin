package parkingspot

import vehicle.Vehicle
import vehicle.VehicleSize

class CompactSPot(
    override val spotNumber: Int,
    override val size: VehicleSize
) : ParkingSpot {

    private var currentVehicle: Vehicle? = null

    override fun isAvailable(): Boolean {
        return currentVehicle == null
    }

    override fun occupy(vehicle: Vehicle): Boolean {
        if (!isAvailable()) {
            return false
        }

        if (vehicle.size != size){
            return false
        }

        currentVehicle = vehicle
        return true
    }

    override fun vacate() {
        currentVehicle = null
    }
}