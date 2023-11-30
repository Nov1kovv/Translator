package org.example;

import javax.swing.*;
import java.awt.*;

public class TranslatorStarter {

    final static int frameWidth = 550;

    public static void main(String[] args) {
        TranslatorFrame translatorFrame = new TranslatorFrame("Translator");
        Dimension fixedSize = new Dimension(550,350);
        translatorFrame.setSize(fixedSize);
        translatorFrame.setMinimumSize(fixedSize);
        translatorFrame.setMaximumSize(fixedSize);
        translatorFrame.setResizable(false); //статичный размер окна
        translatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        translatorFrame.setVisible(true);
    }
}