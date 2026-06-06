/**
 * Ramos
 * */

public class BreakSystem {
    private boolean hasABS;

    public void applyBreak() {
        if(hasABS) {
            System.out.println("Applying the brake, the motorcycle maintains control and stability");
        }else {
            System.out.println("Defective break system..");
        }
    }

}

