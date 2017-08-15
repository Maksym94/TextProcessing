package comparators;

import java.util.Comparator;

public class AscendingVowelSymbolsWordComparator implements Comparator<String>{

    private static final char[] VOWEL_SYMBOLS ={'a','e','i','o','u','y', 'A', 'E', 'I', 'O', 'U','Y'};

    @Override
    public int compare(String o1, String o2) {

        double proportionVowelToAnotherSymbolsWord1=0;
        double proportionVowelToAnotherSymbolsWord2=0;
        char[] word1 = o1.toCharArray();
        char[] word2= o2.toCharArray();
        int countVowelSymbolsWord1=0;
        int countVowelSymbolsWord2=0;


        for (int i = 0; i < word1.length; i++) {
            for (int j = 0; j < VOWEL_SYMBOLS.length ; j++) {
                if(word1[i]== VOWEL_SYMBOLS[j]){
                    countVowelSymbolsWord1++;
                    break;
                }
            }
        }

        for (int i = 0; i < word2.length; i++) {
            for (int j = 0; j < VOWEL_SYMBOLS.length ; j++) {
                if(word2[i]== VOWEL_SYMBOLS[j]){
                    countVowelSymbolsWord2++;
                    break;
                }
            }
        }
        proportionVowelToAnotherSymbolsWord1 =(double) countVowelSymbolsWord1/(double) word1.length;
        proportionVowelToAnotherSymbolsWord2 =(double) countVowelSymbolsWord2/(double) word2.length;


        if(proportionVowelToAnotherSymbolsWord1<proportionVowelToAnotherSymbolsWord2){
            return -1;
        }
        else if (proportionVowelToAnotherSymbolsWord1==proportionVowelToAnotherSymbolsWord2){
            return 0;
        }
        else {
            return 1;
        }
    }


}
