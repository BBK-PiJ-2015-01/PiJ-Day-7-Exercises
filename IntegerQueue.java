public class IntegerQueue {

	private IntegerElement headOfQueue;
	
	public void insert(Integer value) {

		IntegerElement element = new IntegerElement(value);
		if (headOfQueue != null) {
			element.insert(headOfQueue);
		}
		headOfQueue = element;
	}
	
	public Integer retrieve() {
		
		return headOfQueue == null ? null : headOfQueue.retrieve();
	}
	
	public Integer size() {
		
		return headOfQueue == null ? 0 : headOfQueue.size();
	}
	
	public void printList() {

		if (headOfQueue != null) {
			headOfQueue.printList();
		}
	}
	class IntegerElement {

		private final Integer value;
		private IntegerElement nextElement;
		//
		private final String printFormat = "%d";

		public IntegerElement(Integer value) {

			this.value = value;
			nextElement = null;
		}

		public void insert(IntegerElement element) {

			nextElement = element;
		}
		
		public Integer retrieve() {
			
			return nextElement == null ? value : nextElement.retrieve();
		}

		public IntegerElement getNextElement() {
			return nextElement;
		}
				
		public void setNextElement(IntegerElement nextElement) {
			this.nextElement = nextElement;
		}
		
		public int getValue() {
			return value;
		}

		public int length() {
			
			return nextElement == null ? 1 : nextElement.length() + 1;
		}

		public void printList() {

			System.out.println(this);
			if (nextElement != null) {
				nextElement.printList();
			}
		}
		
		public int size() {
			
			return nextElement == null ? 1 : nextElement.size() + 1; 
		}

		@Override
		public String toString() {

			return String.format(printFormat, value);
		}
	}	
}