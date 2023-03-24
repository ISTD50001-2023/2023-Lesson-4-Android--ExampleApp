package com.example.firebaserecyclerviewtesting;

public interface WordsDataSource {

    void addWord(String s);
    String getWord(int i);
    void removeWord(int i);
    int getSize();

}
