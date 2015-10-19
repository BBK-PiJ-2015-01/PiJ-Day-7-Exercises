import java.util.Objects;

public class Exercise3 {

    private Patient patientList;

    public static void main(String[] args) {

        new Exercise3().exercise3Runner();

    }

    private void exercise3Runner() {

        patientList = new Patient("John Doe", 33, "Septicemia");
        patientList.addPatient(new Patient("John Smith", 65, "Measles"));
        patientList.addPatient(new Patient("Graeme Wilkinson", 23, "Influenza"));
        patientList.addPatient(new Patient("Sinan Goktas", 31, "Athlete's foot"));
        patientList.addPatient(new Patient("David Asfaha", 43, "Anthrax"));
        patientList.addPatient(new Patient("Peter Domokos", 27, "Bubonic plague"));
        patientList.addPatient(new Patient("Steven Jenkins", 26, "Cat Scratch Fever"));
        patientList.addPatient(new Patient("Harry Wright", 65, "Dengue Fever"));
        patientList.addPatient(new Patient("Chris Kimberley", 83, "Isoporiasis"));
        patientList.addPatient(new Patient("Bessie Fahy", 18, "Stupidity"));
        patientList.printList();

        System.out.println("\nNow perform the deletes\n");
        patientList.deletePatient(new Patient("Steven Jenkins", 26, "Cat Scratch Fever"));
        patientList.deletePatient(new Patient("Chris Kimberley", 83, "Isoporiasis"));
        patientList.deletePatient(new Patient("Graeme Wilkinson", 23, "Influenza"));
        patientList.printList();
        
        System.out.println("\nNow delete the first member\n");
        patientList = patientList.getNextPatient();
        patientList.printList();

    }

    public class Patient {

        private final String name;
        private final int age;
        private final String illness;
        private Patient nextPatient;
        //
        private final String printFormat = "Patient '%s' (%d) has %s";

        public Patient(String name, int age, String illness) {

            this.name = name;
            this.age = age;
            this.illness = illness;
            this.nextPatient = null;
        }

        public void addPatient(Patient newPatient) {

            if (this.nextPatient == null) {
                // this means this is the last patient in the list
                this.nextPatient = newPatient;
            } else {
                this.nextPatient.addPatient(newPatient);
            }
        }

        public boolean deletePatient(Patient patient) {
            if (this.nextPatient == null) {
                // patient to remove was not found
                return false;
            } else if (this.nextPatient.equals(patient)) {
                // We found it! It is the next one!
                // Now link this patient to the one after the next
                this.nextPatient = nextPatient.nextPatient;
                return true;
            } else {
                return this.nextPatient.deletePatient(patient);
            }
        }

        public Patient getNextPatient() {
            return nextPatient;
        }
        

        public void printList() {

            System.out.println(this);
            if (nextPatient != null) {
                nextPatient.printList();
            }
        }

        @Override
        public String toString() {

            return String.format(printFormat, name, age, illness);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Patient other = (Patient) obj;
            if (!Objects.equals(this.name, other.name)) {
                return false;
            }
            if (this.age != other.age) {
                return false;
            }
            if (!Objects.equals(this.illness, other.illness)) {
                return false;
            }
            return true;
        }

    }

}

