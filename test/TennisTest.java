import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TennisTest {
    @Test
    public void TestTennisConstructor() {
        Tennis validGame = new Tennis("Ernst Kuzorra", "Stan Libuda");
        Assertions.assertEquals(validGame.getPlayer1().getName(), "Ernst Kuzorra");
        Assertions.assertEquals(validGame.getPlayer2().getName(), "Stan Libuda");

        //Grenzfallbetrachtung maximale Namenslänge
        Tennis validGameMaxNameLength = new Tennis("a".repeat(100), "b".repeat(100));
        Assertions.assertEquals(validGameMaxNameLength.getPlayer1().getName(), "a".repeat(100));
        Assertions.assertEquals(validGameMaxNameLength.getPlayer2().getName(), "b".repeat(100));

        //Grenzfallbetrachtung Namenslänge = 1
        Tennis validGameMinNameLength = new Tennis("a", "b");
        Assertions.assertEquals(validGameMinNameLength.getPlayer1().getName(), "a");
        Assertions.assertEquals(validGameMinNameLength.getPlayer2().getName(), "b");

        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Tennis("Ernst Kuzorra", ""));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Tennis("", "Stan Libuda"));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Tennis("Ernst Kuzorra", "a".repeat(101)));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Tennis("a".repeat(101), "Stan Libuda"));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Tennis("Ernst Kuzorra", null));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new Tennis(null, "Stan Libuda"));
    }
    @Test
    public void TestEnded(){
        //Game did not end
        Assertions.assertFalse(GameStatus.ended(5, 4));
        Assertions.assertFalse(GameStatus.ended(4, 5));
        //Grenzfall Unentschieden
        Assertions.assertFalse(GameStatus.ended(5, 5));
        //Grenzfall 0
        Assertions.assertFalse(GameStatus.ended(0, 0));
        //Grenzfall >=2 Punkte Vorsprung aber weniger als 4 Punkte
        Assertions.assertFalse(GameStatus.ended(3, 1));
        Assertions.assertFalse(GameStatus.ended(0, 3));

        //Game did end
        Assertions.assertTrue(GameStatus.ended(5, 3));
        Assertions.assertTrue(GameStatus.ended(3, 5));
        //Grenzfall Gewinn zu Null
        Assertions.assertTrue(GameStatus.ended(4, 0));
        Assertions.assertTrue(GameStatus.ended(0, 4));

        Assertions.assertThrows(IllegalArgumentException.class, ()-> GameStatus.ended(-2, 2));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> GameStatus.ended(2, -2));

        // Values out of Integer-Range or Null do not compile.
    }
}
