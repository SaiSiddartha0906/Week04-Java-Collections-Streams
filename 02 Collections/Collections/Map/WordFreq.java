package Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordFreq {
    public static void main(String[] args){
        String filepath="C:\\Users\\Sriii\\IdeaProjects\\java basics\\src\\Collections\\Map\\Sample.txt";
        HashMap<String,Integer> wordCount=new HashMap<>();

        try(BufferedReader br=new BufferedReader(new FileReader(filepath))){
            String line;

            while((line=br.readLine())!=null){
                String[] words=line.split(" ");

                for(String word:words){
                    if(!word.isEmpty()){
                        wordCount.put(word,wordCount.getOrDefault(word,0)+1);
                    }
                }
            }
            System.out.println("Word Freq: "+ wordCount);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
