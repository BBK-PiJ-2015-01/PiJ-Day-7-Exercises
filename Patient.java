  import java.util.Objects;
  
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
			nextPatient = null;
        }

        public void addPatient(Patient list, Patient newPatient) {

			if (nextPatient == null || Objects.equals(nextPatient, list)) {
				nextPatient = newPatient;
				if (newPatient.nextPatient == null) {
					nextPatient.nextPatient = list;
				}				
			} else if (!Objects.equals(nextPatient, list)) {
				nextPatient.addPatient(list, newPatient);
			}
        }

		public boolean deletePatient(Patient list, Patient patient) {

			if (this.nextPatient.equals(patient)) {
                // We found it! It is the next one!
                // Now link this patient to the one after the next
                this.nextPatient = nextPatient.nextPatient;
                return true;
            } else if (!Objects.equals(nextPatient, list)) {
                return this.nextPatient.deletePatient(list, patient);
            }
			return false;
        }
		
        public boolean deletePatient(Patient patient) {

			if (this.nextPatient.equals(patient)) {
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
		
	
		public int length() {
			
			return nextPatient == null ? 1 : nextPatient.length() + 1;
		}

		public void printList(Patient list) {

            System.out.println(this);
            if (nextPatient != null && !Objects.equals(nextPatient, list)) {
                nextPatient.printList(list);
            }
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