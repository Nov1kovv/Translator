package org.example;

public enum Language {

     ENGLISH("en", "English"),
     GERMAN("de", "German");
    private String shortName;
    private String longName;

    Language(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }
}
