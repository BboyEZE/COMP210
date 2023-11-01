package assn05;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients;

    public SimpleEmergencyRoom() {
        patients = new ArrayList<>();
    }

    // TODO: dequeue
    public Patient dequeue() {
    	if(patients.isEmpty()){
            return null;
        }
        else{
            if(patients.size() == 1){
                patients.remove(0);
                return null;
            }
            else{
                Patient bob = patients.get(0);
                int k = 0;
                for (int i = 1; i < patients.size(); i++){
                    if(bob.getPriority().compareTo(patients.get(i).getPriority()) < 0){
                        bob = patients.get(i);
                        k = i;
                    }
                }
                patients.remove(k);
                return bob;

            }
        }

    }

    public <V, P> void addPatient(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        patients.add(patient);
    }

    public <V> void addPatient(V value) {
        Patient patient = new Patient(value);
        patients.add(patient);
    }

    public List getPatients() {
        return patients;
    }

    public int size() {
        return patients.size();
    }

}
