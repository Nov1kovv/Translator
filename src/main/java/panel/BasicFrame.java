package panel;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.data.Root;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BasicFrame extends JFrame {
    JButton buttonOne;
    JLabel labelOne, labelTwo;
    JTextField textFieldOne, textFieldTwo;
    URL url;
    String stringOne;
    String textOne;
    final int number20 = 20;
    final int number80 = 80;
    final int number100 = 100;
    final int number250 = 250;
    eHandler handler = new eHandler();

    public BasicFrame(String s){
        super(s);
        setLayout(new FlowLayout());

       createObject();
        setSize();
        addComponents();

    }
    public void createObject() {
        labelTwo = new JLabel("Russian");
        textFieldOne = new JTextField(25);
        textFieldTwo = new JTextField(25);
        labelOne = new JLabel("English");
        buttonOne = new JButton("Translate");

    }


    public void setSize() {
        textFieldOne.setPreferredSize(new Dimension(number80, number100));
        textFieldTwo.setPreferredSize(new Dimension(number80, number100));
        buttonOne.setPreferredSize(new Dimension(300, 50));
        labelOne.setPreferredSize(new Dimension(number250, number20));
        labelTwo.setPreferredSize(new Dimension(number250, number20));
    }

    public void addComponents(){
        add(labelOne);
        add(labelTwo);
        add(textFieldOne);
        add(textFieldTwo);
        add(buttonOne);
        buttonOne.addActionListener(handler);
    }

    public class eHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==buttonOne){
                 stringOne = textFieldOne.getText();
                 textOne = stringOne;
                 textFieldTwo.setText(textOne);
                try {
                    makeRequest();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        public void makeRequest() throws IOException {
            url = new URL("https://www.googleapis.com/language/translate/v2?key=AIzaSyBcnEcR3MoyfHpBMDJtI6yHduSmz9aQH7k&source=en&target=ru&q=my");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();

            ObjectMapper mapper = new ObjectMapper();
            Root root = mapper.readValue(responseStream, Root.class);
            System.out.println("translate");
            System.out.println(root.data.translations);
        }
    }
}