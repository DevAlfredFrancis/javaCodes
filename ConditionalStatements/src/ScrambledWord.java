import java.util.Scanner;

public class ScrambledWord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String inputWord = sc.next();

        char[] wordArr = inputWord.toCharArray();

        for(int i=0; i<wordArr.length; i++) {
            int randomIndex = (int) (Math.random() * wordArr.length + 1);
            System.out.print(wordArr[randomIndex]);
        }

//        for(int i=0; i<wordArr.length/2; i++) {
//                char tempChar = wordArr[i];
//                wordArr[i] = wordArr[wordArr.length-1-i];
//                wordArr[wordArr.length-1-i] = tempChar;
//        }

//        for(int i=wordArr.length-1; i>=0; i--) {
//            System.out.print(wordArr[i]);
//        }

//        String scrambledWord = new String(wordArr);
//        System.out.print("Scramble word: " + scrambledWord);

        sc.close();
    }
}
