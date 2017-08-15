package text_objects;

import comparators.AmountEachWordAppearsInText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word {

    public static String[] getWords(String sentence) {

        return sentence.split(" ");
    }

    public static List<String> getAllWordsFromText(String text){
        String[] sentences = Sentence.getTextSentences(text);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <sentences.length ; i++) {
            sb.append(sentences[i]);
        }
        String [] sentencesInOneLine= sb.toString().split("\n");
        List<String> allWords = new ArrayList<>();
        for (int i = 0; i < sentencesInOneLine.length; i++) {
            String [] words = getWords(sentencesInOneLine[i]);
            for (int j = 0; j <words.length ; j++) {
                allWords.add(words[j]);
            }
        }
        return allWords;
    }

    public String wordThatNotExistsInAnotherSentences(String text) {
        String[] sentences = Sentence.getTextSentences(text);
        StringBuilder sb = new StringBuilder();
        String[][] allWords = new String[sentences.length][];
        for (int i = 0; i < sentences.length; i++) {
            String[] words = getWords(sentences[i]);
            allWords[i] = words;
        }

        changeWord:
        for (int j = 0; j < allWords[0].length; j++) {
            String word = allWords[0][j];
            for (int i = 1; i < allWords.length; i++) {
                for (int k = 0; k < allWords[i].length; k++) {
                    if (allWords[i][k].equalsIgnoreCase(word)) {
                        continue changeWord;
                    }
                }
            }
            return word;
        }

        return "All words in first sentence is repeat in other sentences";
    }

    public String findUniqueWordsSpecifiedLengthInInterrogativeSentence(String text){
        String [] interrogatives= Sentence.findInterrogativeQuestions(text);
        int lengthWord=5;
        StringBuilder sb = new StringBuilder();
        String[][] allWords = new String[interrogatives.length][];
        for (int i = 0; i < interrogatives.length; i++) {
            String[] words = interrogatives[i].split(" ");
           allWords[i]= words;

        }
        for (int i = 0; i < allWords.length; i++) {
          nextWord:  for (int j = 0; j <allWords[i].length; j++) {
                String word= allWords[i][j];
                if(word.length()!=lengthWord){
                    continue;
                }
                for (int k = 0; k < allWords.length; k++) {
                    for (int l = 0; l < allWords[k].length; l++) {
                        if(i==k&&j==l||allWords[k][l].length()!=lengthWord){
                            continue;
                        }
                        if(word.equalsIgnoreCase(allWords[k][l])){
                            continue nextWord;
                        }
                    }
                }
                sb.append(word).append(" ");

            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String findAmountOfEachWordAppearsInSentence(String text, String ... words){
        String[] sentences = Sentence.getTextSentences(text);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <words.length ; i++) {
            String word = words[i];
            System.out.println("Word: "+ word);

            for (int j = 0; j < sentences.length; j++) {
                int count=0;
                String[] wordsInSentence = Word.getWords(sentences[j]);
                for (int k = 0; k <wordsInSentence.length ; k++) {
                    if(wordsInSentence[k].equals(word)){
                        count++;
                    }
                }
                System.out.println("Sentence "+ (j+1)+ " times: "+ count);
            }
            System.out.println();
        }
        String[] sortedWords= words.clone();
       Arrays.sort(sortedWords,new AmountEachWordAppearsInText(text));
       sb.append("Words sorted:\n");
        for (int i = 0; i <sortedWords.length ; i++) {
            sb.append(sortedWords[i]).append(" ");
        }
        return sb.toString();
    }

    public String deleteConsonantWordsSpecifiedLength(String text, int length) {
        String[] sentences = Sentence.getTextSentences(text);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            String[] words = Word.getWords(sentences[i]);
           newWord: for (int j = 0; j < words.length; j++) {
                for (int k = 0; k < Symbol.CONSONANTS.length; k++) {
                    if (words[j].charAt(0) == Symbol.CONSONANTS[k]&& words[j].length()==length) {
                        continue newWord;
                    }
                }
               sb.append(words[j]);
                if(j!=words.length-1) {
                    sb.append(" ");
                }
            }
            sb.append(".");
        }
        return sb.toString();
    }

    public String deleteAllOccurrencesOfFirstLetterInWord(String text) {
        String[] sentences = Sentence.getTextSentences(text);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            String[] words = Word.getWords(sentences[i]);
            for (int j = 0; j <words.length; j++) {
                char[] wordChars= words[j].toCharArray();
                char firstLetter=wordChars[0];
                for (int k = 0; k <wordChars.length ; k++) {
                    if(wordChars[k]!=firstLetter||wordChars[k]=='\n'||wordChars[k]=='\r'){
                        sb.append(wordChars[k]);
                    }
                }
                if(j!=words.length-1){
                    sb.append(" ");
                }
            }
            sb.append(".");
        }
        return sb.toString();
    }

    public String replaceWordsSpecifiedLengthWithSubstring(String text, String substring,int lengthOfWord) {
        String[] sentences = Sentence.getTextSentences(text);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            String[] words = Word.getWords(sentences[i]);
            for (int j = 0; j < words.length; j++) {
                if(words[j].length()==lengthOfWord){
                    words[j]= substring;
                }
                sb.append(words[j]);
                if(i!=sentences.length-1){
                    sb.append(" ");
                }
            }
            sb.append(".");
        }
        return sb.toString();
    }
}
