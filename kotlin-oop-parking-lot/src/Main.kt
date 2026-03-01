import parkingspot.CompactSPot
import vehicle.Vehicle
import vehicle.VehicleSize


fun main() {
    val car = Vehicle.Car("ABC-123")
    val compactSPot = CompactSPot(4, VehicleSize.SMALL)

    print(compactSPot.occupy(car))
}