public class Exercise2 {

    private int studentCount;
    private int distinctions;
    private int passes;
    private int fails;
    private int invalid;
    //
    private final int inputEndSignalValue = -1;
    private final String inputMessage = "Input a mark: ";
    private final String summaryMessage = "There are %d students: %d distinctions, %d pass, %d fails %s.";
    private final String invalidMessage = "(plus %d invalid).";
    private final int lowerLimit = 0;
    private final int passLimit = 50;
    private final int distinctionLimit = 70;
    private final int upperLimit = 100;

    public static void main(String[] args) {

        new Exercise2().exercise2Runner();
    }

    private void exercise2Runner() {

        int inputValue;
        do {
            inputValue = readInput();
            if (inputValue == inputEndSignalValue) {
                continue;
            }
            if ((inputValue < lowerLimit) || (inputValue > upperLimit)) {
                invalid++;
            } else {
                studentCount++;
                distinctions += inputValue >= distinctionLimit ? 1 : 0;
                passes += inputValue >= passLimit && inputValue < distinctionLimit ? 1 : 0;
                fails += inputValue < passLimit ? 1 : 0;

            }
        } while (inputValue != inputEndSignalValue);

    	String message = String.format(summaryMessage, studentCount, distinctions, passes, fails, invalid == 0 ? "" : String.format(invalidMessage, invalid));
	System.out.println(message);
    }


    private int readInput() {

        // Don't attempt to handle parsing exceptions
        return Integer.parseInt(System.console().readLine(inputMessage));
    }

}
