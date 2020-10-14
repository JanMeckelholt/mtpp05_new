import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnagramTest {
    @Test
    public void TestAnagram(){
        Assertions.assertTrue(AnagramCheck.isAnagram("aaabe", "beaaa", false, false));
        Assertions.assertTrue(AnagramCheck.isAnagram("a", "A.:,", false, false));
        Assertions.assertTrue(AnagramCheck.isAnagram("aaabe", "beaaa", false, false));
        Assertions.assertTrue(AnagramCheck.isAnagram("aaabe", "beaaa", false, false));
        Assertions.assertTrue(AnagramCheck.isAnagram("aaabe", "beaaa", false, false));
    }
}
