package vehicle

sealed class Vehicle(open val licensePlate: String) {

    abstract val size: VehicleSize

    class Motorcycle(override val licensePlate: String) : Vehicle(licensePlate){
        override val size = VehicleSize.SMALL
    }

    class Car(override val licensePlate: String) : Vehicle(licensePlate){
        override val size = VehicleSize.MEDIUM
    }

    class Truck(override val licensePlate: String) : Vehicle(licensePlate){
        override val size = VehicleSize.LARGE
    }
}