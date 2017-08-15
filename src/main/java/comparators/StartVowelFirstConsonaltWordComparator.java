package comparators;

import java.util.Comparator;

public class StartVowelFirstConsonaltWordComparator implements Comparator<String> {
    public static final char[] CONSONANTS = {'b','c','d','f','g','h','j','k','l',
            'm','n','p','q','r','s','t','v','w','x','z'};
    @Override
    public int compare(String o1, String o2) {
        if(o1.length()==1&&o2.length()==1){
            return 0;
        }
        if(o1.length()==1){
            return 1;
        }
        if(o2.length()==1){
            return -1;
        }
        char[] word1 = o1.toCharArray();
        char[] word2 = o2.toCharArray();
        boolean secondLetterConsonantWord1=false;
        boolean secondLetterConsonantWord2=false;
        

            for (int i = 0; i <CONSONANTS.length; i++) {
                if(word1[1]==CONSONANTS[i]){
                    secondLetterConsonantWord1=true;
                    break;
                }
            }

            for (int i = 0; i <CONSONANTS.length; i++) {
                if(word2[1]==CONSONANTS[i]){
                    secondLetterConsonantWord2=true;
                    break;
                }
            }
        if(!secondLetterConsonantWord1&& !secondLetterConsonantWord2){
            return 0;
        }
            if(!secondLetterConsonantWord1){
                return 1;
            }

            if(!secondLetterConsonantWord2){
                return -1;
            }
            int indexConsonantWord1=0;
            int indexConsonantWord2=0;

        for (int i = 0; i < CONSONANTS.length; i++) {
            if(word1[1]==CONSONANTS[i]){
                indexConsonantWord1=i;
            }
            if(word2[1]==CONSONANTS[i]){
                indexConsonantWord2=i;
            }
        }
        if(indexConsonantWord1==indexConsonantWord2){
            return 0;
        }
        if(indexConsonantWord1>indexConsonantWord2){
            return 1;
        }

        return -1;
    }
}
