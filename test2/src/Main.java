public class Main {
    public static void main(String[ ] args) {
        int x = 5;
        addOneTo(x);
        System.out.println(x);
    }

    static void addOneTo(int num) {
        num = num + 1;
        System.out.println(num);
    }
}