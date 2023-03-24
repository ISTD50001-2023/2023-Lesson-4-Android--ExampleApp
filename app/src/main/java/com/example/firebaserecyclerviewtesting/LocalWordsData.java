package com.example.firebaserecyclerviewtesting;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LocalWordsData implements WordsDataSource {

    private List<String> wordList;
    private TextView t;

    LocalWordsData(TextView t){
        // TODO 5 Initialize the instance variables and populate wordList with your own words
    }

    public void addWord(String s){
        // TODO 6 this method is to add string s to the wordlist
        displayCountOnTextView();
    }

    private void displayCountOnTextView(){
        t.setText( String.valueOf(wordList.size()) );
    }

    public String getWord(int i){
        // TODO 7 this method returns the word at position i
        return wordList.get(i);
    }

   public void removeWord(int i){
        // TODO 8 this method removes the word at position i
        wordList.remove(i);
    }

    public int getSize(){
        // TODO 9 this method returns the number of words
        return 0;
    }
}
