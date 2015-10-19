public class IntegerStack {

	private IntegerElement headOfStack;
	
	public void push(Integer value) {

		IntegerElement element = new IntegerElement(value);
		if (headOfStack != null) {
			element.push(headOfStack);
		}
		headOfStack = element;
	}
	
	public Integer pop() {
		
		if (empty()) {			
			return null;
		}
		Integer i = headOfStack.getValue();
		headOfStack = headOfStack.getNextElement();
		return i;
	}
	
	public boolean empty() {
		
		return headOfStack == null;
	}
	
	public void printList() {

		if (headOfStack != null) {
			headOfStack.printList();
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

		public void push(IntegerElement element) {

			nextElement = element;
		}

		public IntegerElement getNextElement() {
			return nextElement;
		}
				
		public void setNextElement(IntegerElement nextElement) {
			this.nextElement = nextElement;
		}
		
		public Integer getValue() {
			return value;
		}
		
		public void printList() {

			System.out.println(this);
			if (nextElement != null) {
				nextElement.printList();
			}
		}

		@Override
		public String toString() {

			return String.format(printFormat, value);
		}
	}	
}