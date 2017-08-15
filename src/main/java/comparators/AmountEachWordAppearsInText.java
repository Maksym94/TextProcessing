package comparators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AmountEachWordAppearsInText implements Comparator<String>{
    private final List<String> allWordsInText;

    public AmountEachWordAppearsInText(String text) {
        allWordsInText=getWordsFromText(text);
    }

    //This method  you can see redundant, because this logic is implemented in another classes inside this app,
    //but the main idea is to separate comparator from other parts to works isolated
    private List<String> getWordsFromText(String text){
        String[] sentencesWithOneNonSentence= text.split("\\.");
        String[] sentences= new String[sentencesWithOneNonSentence.length-1];
        System.arraycopy(sentencesWithOneNonSentence,0, sentences, 0, sentences.length);
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


    private  String[] getWords(String sentence) {

        return sentence.split(" ");
    }

    @Override
    public int compare(String o1, String o2) {
        int countRepeatWord1=0;
        int countRepeatWord2=0;
        for (int i = 0; i < allWordsInText.size(); i++) {
            if(allWordsInText.get(i).equals(o1)){
                countRepeatWord1++;
            }
            if(allWordsInText.get(i).equals(o2)){
                countRepeatWord2++;
            }
        }
        if(countRepeatWord1==countRepeatWord2){
            return 0;
        }
        if(countRepeatWord1<countRepeatWord2){
            return 1;
        }
        return -1;
    }
}
