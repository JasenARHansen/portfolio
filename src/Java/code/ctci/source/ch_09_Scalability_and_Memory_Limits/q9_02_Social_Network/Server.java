package Java.code.ctci.source.ch_09_Scalability_and_Memory_Limits.q9_02_Social_Network;

import java.util.HashMap;

@SuppressWarnings("unused")
public class Server {
    HashMap<Integer, Machine> machines = new HashMap<>();
    HashMap<Integer, Integer> personToMachineMap = new HashMap<>();

    public int getMachineIDForUser(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        return machineID == null ? -1 : machineID;
    }

    public Person getPersonWithID(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        if (machineID == null) {
            return null;
        }
        Machine machine = getMachineWithId(machineID);
        if (machine == null) {
            return null;
        }
        return machine.getPersonWithID(personID);
    }

    public Machine getMachineWithId(int machineID) {
        return machines.get(machineID);
    }
}
