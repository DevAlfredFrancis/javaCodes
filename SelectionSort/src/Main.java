public class Main {

    public static void main(String[] args) {

        int[] randNumArr = new int[10]; //array size is 10

        for(int i=0; i<randNumArr.length; i++) { //loop based in the array size
            boolean isDuplicate;
            int randomNum;

            do {
                randomNum = (int)(Math.random() * 101);
                isDuplicate = false;

                for (int j = 0; j<i; j++) { //check if the random number has the same value in the array
                    if (randNumArr[j] == randomNum) {
                        isDuplicate = true;
                        break;
                    }
                }
            }while(isDuplicate);
            randNumArr[i] = randomNum;
        }

        System.out.print("Random Numbers in the array: ");
        for(int number : randNumArr) {
            System.out.print( number + " ");
        }

    }
}