import java.util.Objects;

public class Exercise7 {

	private IntegerQueue queue = new IntegerQueue();

    public static void main(String[] args) {

        new Exercise7().exercise7Runner();
		
    }

    private void exercise7Runner() {
		
		queue.insert(8);
		queue.insert(6);
		queue.insert(7);
		queue.insert(5);
		queue.insert(3);
		queue.insert(0);
		queue.insert(9);		
		queue.printList();
		
		System.out.println("Retrieve end of queue: " + queue.retrieve());
		System.out.println("Queue size: " + queue.size());
		
		
    }
}