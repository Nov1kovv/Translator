package org.example.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Translation {
    @JsonProperty("translatedText") String translatedText;

    @Override
    public String toString() {
        return translatedText;
    }
}
