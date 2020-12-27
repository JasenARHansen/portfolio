package CTCI_SOURCE.unprocessed.Ch_03_Stacks_and_Queues;

public class Q3_06_Animal_Shelter_Question {


    public static void main(String[] args) {
        Q3_06_Animal_ShelterAnimal_Queue animals = new Q3_06_Animal_ShelterAnimal_Queue();
        animals.enqueue(new Q3_06_Animal_Shelter_Cat("Callie"));
        animals.enqueue(new Q3_06_Animal_Shelter_Cat("Kiki"));
        animals.enqueue(new Q3_06_Animal_Shelter_Dog("Fido"));
        animals.enqueue(new Q3_06_Animal_Shelter_Dog("Dora"));
        animals.enqueue(new Q3_06_Animal_Shelter_Cat("Kari"));
        animals.enqueue(new Q3_06_Animal_Shelter_Dog("Dexter"));
        animals.enqueue(new Q3_06_Animal_Shelter_Dog("Dobo"));
        animals.enqueue(new Q3_06_Animal_Shelter_Cat("Copa"));

        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueAny().name());

        animals.enqueue(new Q3_06_Animal_Shelter_Dog("Dapa"));
        animals.enqueue(new Q3_06_Animal_Shelter_Cat("Kilo"));

        while (animals.size() != 0) {
            System.out.println(animals.dequeueAny().name());
        }
    }

}
