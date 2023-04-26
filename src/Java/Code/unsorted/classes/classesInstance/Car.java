package Java.Code.unsorted.classes.classesInstance;

import Java.Code.unsorted.interfaces.FourWheeler;
import Java.Code.unsorted.interfaces.Vehicle;

public class Car implements Vehicle, FourWheeler {

    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("I am a car!");
    }
}
