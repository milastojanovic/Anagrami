import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        input = input.trim()
                .replaceAll("\\s+", " ")
                .toLowerCase();
        input = input.substring(0, input.length() - 1);
        String[] words = input.split(" ");

        Map<Map<Character, Integer>, Integer> lettersInWords = new HashMap<>();
        for (String word : words) {
            Map<Character, Integer> lettersInWord = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!lettersInWord.containsKey(ch)) {
                    lettersInWord.put(ch, 1);
                } else {
                    lettersInWord.put(ch, lettersInWord.get(ch) + 1);
                }
            }
            if (!lettersInWords.containsKey(lettersInWord)) {
                lettersInWords.put(lettersInWord, 1);
            } else {
                lettersInWords.put(lettersInWord, lettersInWords.get(lettersInWord) + 1);
//                lettersInWords.put(lettersInWord, 2);
            }
        }

        long occurrence = lettersInWords.values().stream().filter(i -> i > 1).count();

//        if (lettersInWords.containsValue(2)) {
        if (occurrence > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
