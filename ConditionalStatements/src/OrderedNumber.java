import java.util.Scanner;

public class OrderedNumber {

    public static void main(String[] args) {

        String w,x,y,z,concatWX, concatYZ; //input digits but datatype is string to concat to digits
        int convertedWX, convertedYZ; //convert concat strings to integer

        Scanner sc = new Scanner(System.in);

        System.out.print("Input your first digit: ");
        w = sc.next();

        System.out.print("Input your second digit: ");
        x = sc.next();

        System.out.print("Input your third digit: ");
        y = sc.next();

        System.out.print("Input your fourth digit: ");
        z = sc.next();

        concatWX = w + x ; //concat two digit1 and digit2
        concatYZ = y + z; //concat two digit3 and digit4

        convertedWX = Integer.parseInt(concatWX); //convert digit1 & digit2 to integer
        convertedYZ = Integer.parseInt(concatYZ); //convert digit3 & digit4 to integer

        int res1 = convertedYZ - convertedWX;
        int res2 = convertedWX - convertedYZ;

        if(res1 == 1 || res2 == 1) {
            System.out.println("ordered number");
        }else {
            System.out.println("unordered number!");
        }
    }
}

//    static int[] intToArray(int n) {
//        int j = 0;
//        int len = Integer.toString(n).length();
//        int[] arrNum = new int[len];
//
//        while(n!=0) {
//            arrNum[len-j-1] = n%10;
//            n = n / 10;
//            j++;
//        }
//        return arrNum;
//    }