package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Translation {
    @JsonProperty("translatedText") String translatedText;

    @Override
    public String toString() {
        return translatedText;
    }
}
