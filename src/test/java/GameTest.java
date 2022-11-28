import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class GameTest {

    List<Player> playersList = new ArrayList<>();
    Player player1 = new Player(1, "Игрок 1", 3);
    Player player2 = new Player(2, "Игрок 2", 1);
    Player player3 = new Player(3, "Игрок 3", 6);
    Player player4 = new Player(4, "Игрок 4", 6);
    Player player5 = new Player(5, "Игрок 5", 5);
    Player player6 = new Player(6, "Игрок 6", 6);
    Player player7 = new Player(7, "Игрок 7", 4);
    Player player8 = new Player(8, "Игрок 8", 2);
    Game game = new Game();

    @BeforeEach
    public void setup() {
        playersList.add(player1);
        playersList.add(player2);
        playersList.add(player3);
        playersList.add(player4);
        playersList.add(player5);
        playersList.add(player6);
        playersList.add(player7);
        playersList.add(player8);
        game.register(player1);
        game.register(player4);
        game.register(player5);
        game.register(player6);
    }

    @Test

    public void shouldCreateRegisteredList() {


        List<Player> expected = Arrays.asList(player1, player4, player5, player6);
        List<Player> actual = game.getAllRegistered();

        Assertions.assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));

    }

    @Test
    public void shouldWinFirst() {
        int actual = game.round("Игрок 5", "Игрок 1");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecond() {
        int actual = game.round("Игрок 1", "Игрок 5");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinNoOne() {
        int actual = game.round("Игрок 4", "Игрок 6");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisteredException() {
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Игрок 2", "Игрок 4"));
    }

    @Test
    public void shouldNotRegisteredException1() {
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Игрок 1", "Игрок 2"));
    }
}
