package org.example;

import panel.BasicFrame;

import javax.swing.*;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {
        BasicFrame r = new BasicFrame("Test");
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(800,400);
    }
}