package org.example;

import javax.swing.*;

public class TranslatorStarter {

    final static int frameWidth = 550;

    public static void main(String[] args) {
        TranslatorFrame translatorFrame = new TranslatorFrame("Translator");
        translatorFrame.setVisible(true);
        translatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        translatorFrame.setSize(frameWidth,350);
    }
}