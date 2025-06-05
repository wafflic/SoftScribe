import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
    GUI gui;
    String fileName;
    String fileAddress;
    FileWriter fw;
    public Function_File(GUI gui) {
    this.gui = gui;
    }
    public void newFile() {
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress = null;
                JTextArea newFileTextArea = new JTextArea();
                newFileTextArea.addKeyListener(gui.shortcuts);
                JScrollPane newFileScrollPane = new JScrollPane(newFileTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                newFileScrollPane.setBorder(BorderFactory.createEmptyBorder());
                newFileTextArea.setBorder(new EmptyBorder(3, 5, 0, 0));
                gui.fileTab.addTab("New.txt", newFileScrollPane);
    }
    public void openFile() {
        FileDialog open = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        open.setVisible(true);
        JTextArea newFileTextArea = new JTextArea();
        newFileTextArea.addKeyListener(gui.shortcuts);
        JScrollPane newFileScrollPane = new JScrollPane(newFileTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        newFileScrollPane.setBorder(BorderFactory.createEmptyBorder());
        newFileTextArea.setBorder(new EmptyBorder(3, 5, 0, 0));
        gui.fileTab.addTab(open.getFile(), newFileScrollPane);
        if (open.getFile() != null ) {
            fileName = open.getFile();
            fileAddress = open.getDirectory();
            gui.window.setTitle(fileName);
        }
        try {

            BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
            newFileTextArea.setText("");
            String line = null;
            while ((line = br.readLine()) != null) {
                newFileTextArea.append(line + "\n");
            }
            br.close();
        }
        catch (Exception e) {
            System.out.println("An error has occurred");
        }

    }
    public void saveAsFile() {
        FileDialog save = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
        save.setVisible(true);
        if (save.getFile() != null ) {
            fileName = save.getFile();
            fileAddress = save.getDirectory();
            gui.window.setTitle(fileName);
        }
        try {
            JScrollPane currentScrollPane = (JScrollPane) gui.fileTab.getSelectedComponent();
            JTextArea currentTextArea = (JTextArea) currentScrollPane.getViewport().getView();
            char[] textToCharArray = currentTextArea.getText().toCharArray();
            int i = textToCharArray.length;
            if (textToCharArray[i-1] =='t' && textToCharArray[i-2]=='x' && textToCharArray[i-3]== 't' && textToCharArray[i-4] == '.') {
                fw = new FileWriter(fileAddress + fileName);
            } else {fw = new FileWriter(fileAddress + fileName + ".txt");}

            fw.write(currentTextArea.getText());
            fw.close();
            int index = gui.fileTab.getSelectedIndex();
            gui.fileTab.setTitleAt(index, fileName);
            String line = null;
        }
        catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG");
          // gui.textArea.setText("something went wrong");
        }
    }
    public void saveFile() {
        if (fileName == null ) {
            saveAsFile();
        }
        else {
            try {
                FileWriter fw = new FileWriter(fileAddress + fileName);
                JScrollPane currentScrollPane = (JScrollPane) gui.fileTab.getSelectedComponent();
                JTextArea currentTextArea = (JTextArea) currentScrollPane.getViewport().getView();
                fw.write(currentTextArea.getText());
                fw.close();
            } catch (Exception e) {
                System.out.println("sth wrong happened");
            }
        }
        int index = gui.fileTab.getSelectedIndex();
        gui.fileTab.setTitleAt(index, fileName);
    }
    public void exitFile() {
        System.exit(0);
    }
}
