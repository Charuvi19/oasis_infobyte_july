import java.util.Scanner;
import java.util.Random;

public class task2 {
    /**
     * @param args
     */
    public static void main (String[] args) {
        int answer , guess ;
        final int MAX = 100;
        try (Scanner keyboard = new Scanner(System.in)) {
            Random rand = new Random();
            answer = rand.nextInt(MAX) + 1;
            System.out.println("Guess the number between 1 to 1004");
               guess = keyboard.nextInt();
        }
        if (guess == answer){
            System.out.println("Good job, the number was:" + answer);
        }
        else{
            System.out.println("Sorry, but the number was:" + answer );
        }
    }
}
