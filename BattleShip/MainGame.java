import java.util.ArrayList;

public class MainGame {
    //initALIZE THE VARIABLES
    private Helper helper = new Helper();
    private ArrayList<Ship> dotComsList = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        //creating 3 objects od simple dot com object
        Ship one = new Ship();
        Ship two = new Ship();
        Ship three = new Ship();

        one.setName("Felix's boat");
        two.setName("Freddy's Ship");
        three.setName("Tom's Ship");

        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        //print brief instruction to the user
        System.out.println("Your objective is to sink the boats");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Destroy the boats in the fewest number of guesses");

        //repeat with each dotCom in the list
        for (Ship dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation); //call the setter method on this dotcom to give it the location you just got from the helper
        }
    }

    private void startPlaying() {
        while (!dotComsList.isEmpty()) { //as long as the dotComList is not empty loop
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);// call checkUserGuessMethod
        }
        finishGame(); //call finish game Method
    }


    private void checkUserGuess(String userGuess) {
        numOfGuesses++; //increment the no. of guesses
        String result = "miss"; //default value miss

        for (int x = 0; x < dotComsList.size(); x++) { //repeat with all dotCom in the list
            result = dotComsList.get(x).checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                dotComsList.remove(x);
                break;
            }
        }
        System.out.println(result); //print the result of the user
    }

    private void finishGame() {
        //print message
        System.out.println("All the ships have sunk");
        if (numOfGuesses <= 18) {
            System.out.println("It took you " + numOfGuesses + "guesses");
            System.out.println("Your survived");

        } else {
            System.out.println("About time " + numOfGuesses + " Really!!");
            System.out.println("If I could get a dine for the number of guesses I would be a millionaire ");
        }

    }

    public static void main(String[] args) {
        MainGame game = new MainGame(); //create the game object
        game.setUpGame();
        game.startPlaying();
    }
}
