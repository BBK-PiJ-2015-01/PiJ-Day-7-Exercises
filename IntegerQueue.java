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
		
		IntegerElement e = headOfQueue == null ? null : headOfQueue.retrieve();
		if (e == headOfQueue) {
			Integer i = e.getValue();
			headOfQueue = null;
			return i;
		} else {
			return e == null ? null : e.getValue();
		}
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
		private IntegerElement prevElement;
		
		//
		private final String printFormat = "%d";

		public IntegerElement(Integer value) {

			this.value = value;
			nextElement = null;
		}

		public void insert(IntegerElement element) {

			nextElement = element;
			if (element != null) {
				element.setPrevElement(this);
			}
		}
		
		public IntegerElement retrieve() {
						
			IntegerElement returnElement = nextElement == null ? this : nextElement.retrieve();
			if (returnElement != null) {
				IntegerElement linkedElement =  returnElement.getPrevElement();
				if (linkedElement != null ) {
					linkedElement.setNextElement(null);
				}
			returnElement.setPrevElement(null);	
			}
			return returnElement;
		}

		public IntegerElement getNextElement() {
			return nextElement;
		}
				
		public void setNextElement(IntegerElement nextElement) {
			this.nextElement = nextElement;
		}
		
		public IntegerElement getPrevElement() {
			return prevElement;
		}
				
		public void setPrevElement(IntegerElement prevElement) {
			this.prevElement = prevElement;
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