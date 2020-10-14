public class AnagramCheck {
    private final static String[] PUNCTUATION_MARKS = new String[]{".","!","?",",",";",":"};
    public static boolean isAnagram(String word, String anagram, boolean caseSensitive, boolean punctuationMarkSensitve) {
        if (!punctuationMarkSensitve) {
            for (int i=0; i<PUNCTUATION_MARKS.length; i++) {
                word = word.replace(PUNCTUATION_MARKS[i], "");
                anagram = anagram.replace(PUNCTUATION_MARKS[i], "");
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
        return anagram.isEmpty();
    }
}

