import java.util.ArrayList;
import java.util.List;

public class Game {


    private List<Player> registeredList = new ArrayList<>();


    public void register(Player player) {
        registeredList.add(player);
    }

    public List<Player> getAllRegistered() {
        return registeredList;
    }

    public boolean matches(Player player, String search) {
        if (player.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public Player searchByName(String text) {
        Player playerA = new Player();
        int counter = 0;
        for (Player player : registeredList) {
            if (matches(player, text)) {
                playerA = registeredList.get(counter);
            }
            counter++;
        }
        return playerA;
    }


    public int round(String playerName1, String playerName2) {
        int winner = -1;
        if (!registeredList.contains(searchByName(playerName1))) {

            throw new NotRegisteredException("Игрок с именем:" + playerName1 + "не зарегистрирован");
        }


        if (!registeredList.contains(searchByName(playerName2))) {
            throw new NotRegisteredException("Игрок с именем:" + playerName2 + "не зарегистрирован");
        }

        if (searchByName(playerName1).getStrength() > searchByName(playerName2).getStrength()) {
            winner = 1;
        }
        if (searchByName(playerName1).getStrength() < searchByName(playerName2).getStrength()) {
            winner = 2;
        }
        if (searchByName(playerName1).getStrength() == searchByName(playerName2).getStrength()) {
            winner = 0;
        }
        return winner;
    }


}
