package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Root;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class TranslatorFrame extends JFrame {
    JButton buttonTranslate, buttonSave, buttonDelete;
    JLabel labelEnglishLanguage, labelRussianLanguage;
    JTextField textFieldEnglish, textFieldRussian;
    URL url;
    String stringEnglish;
    String textRussian;
    final int labelHeight = 20;
    final int labelWidth = 250;

    public TranslatorFrame(String s) {
        super(s);
        setLayout(new FlowLayout());

        initScrean();
        setSize();
        addComponents();

    }

    public void initScrean() {
        labelRussianLanguage = new JLabel("Russian");
        textFieldEnglish = new JTextField(25);
        textFieldRussian = new JTextField(25);
        labelEnglishLanguage = new JLabel("English");
        buttonTranslate = new JButton("Translate");
        buttonSave = new JButton("Save");
        buttonDelete = new JButton("Delete text");

    }

    public void setSize() {
        textFieldEnglish.setPreferredSize(new Dimension(200, 200));
        textFieldRussian.setPreferredSize(new Dimension(200, 200));
        buttonTranslate.setPreferredSize(new Dimension(150, 50));
        buttonSave.setPreferredSize(new Dimension(150, 50));
        buttonDelete.setPreferredSize(new Dimension(150, 50));
        labelEnglishLanguage.setPreferredSize(new Dimension(labelWidth, labelHeight));
        labelRussianLanguage.setPreferredSize(new Dimension(labelWidth, labelHeight));
    }

    public void addComponents() {
        add(labelEnglishLanguage);
        add(labelRussianLanguage);
        add(textFieldEnglish);
        add(textFieldRussian);
        add(buttonTranslate);
        add(buttonSave);
        add (buttonDelete);

        //Анонимный класс
        buttonTranslate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == buttonTranslate) {
                    stringEnglish = textFieldEnglish.getText();
                    textRussian = stringEnglish;
                    textFieldRussian.setText(textRussian);
                    try {
                        makeRequest();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        //lambda
        buttonSave.addActionListener(actionEvent -> {
            stringEnglish = textFieldEnglish.getText();
            textRussian = textFieldRussian.getText();
            String resultText = stringEnglish + " " + textRussian + "\n";
            String filePath = "C:\\Users\\Oleg\\Desktop\\text.txt";
            try{
                FileWriter writer = new FileWriter(filePath, true);
                writer.write(resultText);

                writer.flush();
                writer.close();


            } catch (IOException e) {
                System.out.println("Saving file error ");
                e.printStackTrace();

            }
        });
    buttonDelete.addActionListener(actionEvent -> {
        textFieldRussian.setText("");
        textFieldEnglish.setText("");
            }
            );
    }


    public void makeRequest() throws IOException {

        String text = textFieldEnglish.getText();
        url = new URL("https://www.googleapis.com/language/translate/v2?key=AIzaSyBcnEcR3MoyfHpBMDJtI6yHduSmz9aQH7k&source=en&target=ru&q=" + text.replaceAll("\\s+", "+"));

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        InputStream responseStream = connection.getInputStream();

        ObjectMapper mapper = new ObjectMapper();
        Root root = mapper.readValue(responseStream, Root.class);

        String translate = root.data.translations.toString();
        textFieldRussian.setText(translate);
    }
}
