package com.sylim.practice.examUp4;

public class Word {
    public static void main(String args[]) {
        Word word = new Word("acd");
        System.out.println(word.isConsonant(0));
    }

    private String letters;
    final String VOWELS = "aeiouAEIOU";

    public Word(String letters) {
        this.letters = letters;
    }

    public boolean isVowel(int i) {
        return VOWELS.contains(letters.substring(i, i + 1));
    }
    
    public boolean isConsonant(int i) {
        return !(isVowel(i));
    }
}
