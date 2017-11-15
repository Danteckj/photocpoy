package main;


import javax.swing.*;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {
        ArrayList<String> dirs = new ArrayList<>();
        ArrayList<String> onlyOne = new ArrayList<>();
        onlyOne.add("fuck");
        onlyOne.add("you");
        final String[] s = {""};
        VisualGUI visualGUI = new VisualGUI("PhotoCopy");
        visualGUI.setVisible(true);
        visualGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        visualGUI.setSize(600, 800);


        visualGUI.fc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                File file = visualGUI.fc.getSelectedFile();
                if (!onlyOne.get(0).equals("fuck")) {
                    int i = Integer.parseInt(onlyOne.get(0));
                    dirs.set(i, file.getPath().toString());
                    onlyOne.set(0, "fuck");
                } else {
                    dirs.add(file.getPath().toString());
                }
                visualGUI.textArea.setText("");
                for (String s : dirs) {
                    visualGUI.textArea.append(s + "\n");
                }


            }
        });



        visualGUI.del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s2 = Integer.toString(dirs.indexOf(visualGUI.textArea.getSelectedText()));
                onlyOne.set(0, s2);

                visualGUI.textArea.setText("");
                for (String s : dirs) {
                    if (s.equals(dirs.get(Integer.parseInt(onlyOne.get(0))))) continue;
                    else visualGUI.textArea.append(s + "\n");
                }


            }
        });

        visualGUI.fFolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.showOpenDialog(null);
                File file = fileChooser.getSelectedFile();
                onlyOne.set(1, file.getPath().toString());
                visualGUI.finalF.setText(file.getPath().toString());
            }
        });


        visualGUI.convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (!onlyOne.get(0).equals("fuck")) {
                    int i3 = Integer.parseInt(onlyOne.get(0));
                    dirs.set(i3, " ");
                    onlyOne.set(0, "fuck");}
                for (int i = 0; i < dirs.size(); i++) {
                    Integer c = 0;
                    if (dirs.get(i).equals(" ")) continue;


                    File dir = new File(dirs.get(i));
                    String[] picturesNames = dir.list();
                    for (int i1 = 0; i1 < picturesNames.length; i1++) {
                        c++;
                        int iTemp = i + 1;
                        String end = " ";
                        if (picturesNames[i1].contains(".")) {
                            int dotePosition = picturesNames[i1].indexOf(".");
                            end = picturesNames[i1].substring(dotePosition, picturesNames[i1].length());

                        }

                        String n = c.toString();
                        String rename = iTemp + "0000" + c + end;
                        Path path = Paths.get(dirs.get(i) + "\\" + picturesNames[i1]), fPath = Paths.get(onlyOne.get(1) + "\\" + rename);
                        try {
                            Files.copy(path, fPath, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }});}
}







       /* ArrayList<String> folders = new ArrayList<String>();
        System.out.println("Добро пожаловать");
        System.out.println("Укажите необхадимые папки по оконачанию введите done");
        String done = "111";
        int count = 0;

        while (done != "done") {



            System.out.println("Введите адресс папки");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Done = " + done);
           String s = scanner.nextLine();
            System.out.println("S= " + s);
            if (s.equals("done")) {
                done = s;
                break;
            } else {
                folders.add(s);
                count++;
            }

        }

        System.out.println("Введите куда скопировать");
        String fFolder = new Scanner(System.in).nextLine();
        File makeDir = new File(fFolder);
        makeDir.mkdir();
        for (int i = 0; i < folders.size(); i++) {
            System.out.println("Папка " + folders.get(i));
        }

        for (int i = 0; i < folders.size(); i++) {
            Integer c = 0;

            System.out.println("В папке " + folders.get(i));
            File dir = new File(folders.get(i));
            String[] picturesNames = dir.list();
            for (int i1 = 0; i1 < picturesNames.length; i1++) {
                c++;
                int iTemp = i + 1;
                String end = " ";
                if (picturesNames[i1].contains(".")) {
                    int dotePosition = picturesNames[i1].indexOf(".");
                    end = picturesNames[i1].substring(dotePosition, picturesNames[i1].length());

                }

                String n = c.toString();
                String rename = iTemp + "0000" + c + end;
                Path path = Paths.get(folders.get(i) + "\\" + picturesNames[i1]), fPath = Paths.get(fFolder + "\\" + rename);
                try {
                    Files.copy(path, fPath, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("пока");
        }

    }


}*/
