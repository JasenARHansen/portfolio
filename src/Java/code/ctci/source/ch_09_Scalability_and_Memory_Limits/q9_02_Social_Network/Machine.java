package Java.code.ctci.source.ch_09_Scalability_and_Memory_Limits.q9_02_Social_Network;

import java.util.HashMap;

@SuppressWarnings("unused")
public class Machine {
  public HashMap<Integer, Person> persons = new HashMap<>();
  public int machineID;

  public Person getPersonWithID(int personID) {
    return persons.get(personID);
  }
}
