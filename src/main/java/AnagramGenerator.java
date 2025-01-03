import java.util.ArrayList;
import java.util.List;

public class AnagramGenerator {
    public static List<String> generateAnagrams(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input must not be null or empty.");
        }
        if (!input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Input must contain only letters.");
        }

        List<String> result = new ArrayList<>();
        permute(input.toCharArray(), 0, result);
        return result;
    }

    private static void permute(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permute(chars, index + 1, result);
            swap(chars, index, i); // backtrack
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
