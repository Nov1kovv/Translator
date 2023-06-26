package org.example.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Data {
    @JsonProperty("translations")  public List<Translation> translations;
}
