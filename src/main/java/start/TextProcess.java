package start;

import text_objects.Sentence;
import text_objects.Symbol;
import text_objects.Word;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TextProcess {


    public static void main(String[] args) {

        TextProcess textProcess = new TextProcess();
        Word word = new Word();
        Sentence sentence = new Sentence();
        Symbol symbol = new Symbol();
        String text= textProcess.readTextFromFile("D:\\TextProcessing\\text.txt");
        String formattedText= textProcess.formatTextFromExcessSpaces(text);

        String textWithQuestions= textProcess.readTextFromFile("D:\\TextProcessing\\textWithQuestions.txt");
        String formattedTextWithQuestions= textProcess.formatTextFromExcessSpaces(textWithQuestions);

        Sentence.findInterrogativeQuestions(formattedTextWithQuestions);

        /*String[] sentences = Sentence.getTextSentences(formattedText);
        System.out.println(Arrays.toString(sentences));*/
       /* textProcess.printTaskSeparation(1);// Task 1
        System.out.println("Sentences with repeated words "
                +sentence.getMaxAmountSentencesWithRepeatableWords(formattedText));

        textProcess.printTaskSeparation(2);// Task 2
        System.out.println("\nSentences in ascending order of words in each");
        System.out.println(sentence.getSentencesInAscOrderWords(formattedText));

        textProcess.printTaskSeparation(3);// Task 3
        System.out.println("\nUnique word in first sentence: "
                + word.wordThatNotExistsInAnotherSentences(formattedText));*/

        /*textProcess.printTaskSeparation(4);// Task 4
        System.out.println("\nUnique words in interrogative sentences: "
                + word.findUniqueWordsSpecifiedLengthInInterrogativeSentence(formattedTextWithQuestions));*/

        /*textProcess.printTaskSeparation(5);// Task 5
        System.out.println("\nChange first word with the last in the sentence: \n");
        System.out.println(sentence.changeFirstWordWithLastInSentence(formattedText));*/

        /*textProcess.printTaskSeparation(6);// Task 6
        System.out.println("\nPrint words in alphabet order on first letter in the word: \n");
        System.out.println(symbol.printWordsInAlphabetOrder(formattedText));*/


        /*textProcess.printTaskSeparation(7);// Task 7
        System.out.println("\nSort words of the text by increasing proportion of vowels: \n");
        System.out.println(symbol.sortWordsAcsVowelLetters(formattedText));

        textProcess.printTaskSeparation(8);// Task 8
        System.out.println("\nSort words starting from vowels in alphabet order of first consonant letter \n");
        System.out.println(symbol.sortStartFromVowelWordsInAlphabetOrder(formattedText));*/

        /*textProcess.printTaskSeparation(9);// Task 9
        System.out.println("\nSort words starting from vowels in alphabet order of first consonant letter \n");
        System.out.println(symbol.sortTextWordsByNumberOfGivenLetters(formattedText, 'm'));*/

        /*textProcess.printTaskSeparation(10);// Task 10
        System.out.println("\nFind how much words from list repeat in text, sort words by descending total" +
                "numbers of entries\n");
        System.out.println(word.findAmountOfEachWordAppearsInSentence(formattedText,"and","like"
                , "then", "the"));*/

        textProcess.printTaskSeparation(11);// Task 11
        System.out.println("\nExclude substring of maximum length starting and ending specified symbols\n");
        System.out.println(sentence.excludeSubstringByBeginningAndEndingChars(formattedText,"find", "d"));
    }

    private void printTaskSeparation(int numberTask){
        System.out.println("\n------------------------------TASK "+ numberTask+" ----------------------------");
    }


    public String readTextFromFile(String pathToFile)  {
        File file = new File(pathToFile);
        FileReader fr = null;
        try {
            fr = new FileReader(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader bf = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String text;
        try {
            while ((text = bf.readLine()) != null) {
                sb.append(text).append("\n");
            }
            fr.close();
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
