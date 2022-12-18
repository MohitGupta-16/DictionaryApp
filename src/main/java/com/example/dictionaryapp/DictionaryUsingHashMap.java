package com.example.dictionaryapp;

import java.util.HashMap;

public class DictionaryUsingHashMap {

    private HashMap<String, String> dictionary;

    public DictionaryUsingHashMap(){
        // initialise hashmap
        this.dictionary = new HashMap<>();
        addWordList();
    }

    public boolean addWord(String word, String meaning){
        try{
            dictionary.put(word.toLowerCase(), meaning);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public String getMeaning(String word){
        // if map contains word it will return its meaning
        if(dictionary.containsKey(word)){
            return dictionary.get(word);
        }
        // otherwise it will return this message
        else{
            return "Word does not exits in dictionary";
        }
    }

    private void addWordList(){
        addWord("Phase", "a stage in the development of something");
        addWord("project", "an individual or collaborative enterprise that is carefully planned to achieve a particular aim");
        addWord("Start", "beginning");
        addWord("Depreciating assets ", "Whose value decreases with time");
    }
}




//=CONCATENATE("addWord(",CHAR(34),A2,CHAR(34),", ",CHAR(34),B2,CHAR(34),");")
