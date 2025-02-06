package DSA.Design_Patterns;

class Main {

  public static void main(String[] args) {
    VehicleFactory carFactory = new CarFactory();
    VehicleFactory truckFactory = new TruckFactory();
    VehicleFactory bikeFactory = new BikeFactory();

    Vehicle myCar = carFactory.createVehicle();
    Vehicle myTruck = truckFactory.createVehicle();
    Vehicle myBike = bikeFactory.createVehicle();

    myCar.getType();   // "Car"
    myTruck.getType(); // "Truck"
    myBike.getType();  // "Bike"
  }
}

interface Vehicle {
  String getType();
}

class Car implements Vehicle {
  @Override
  public String getType() {
    return "Car";
  }
}

class Bike implements Vehicle {
  @Override
  public String getType() {
    return "Bike";
  }
}

class Truck implements Vehicle {
  @Override
  public String getType() {
    return "Truck";
  }
}

abstract class VehicleFactory {
  abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
  // Write your code here
  public Vehicle createVehicle() {
    return new Car();
  }
}

class BikeFactory extends VehicleFactory {
  // Write your code here
  public Vehicle createVehicle() {
    return new Bike();
  }
}

class TruckFactory extends VehicleFactory {
  // Write your code here
  public Vehicle createVehicle() {
    return new Truck();
  }
}

