package blair.carina.ATM;

import java.util.Scanner;

/**
 * Created by carinablair on 9/16/16.
 */
public class UserInputHandler {


    Scanner userInput = new Scanner(System.in);

    public int getUserInt(){
        return userInput.nextInt();
    }

    public String getUserString(){
        return userInput.next();
    }

    public double getUserDouble(){
        return userInput.nextDouble();
    }


}
