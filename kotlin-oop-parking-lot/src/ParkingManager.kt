import parkingspot.ParkingSpot
import vehicle.Vehicle
import vehicle.VehicleSize

class ParkingManager {

    private val vehicleToSpotMap: MutableMap<String, ParkingSpot> = mutableMapOf()
    private val spots: MutableList<ParkingSpot> = mutableListOf()

    fun parkVehicle(vehicle: Vehicle): Boolean {
        val spot = findAvailableSlotForVehicleSize(vehicle.size) ?: return false

        if(!spot.occupy(vehicle)) return false

        vehicleToSpotMap[vehicle.licensePlate] = spot
        return true
    }

    fun unparkVehicle(vehicle: Vehicle) : Boolean {
        val spot = vehicleToSpotMap.remove(vehicle.licensePlate) ?: return false
        spot.vacate()
        return true
    }

    fun availableParkingSpots(): List<ParkingSpot> {
        return spots.filter { it.isAvailable() }
    }

    fun findAvailableSlotForVehicleSize(size: VehicleSize): ParkingSpot? {
        return spots.find { it.isAvailable() && it.size == size}
    }

}