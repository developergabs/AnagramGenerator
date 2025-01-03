import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramGeneratorTest {

    @Test
    void testGenerateAnagramsValidInput() {
        List<String> result = AnagramGenerator.generateAnagrams("abc");
        assertEquals(6, result.size());
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));
    }

    @Test
    void testGenerateAnagramsSingleCharacter() {
        List<String> result = AnagramGenerator.generateAnagrams("a");
        assertEquals(1, result.size());
        assertTrue(result.contains("a"));
    }

    @Test
    void testGenerateAnagramsEmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AnagramGenerator.generateAnagrams("");
        });
        assertEquals("Input must not be null or empty.", exception.getMessage());
    }

    @Test
    void testGenerateAnagramsNullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AnagramGenerator.generateAnagrams(null);
        });
        assertEquals("Input must not be null or empty.", exception.getMessage());
    }

    @Test
    void testGenerateAnagramsNonLetterInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AnagramGenerator.generateAnagrams("abc1");
        });
        assertEquals("Input must contain only letters.", exception.getMessage());
    }
}
