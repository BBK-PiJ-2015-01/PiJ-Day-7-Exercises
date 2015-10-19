public class Spy {
    
    public static int spyCount;    
    private final int id;
    //
    private final String creationMessage = "Spy %d has been created. Existing spies = %d";
    private final String dieMessage = "Spy %d has been detected and eliminated";

    public static void main(String[] args) {
        
        Spy spy001 = new Spy(1);
        Spy spy003 = new Spy(3);
        Spy spy007 = new Spy(7);
        spy001.die();
        spy003.die();
        System.out.println("Remaining spies = " + Spy.spyCount );
    }
    
    private void spyRunner() {
        
    }
    public Spy(int id) {
        this.id = id;
        Spy.spyCount++;
        System.out.println(String.format(creationMessage, this.id, Spy.spyCount));
    }
    
    public void die() {
        
        System.out.println(String.format(dieMessage, id));        
        Spy.spyCount--;
    }
    
}
