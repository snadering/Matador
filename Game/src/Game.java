import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
    FileIO fileIO = new FileIO();
    TextUI textUI = new TextUI();
    private int startValue = 30000;
    private int maxPlayers = 6;

    private ArrayList<Player> players = new ArrayList<>();

    public void gameSetup(){
        ArrayList<String> data = fileIO.readGameData();
    //Check if there is game data available.
    if(data == null){
       data = textUI.getUserInput("Choose player name. Press Q to quit.", maxPlayers);


    }

    createPlayers(data);

    //else start dialog with user.
    }
    public void createPlayers(ArrayList<String> data){
        for (String s:data){
            String[] values = s.split(",");
            //example -- values[0] equals Egon
            //example -- values[1] equals 3000

            int amount;
            if(values.length > 1){
                amount = Integer.parseInt(values[1]);
            }else{
                amount = startValue;
            }


            Player p = new Player(values[0], amount);
            players.add(p);
        }

    }


    public void showPlayers(){
        for (Player p:players) {
            System.out.println(p);
        }

    }


} //class end
