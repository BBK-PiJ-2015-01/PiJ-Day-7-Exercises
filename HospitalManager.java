public class HospitalManager {

	private Patient patientListStart = null;
    private Patient firstPatient;
	private Patient middlePatient;
	private Patient lastPatient;

	public static void main(String[] args) {

		new HospitalManager().hospitalManager6Runner();

	}
	
	private void hospitalManager6Runner() {

		populatepatientListStart();
		patientListStart.printList(patientListStart);
		//
		System.out.println("\nList after deleting "+ middlePatient + "\n");
		patientListStart.deletePatient(patientListStart, middlePatient);
		patientListStart.printList(patientListStart);
		
		Patient unlinkedPatient = new Patient("Tony Stark", 40, "Megalomania");
		System.out.println("\nList after deleting "+ unlinkedPatient + "\n");
		patientListStart.deletePatient(patientListStart, unlinkedPatient);
		patientListStart.printList(patientListStart);		
    }
	
	private void populatepatientListStart() {
		
		firstPatient = new Patient("John Doe", 33, "Septicemia");
		patientListStart = firstPatient;
        firstPatient.addPatient(patientListStart, new Patient("John Smith", 65, "Measles"));
        firstPatient.addPatient(patientListStart, new Patient("Graeme Wilkinson", 23, "Influenza"));
        firstPatient.addPatient(patientListStart, new Patient("Sinan Goktas", 31, "Athlete's foot"));
        firstPatient.addPatient(patientListStart, new Patient("David Asfaha", 43, "Anthrax"));

		middlePatient = new Patient("Peter Domokos", 27, "Bubonic plague");
		firstPatient.addPatient(patientListStart, middlePatient);
				
        firstPatient.addPatient(patientListStart, new Patient("Steven Jenkins", 26, "Cat Scratch Fever"));
        firstPatient.addPatient(patientListStart, new Patient("Harry Wright", 65, "Dengue Fever"));
        firstPatient.addPatient(patientListStart, new Patient("Chris Kimberley", 83, "Isoporiasis"));
		
		lastPatient = new Patient("Bessie Fahy", 18, "Stupidity");
        firstPatient.addPatient(patientListStart, lastPatient);
	}

}