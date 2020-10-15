public class AnagramCheck {

    private final static String[] SPACE_PUNCTUATION_MARKS = new String[]{" ",".","!","?",",",";",":"};

    public static boolean isAnagram(String word, String anagram, boolean caseSensitive, boolean spacePunctuationMarkSensitive) {
        if (!spacePunctuationMarkSensitive) {
            for (int i=0; i<SPACE_PUNCTUATION_MARKS.length; i++) {
                word = word.replace(SPACE_PUNCTUATION_MARKS[i], "");
                anagram = anagram.replace(SPACE_PUNCTUATION_MARKS[i], "");
            }
        }
        if (word.length() != anagram.length()) {
            return false;
        }
        if (!caseSensitive){
            word = word.toLowerCase();
            anagram = anagram.toLowerCase();
        }
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int index = anagram.indexOf(c);
            if (index != -1) {
                anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
            } else {
                return false;
            }
        }
        return true;
    }
}

