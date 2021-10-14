import java.util.ArrayList;

public class Ship {

    private String name;
    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public void setName(String n){
        name = n;
    }
    public String checkYourself(String userInput) {

        String result = "miss";

        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);


            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("You sunk " + name);
            } else {
                result = "hit";
            }
        }
        return result;
    }
}

