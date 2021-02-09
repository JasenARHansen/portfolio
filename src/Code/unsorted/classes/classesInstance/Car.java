package Code.unsorted.classes.classesInstance;

import Code.unsorted.interfaces.FourWheeler;
import Code.unsorted.interfaces.Vehicle;

public class Car implements Vehicle, FourWheeler {

    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("I am a car!");
    }
}
