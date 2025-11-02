package org.example.road;

import java.util.ArrayList;
import java.util.List;

import org.example.cars.Vehicle;
import org.example.people.Person;

public class Road {

    public List<Vehicle<? extends Person>> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        int count = 0;
        for (Vehicle<? extends Person> vehicle : carsInRoad) {
            count += vehicle.getNumberOfSeatPlaces();
        }
        return count;
    }

    public void addCarToRoad(Vehicle<? extends Person> vehicle) {
        carsInRoad.add(vehicle);
    }

    public void addCarsToRoad(List<Vehicle<? extends Person>> vehicles) {
        for (Vehicle<? extends Person> vehicle : vehicles) {
            addCarToRoad(vehicle);
        }
    }
}
