package start;

import comparators.SpecifiedLetterWordComparator;
import text_objects.Sentence;
import text_objects.Symbol;
import text_objects.Word;

import java.io.*;
import java.util.Arrays;

public class TextProcess {


    public static void main(String[] args) {

        TextProcess textProcess = new TextProcess();
        Word word = new Word();
        Sentence sentence = new Sentence();
        Symbol symbol = new Symbol();
        String text= textProcess.readTextFromFile("/text.txt");
        String formattedText= textProcess.formatTextFromExcessSpaces(text);

        String textWithQuestions= textProcess.readTextFromFile("/textWithQuestions.txt");
        String formattedTextWithQuestions= textProcess.formatTextFromExcessSpaces(textWithQuestions);

        Sentence.findInterrogativeQuestions(formattedTextWithQuestions);

        String[] sentences = Sentence.getTextSentences(formattedText);
        System.out.println(Arrays.toString(sentences));
        textProcess.printTaskSeparation(1);// Task 1
        System.out.println("Sentences with repeated words "
                +sentence.getMaxAmountSentencesWithRepeatableWords(formattedText));

        textProcess.printTaskSeparation(2);// Task 2
        System.out.println("\nSentences in ascending order of words in each");
        System.out.println(sentence.getSentencesInAscOrderWords(formattedText));

        textProcess.printTaskSeparation(3);// Task 3
        System.out.println("\nUnique word in first sentence: "
                + word.wordThatNotExistsInAnotherSentences(formattedText));

        textProcess.printTaskSeparation(4);// Task 4
        System.out.println("\nUnique words in interrogative sentences: "
                + word.findUniqueWordsSpecifiedLengthInInterrogativeSentence(formattedTextWithQuestions));

        textProcess.printTaskSeparation(5);// Task 5
        System.out.println("\nChange first word with the last in the sentence: \n");
        System.out.println(sentence.changeFirstWordWithLastInSentence(formattedText));

        textProcess.printTaskSeparation(6);// Task 6
        System.out.println("\nPrint words in ALPHABET order on first letter in the word: \n");
        System.out.println(symbol.printWordsInAlphabetOrder(formattedText));


        textProcess.printTaskSeparation(7);// Task 7
        System.out.println("\nSort words of the text by increasing proportion of vowels: \n");
        System.out.println(symbol.sortWordsAcsVowelLetters(formattedText));

        textProcess.printTaskSeparation(8);// Task 8
        System.out.println("\nSort words starting from vowels in ALPHABET order of first consonant letter \n");
        System.out.println(symbol.sortStartFromVowelWordsInAlphabetOrder(formattedText));

        textProcess.printTaskSeparation(9);// Task 9
        System.out.println("\nSort words starting from vowels in ALPHABET order of first consonant letter \n");
        System.out.println(symbol.sortTextWordsByNumberOfGivenLetters(formattedText, 'm',
                SpecifiedLetterWordComparator.ASC_SORT));

        textProcess.printTaskSeparation(10);// Task 10
        System.out.println("\nFind how much words from list repeat in text, sort words by descending total" +
                "numbers of entries\n");
        System.out.println(word.findAmountOfEachWordAppearsInSentence(formattedText,"and","like"
                , "then", "the"));

        textProcess.printTaskSeparation(11);// Task 11
        System.out.println("\nExclude substring of maximum length starting and ending specified symbols\n");
        System.out.println(sentence.excludeSubstringByBeginningAndEndingChars(formattedText,"find", "d"));

        textProcess.printTaskSeparation(12);// Task 12
        System.out.println("\nDelete all words specified length starting on consonant letter\n");
        System.out.println(word.deleteConsonantWordsSpecifiedLength(formattedText,6));

        textProcess.printTaskSeparation(13);// Task 13
        System.out.println("\nSort words in a text descending amount of specified symbol, if equals in alphabet" +
                "order\n");
        System.out.println(symbol.sortTextWordsByNumberOfGivenLetters(formattedText, 'm',
                SpecifiedLetterWordComparator.DESC_SORT));

        textProcess.printTaskSeparation(14);// Task 14
        System.out.println("\nFind palindrome with maximum length\n");
        System.out.println(sentence.findMaxPalindromeFromText(formattedText));

        textProcess.printTaskSeparation(15);// Task 15
        System.out.println("\nConvert words delete all subsequent occurrences of first letter in the word\n");
        System.out.println(word.deleteAllOccurrencesOfFirstLetterInWord(formattedText));

        textProcess.printTaskSeparation(16);// Task 16
        System.out.println("\nReplace words specified length with substring\n");
        System.out.println(word.replaceWordsSpecifiedLengthWithSubstring(formattedText, "<HTTP tag>",6));
    }

    private void printTaskSeparation(int numberTask){
        System.out.println("\n------------------------------TASK "+ numberTask+" ----------------------------");
    }


    public String readTextFromFile(String pathToFile)  {
       BufferedReader bf= new BufferedReader(
               new InputStreamReader(this.getClass().getResourceAsStream(pathToFile)));
        StringBuilder sb = new StringBuilder();
        String text;
        try {
            while ((text = bf.readLine()) != null) {
                sb.append(text).append("\n");
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public String formatTextFromExcessSpaces(String unformattedText){
        String[] lines = unformattedText.split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split("\\s");
            for (int j = 0; j < words.length; j++) {
                if (words[j].equals("")) {
                    continue;
                }
                if (j == words.length - 1) {
                    sb.append(words[j]).append("\n");
                    break;
                }
                sb.append(words[j]).append(" ");
            }
        }
        return sb.toString();
    }
}
