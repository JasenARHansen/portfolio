package classes.classesInstance;

import classes.unsorted.interfaces.FourWheeler;
import classes.unsorted.interfaces.Vehicle;

public class Car implements Vehicle, FourWheeler {

    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("I am a car!");
    }
}