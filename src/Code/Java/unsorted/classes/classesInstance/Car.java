package Code.Java.unsorted.classes.classesInstance;

import Code.Java.unsorted.interfaces.FourWheeler;
import Code.Java.unsorted.interfaces.Vehicle;

public class Car implements Vehicle, FourWheeler {

    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("I am a car!");
    }
}