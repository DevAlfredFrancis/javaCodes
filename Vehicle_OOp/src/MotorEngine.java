/**
 * Ramos
 * */

public class MotorEngine {
    private int cc;
    private int hp;
    private int torque;

    //constructor
    public MotorEngine(int cc, int hp, int torque) {
        this.cc = cc;
        this.hp = hp;
        this.torque = torque;
    }

    //getters
    public int getCc() {
        return cc;
    }

    public int getHp() {
        return hp;
    }

    public int getTorque() {
        return torque;
    }

    //method isRunning
    public void isRunning() {
        System.out.println("engine is running..");
    }
}
