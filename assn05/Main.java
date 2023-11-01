package assn05;

public class Main {

    public static void main(String[] args) {
        testP1();
        testP2();
//        testP3();
        testP4();
    }

    // test Part 1
    public static void testP1(){
        /*
        Part 1 - Write some tests to convince yourself that your code for Part 1 is working
         */
        SimpleEmergencyRoom er = new SimpleEmergencyRoom();
        er.addPatient("joe", 1);
        er.addPatient("shane", 5);
        er.addPatient("sean", 88);
        er.addPatient("will", 12);
        er.addPatient("nig", 7);
        er.addPatient("chink", 15);
        er.addPatient("sam", 3);
        System.out.println(er.getPatients());
        System.out.println(er.dequeue());
        System.out.println(er.getPatients());

    }

    // test Part 2
    public static void testP2(){
       /*
        Part 2 - Write some tests to convince yourself that your code for Part 2 is working
         */
        MaxBinHeapER er = new MaxBinHeapER<>();
        er.enqueue("joe", 1);
        er.enqueue("shane", 5);
        er.enqueue("sean", 88);
        er.enqueue("will", 12);
        er.enqueue("nig", 7);
        er.enqueue("chink", 15);
        er.enqueue("sam", 3);
        er.enqueue("joshy");
        System.out.println(er.getAsArray());
        System.out.println(er.dequeue());
        System.out.println(er.getAsArray());
    }

    /*
    Part 3
     */
    public static void testP3(){
        MaxBinHeapER transfer = new MaxBinHeapER(makePatients());
        Prioritized[] arr = transfer.getAsArray();
        for(int i = 0; i < transfer.size(); i++) {
            System.out.println("Value: " + arr[i].getValue()
                    + ", Priority: " + arr[i].getPriority());
        }
    }

    /*
    Part 4
     */
    public static void testP4() {
               /*
        Part 4 - Write some tests to convince yourself that your code for Part 4 is working
         */
        SimpleEmergencyRoom simple = new SimpleEmergencyRoom();
        MaxBinHeapER heap = new MaxBinHeapER();
        int s = (int) System.nanoTime();
        fillER(simple);
        System.out.println(s);
        s = (int) System.nanoTime();
        fillER(heap);
        System.out.println(s);

    }

    public static void fillER(MaxBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }
    
    public static double[] compareRuntimes() {
    	// Array which you will populate as part of Part 4
    	double[] results = new double[4];
    	
        SimpleEmergencyRoom simplePQ = new SimpleEmergencyRoom();
        fillER(simplePQ);

        // Code for (Task 4.1) Here


        MaxBinHeapER binHeap = new MaxBinHeapER();
        fillER(binHeap);

        // Code for (Task 4.2) Here

        return results;
    }

}



