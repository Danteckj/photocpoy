package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class VisualGUI extends JFrame {
    JButton button, del, convert, fFolder;
    JLabel jLabel, finalF;
    JTextField t1;
    JFileChooser fc;
    JTextArea textArea;

    String string;


    public VisualGUI(String s){
        super(s);
        setLayout(new FlowLayout());
        button = new JButton("Кнопка");
        del= new JButton("Удалить");
        convert= new JButton("Копировать");
        fFolder= new JButton("Папка назначения");
        finalF= new JLabel("папка назначения");
        jLabel = new JLabel("Укажите папки");

        textArea= new JTextArea();

        fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        t1 = new JTextField(10);
        add(button);
        add(del);
        add(fFolder);
        add(convert);
        add(jLabel);
        add(finalF);

        add(fc);
        add(textArea);
    }
}
