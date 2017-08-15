package text_objects;

import comparators.SpecifiedLetterWordComparator;
import comparators.AcsendingVowelSymbolsWordComparator;
import comparators.StartVowelFirstConsonaltWordComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Symbol {

    public static final char[] ALPHABET = {'a','b','c','d','e','f','g','h','i','j','k','l',
            'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static final char[] CONSONANTS = {'b','c','d','f','g','h','j','k','l',
            'm','n','p','q','r','s','t','v','w','x','z'};
    private static final char[] VOWELS ={'a','e','i','o','u','y', 'A', 'E', 'I', 'O', 'U','Y'};


    public String printWordsInAlphabetOrder(String text) {
        StringBuilder sb = new StringBuilder();

        List<String> allWords = Word.getAllWordsFromText(text);
        for (int i = 0; i < ALPHABET.length; i++) {
            char symbol = ALPHABET[i];
            boolean makeRedLine=false;
            for (int j = 0; j < allWords.size(); j++) {
                if (allWords.get(j).charAt(0)==symbol){
                    sb.append(allWords.get(j)).append(" ");
                    makeRedLine=true;
                }
            }
            if(makeRedLine){
                sb.append("\n").append(" ");
            }
        }
        return sb.toString();
    }

    public String sortWordsAcsVowelLetters(String text){

        StringBuilder sb = new StringBuilder();

        List<String> allWords = Word.getAllWordsFromText(text);

         String[] sortedWords = allWords.toArray(new String[allWords.size()]);
        Arrays.sort(sortedWords, new AcsendingVowelSymbolsWordComparator());
        for (int i = 0; i < sortedWords.length; i++) {
            sb.append(sortedWords[i]).append(" ");
            //This made for readable, not to put all words in one line
            if(i!=0 && i%12==0){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String sortStartFromVowelWordsInAlphabetOrder(String text){
        StringBuilder sb = new StringBuilder();

        List<String> allWords = Word.getAllWordsFromText(text);

        Pattern pattern = Pattern.compile("^[aeiouyAEIOUY]\\w*");
        List<String> wordsStartingFromVowel = new ArrayList<>();
        for (int i = 0; i < allWords.size(); i++) {
            Matcher matcher = pattern.matcher(allWords.get(i));
            if(matcher.find()){
                wordsStartingFromVowel.add(matcher.group());
            }
        }
        String [] sortedWords= wordsStartingFromVowel.toArray(new String[wordsStartingFromVowel.size()]);
        Arrays.sort(sortedWords, new StartVowelFirstConsonaltWordComparator());
        for (int i = 0; i < sortedWords.length; i++) {
            sb.append(sortedWords[i]).append(" ");
            if(i!=0&&i%12==0){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String sortTextWordsByNumberOfGivenLetters(String text, char letterToFind, int sortOrder){
        StringBuilder sb = new StringBuilder();

        List<String> allWords = Word.getAllWordsFromText(text);

        String[] sortedWords= allWords.toArray(new String[allWords.size()]);
        Arrays.sort(sortedWords,new SpecifiedLetterWordComparator(letterToFind,sortOrder));
        for (int i = 0; i < sortedWords.length; i++) {
            sb.append(sortedWords[i]).append(" ");
            if(i!=0 && i%12==0){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}
