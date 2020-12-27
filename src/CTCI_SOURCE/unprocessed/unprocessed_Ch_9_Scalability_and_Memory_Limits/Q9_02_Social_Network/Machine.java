package CTCI_SOURCE.unprocessed.unprocessed_Ch_9_Scalability_and_Memory_Limits.Q9_02_Social_Network;

import java.util.HashMap;

public class Machine {
    public HashMap<Integer, Person> persons = new HashMap<>();
    public int machineID;

    public Person getPersonWithID(int personID) {
        return persons.get(personID);
    }
}
