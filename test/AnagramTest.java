import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnagramTest {
    @Test
    public void TestAnagram(){
        Assertions.assertFalse(AnagramCheck.isAnagram("TestWord", "Word:WithDifferentLength!!", true, false));
        Assertions.assertTrue(AnagramCheck.isAnagram("Funeral?", "Real Fun!", false, false));
        Assertions.assertFalse(AnagramCheck.isAnagram("test", "txst", true, true));
    }
}
