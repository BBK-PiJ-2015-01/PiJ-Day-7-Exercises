
public class Exercise8 {

	private IntegerStack stack = new IntegerStack();

    public static void main(String[] args) {

        new Exercise8().exercise8Runner();
		
    }

    private void exercise8Runner() {
		
		stack.push(8);
		stack.push(6);
		stack.push(7);
		stack.push(5);
		stack.push(3);
		stack.push(0);
		stack.push(9);		
		stack.printList();
		System.out.println("Stack is " + (stack.empty() ? "EMPTY!" : "NOT empty" ));
//		System.out.println("Retrieve end of queue: " + queue.retrieve());
//		System.out.println("Queue size: " + queue.size());
		
		
    }
}