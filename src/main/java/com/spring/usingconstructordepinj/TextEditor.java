package com.spring.usingconstructordepinj;

public class TextEditor {

    private SpellChecker spellChecker;

    public TextEditor(SpellChecker spellChecker,String name) {
        System.out.println("Welcome "+name+" - Inside TextEditor constructor." );
        this.spellChecker = spellChecker;
    }
    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
