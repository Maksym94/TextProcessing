package text_objects;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {

    public static String[] getTextSentences(String text){
        String[] sentencesWithOneNonSentence= text.split("\\.");
       if(sentencesWithOneNonSentence[sentencesWithOneNonSentence.length-1].trim().equals("")){
           String[] sentences= new String[sentencesWithOneNonSentence.length-1];
           System.arraycopy(sentencesWithOneNonSentence,0, sentences, 0, sentences.length);
           return sentences;
       }
        return sentencesWithOneNonSentence;
    }

    public static String[] findInterrogativeQuestions(String text){
        StringBuilder sb = new StringBuilder();
        //Pattern pattern = Pattern.compile("\\w*\\?+|\\.*.*\\w*");
        Pattern pattern = Pattern.compile("[^\\s|.]([^.!?]*)\\?+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String question= matcher.group();
            sb.append(question.substring(0,question.length()-1)).append("\n");
        }
        String[] interrogativeSentences = sb.toString().split("\n");

        return interrogativeSentences;
    }


    public int getMaxAmountSentencesWithRepeatableWords(String text) {
        String[] sentences = getTextSentences(text);
        int count = 0;
        sentence:
        for (int i = 0; i < sentences.length; i++) {
            String[] words = Word.getWords(sentences[i]);

            for (int j = 0; j < words.length; j++) {
                for (int k = j + 1; k < words.length; k++) {
                    if (words[j].equals(words[k])) {
                        count++;
                        continue sentence;
                    }
                }
            }
        }
        return count;
    }

    public String getSentencesInAscOrderWords(String text){
        String[] sentences= getTextSentences(text);
        String[][] allWords= new String[sentences.length][];
        for (int i = 0; i < sentences.length; i++) {
            String[] words = Word.getWords(sentences[i]);
            allWords[i]= words;

        }
        for (int i = 0; i < allWords.length; i++) {
            for (int j = i+1; j <allWords.length ; j++) {
                if(allWords[i].length>allWords[j].length){
                    String[] temp = allWords[i];
                    allWords[i] = allWords[j];
                    allWords[j]=temp;

                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < allWords.length; i++) {
            for (int j = 0; j < allWords[i].length; j++) {
                sb.append(allWords[i][j]);
                if(j!=allWords[i].length-1){
                    sb.append(" ");
                }

            }
            sb.append(".");
        }
        return sb.toString();
    }

    public String changeFirstWordWithLastInSentence(String text) {
        String[] lines = getTextSentences(text);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split(" ");
            if (words.length > 1) {
                String temp = words[words.length - 1];
                words[words.length - 1] = words[0];
                words[0] = temp;
            }
            for (int j = 0; j < words.length; j++) {
                sb.append(words[j]);
                if (j != words.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append(".");
        }
        return sb.toString();
    }

    public String excludeSubstringByBeginningAndEndingChars(String text, String start, String end){
        String[] sentences = getTextSentences(text);
        Pattern pattern = Pattern.compile(start+"+.*"+end+"+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <sentences.length ; i++) {
            Matcher matcher = pattern.matcher(sentences[i]);
            if(matcher.find()){
                /*System.out.println(matcher.group());
                System.out.println("start "+matcher.start()+" end "+ matcher.end());*/
               sb.append(sentences[i].substring(0,matcher.start())) ;
               sb.append(sentences[i].substring(matcher.end())) ;
            }
            else {
                sb.append(sentences[i]);
            }
            sb.append(".");
        }
        return sb.toString();
    }

}
