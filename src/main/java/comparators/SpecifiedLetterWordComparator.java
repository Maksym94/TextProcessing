package comparators;

import java.util.Comparator;

public class SpecifiedLetterWordComparator implements Comparator<String>{
    public static final int ASC_SORT=0;
    public static final int DESC_SORT=1;
    private int sortOrder;
    private final char letterToFind;

    public SpecifiedLetterWordComparator(char letterToFind, int sortOrder) {
        this.sortOrder=sortOrder;
        this.letterToFind = letterToFind;
    }

    @Override
    public int compare(String o1, String o2) {

        char [] word1= o1.toCharArray();
        char [] word2= o2.toCharArray();
        int countLettersWord1 = 0;
        int countLettersWord2 = 0;
        for (int i = 0; i < word1.length; i++) {
            if(word1[i]==letterToFind){
                countLettersWord1++;
            }
        }
        for (int i = 0; i <word2.length ; i++) {
            if(word2[i]==letterToFind){
                countLettersWord2++;
            }
        }
        if(sortOrder==1){
            if (countLettersWord1 > countLettersWord2) {
                return -1;
            }
            if (countLettersWord1 == countLettersWord2) {
                return o1.compareTo(o2);
            }
            return 1;
        }
        else {
            if (countLettersWord1 > countLettersWord2) {
                return 1;
            }
            if (countLettersWord1 == countLettersWord2) {
                return o1.compareTo(o2);
            }
            return -1;
        }
    }
}
