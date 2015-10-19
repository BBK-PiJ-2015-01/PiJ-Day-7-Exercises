import java.util.Objects;

public class Exercise5 {

    private Patient firstPatient;
	private Patient middlePatient;
	private Patient lastPatient;
	//
	

    public static void main(String[] args) {

//        new Exercise5().exercise5Deletion();
		new Exercise5().exercise5FurtherDeletion();

    }

    private void exercise5Runner() {

        firstPatient = new Patient("John Doe", 33, "Septicemia");
        firstPatient.addPatient(new Patient("John Smith", 65, "Measles"));
        firstPatient.addPatient(new Patient("Graeme Wilkinson", 23, "Influenza"));
        firstPatient.addPatient(new Patient("Sinan Goktas", 31, "Athlete's foot"));
        firstPatient.addPatient(new Patient("David Asfaha", 43, "Anthrax"));

		Patient middlePatient = new Patient("Peter Domokos", 27, "Bubonic plague");
		firstPatient.addPatient(middlePatient);
				
        firstPatient.addPatient(new Patient("Steven Jenkins", 26, "Cat Scratch Fever"));
        firstPatient.addPatient(new Patient("Harry Wright", 65, "Dengue Fever"));
        firstPatient.addPatient(new Patient("Chris Kimberley", 83, "Isoporiasis"));
		
		Patient lastPatient = new Patient("Bessie Fahy", 18, "Stupidity");
        firstPatient.addPatient(lastPatient);
		
		System.out.println("Start of forward iteration for all patients\n");
        iterateForwards(firstPatient);
		System.out.println("Start of forward iteration for middle patients\n");
		iterateForwards(middlePatient);
		System.out.println("Start of forward iteration for end patients\n");
		iterateForwards(lastPatient);
		
		System.out.println("Start of backwards iteration for all patients\n");
        iterateBackwards(firstPatient);
		System.out.println("Start of backwards iteration for middle patients\n");
		iterateBackwards(middlePatient);
		System.out.println("Start of backwards iteration for end patients\n");
		iterateBackwards(lastPatient);
		
		// Delete the middle patient
		firstPatient.deletePatient(middlePatient);
		iterateForwards(firstPatient);
		iterateBackwards(lastPatient);
    }
	
	private void exercise5Deletion() {
		
		populatefirstPatient();
		// Delete the middle patient
		firstPatient.deletePatient(middlePatient);
		System.out.println("\nIterate forward after deletion. '" + middlePatient + "' should not be found\n");
		iterateForwards(firstPatient);
		
		System.out.println("\nIterate backwards after deletion. '" + middlePatient + "' should not be found\n");
		iterateBackwards(lastPatient);
	}
	
	private void exercise5FurtherDeletion() {
		
		populatefirstPatient();
		// Delete the first patient
		firstPatient.deletePatient(firstPatient);
		
		System.out.println("\nIterate backwards after deletion. '" + firstPatient + "' should not be found\n");
		iterateBackwards(lastPatient);
		
		Patient unlinkedPatient = new Patient("Tony Stark", 40, "Megalomania");
		System.out.println("\nDeleting '" + unlinkedPatient + "'. Patient was " + (firstPatient.deletePatient(unlinkedPatient) ? "Found!" : "NOT found ") + "\n");
		
	}
	
	private void populatefirstPatient() {
		
		firstPatient = new Patient("John Doe", 33, "Septicemia");
        firstPatient.addPatient(new Patient("John Smith", 65, "Measles"));
        firstPatient.addPatient(new Patient("Graeme Wilkinson", 23, "Influenza"));
        firstPatient.addPatient(new Patient("Sinan Goktas", 31, "Athlete's foot"));
        firstPatient.addPatient(new Patient("David Asfaha", 43, "Anthrax"));

		middlePatient = new Patient("Peter Domokos", 27, "Bubonic plague");
		firstPatient.addPatient(middlePatient);
				
        firstPatient.addPatient(new Patient("Steven Jenkins", 26, "Cat Scratch Fever"));
        firstPatient.addPatient(new Patient("Harry Wright", 65, "Dengue Fever"));
        firstPatient.addPatient(new Patient("Chris Kimberley", 83, "Isoporiasis"));
		
		lastPatient = new Patient("Bessie Fahy", 18, "Stupidity");
        firstPatient.addPatient(lastPatient);
	}
	
	private void iterateForwards(Patient patient) {
		
		while (patient != null ) {
			
			System.out.println(patient);
			patient = patient.getNextPatient();			
		}
	}
	
	private void iterateBackwards(Patient patient) {
		
		while (patient != null ) {
			
			System.out.println(patient);
			patient = patient.getPreviousPatient();			
		}
	}
	
	private int iterativeCount() {
		
		Patient nextPatient = firstPatient;
		int patientCount = nextPatient == null ? 0 : 1;
		while (nextPatient != null && nextPatient.getNextPatient() != null) {
			nextPatient = nextPatient.getNextPatient();
			patientCount++;
		}
		return patientCount;
	}

    public class Patient {

        private final String name;
        private final int age;
        private final String illness;
        private Patient nextPatient;
        private Patient previousPatient;
        //
        private final String printFormat = "Patient '%s' (%d) has %s";

        public Patient(String name, int age, String illness) {

            this.name = name;
            this.age = age;
            this.illness = illness;
            previousPatient = null;
			nextPatient = null;
        }

        public void addPatient(Patient newPatient) {

            if (this.nextPatient == null) {
                // this means this is the last patient in the list
                this.nextPatient = newPatient;
				newPatient.setPreviousPatient(this);
            } else {
                this.nextPatient.addPatient(newPatient);
            }
        }

		public boolean deletePatient(Patient patient) {
			
            if (this == patient) {
				
				if (nextPatient != null) {
					nextPatient.setPreviousPatient(previousPatient);					
				}				
				if (previousPatient != null) {
					previousPatient.setNextPatient(nextPatient);					
				}				
                return true;
            }  else if (nextPatient != null) {
                return nextPatient.deletePatient(patient);
            }
			return false;
        }

        public Patient getNextPatient() {
            return nextPatient;
        }
		
		public void setNextPatient(Patient nextPatient) {
			this.nextPatient = nextPatient;
		}
		
		public Patient getPreviousPatient() {
			return previousPatient;
		}
		
        public void setPreviousPatient(Patient previousPatient) {
			this.previousPatient = previousPatient;
		}
		
		public int length() {
			
			return nextPatient == null ? 1 : nextPatient.length() + 1;
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

