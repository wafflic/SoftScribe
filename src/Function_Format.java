import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class Function_Format implements ActionListener {
    GUI gui;
    boolean wordWrapped = false;
    public Function_Format(GUI gui) {
        this.gui = gui;
    }
    public void fontAptos () {
        gui.textArea.setFont(new Font("Aptos", Font.PLAIN, gui.textArea.getFont().getSize()));
        System.out.println("Font is now "+ gui.textArea.getFont().getFamily());
    }
    public void fontArial () {
        gui.textArea.setFont(new Font("Arial", Font.PLAIN, gui.textArea.getFont().getSize()));
        System.out.println("Font is now "+ gui.textArea.getFont().getFamily());
    }
    public void fontCS () {
        gui.textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, gui.textArea.getFont().getSize()));
        System.out.println("Font is now "+ gui.textArea.getFont().getFamily());
    }
    public void fontTNR () {
        gui.textArea.setFont(new Font("Times New Roman", Font.PLAIN, gui.textArea.getFont().getSize()));
        System.out.println("Font is now "+ gui.textArea.getFont().getFamily());
    }
    public void createInputFont() {
        gui.tInputFont = new JTextArea();
        gui.inputScroll = new JScrollPane(gui.tInputFont, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        gui.inputScroll.setBorder(BorderFactory.createEmptyBorder());
        gui.tInputFont.setBorder(new EmptyBorder(3, 5, 0, 0));
    }
    public void createInputSize() {
        gui.tInputSize = new JTextArea();
        gui.sizeScroll = new JScrollPane(gui.tInputSize, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        gui.sizeScroll.setBorder(BorderFactory.createEmptyBorder());
        gui.tInputSize.setSize(40,20);
        gui.tInputSize.setBorder(new EmptyBorder(3,5,0,0));
    }
    public void createFontChooserDialog(){
        gui.bInputFont = new JButton("Use This Font");
        gui.bInputFont.addActionListener( this);
        gui.bInputFont.setActionCommand("Use This Font");
        gui.bInputFont.setAlignmentX(Component.CENTER_ALIGNMENT);
        gui.dFontChooser = new JDialog(gui.window, "Choose Font", true);
        createInputFont();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel myLabel = new JLabel("Enter Font Name:");
        myLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(myLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(gui.inputScroll);
       // panel.add(gui.inputFont);
        panel.add(Box.createVerticalStrut(10));
        panel.add(gui.bInputFont);
        gui.dFontChooser.getContentPane().add(panel);
        gui.dFontChooser.setSize(400, 200);
        gui.dFontChooser.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        gui.dFontChooser.setVisible(true);
        gui.dFontChooser.setLocationRelativeTo(gui.window);
        gui.dFontChooser.setLocation(0, 0);
        System.out.println("Dialog Opened");
    }
    public void choosenFontSetter() {
        gui.textArea.setFont(new Font(gui.tInputFont.getText(), Font.PLAIN, gui.textArea.getFont().getSize()));
        System.out.println("Font is now "+ gui.textArea.getFont().getFamily());
        gui.dFontChooser.dispose();
    }
    public void setSize12() {gui.textArea.setFont(new Font(gui.textArea.getFont().getFamily(), Font.PLAIN, 12));}
    public void setSize24() {gui.textArea.setFont(new Font(gui.textArea.getFont().getFamily(), Font.PLAIN, 24));}
    public void setSize36 () {gui.textArea.setFont(new Font(gui.textArea.getFont().getFamily(), Font.PLAIN, 36));}
    public void setSize48 () {gui.textArea.setFont(new Font(gui.textArea.getFont().getFamily(), Font.PLAIN, 48));}

    public void createSizeChooserDialog() {
        gui.dSizeChooser = new JDialog(gui.window, "Choose Your Desired Text Size", true);
        gui.dSizeChooser.setSize(400, 200);
        gui.bSizeChooser = new JButton("Use This Size");
        gui.bSizeChooser.addActionListener(this);
        gui.bSizeChooser.setActionCommand("Use This Size");
        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Enter The Size You Would Like The Text To Be");
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setBorder(new EmptyBorder(10, 10 ,10,10));
        panel2.add(label2);
        panel2.add(Box.createVerticalStrut(10));
        createInputSize();
        panel2.add(gui.tInputSize);
        panel2.add(Box.createVerticalStrut(10));
        panel2.add(gui.bSizeChooser);
        gui.dSizeChooser.add(panel2);
        panel2.add(Box.createVerticalStrut(10));
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        gui.bSizeChooser.setAlignmentX(Component.CENTER_ALIGNMENT);
        gui.dSizeChooser.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        gui.dSizeChooser.setVisible(true);
        gui.bSizeChooser.setVisible(true);

        System.out.println("Dialog For Size Open");
    }
    public void choosenSizeSetter() {
        gui.textArea.setFont(new Font(gui.textArea.getFont().getFamily(), Font.PLAIN, Integer.parseInt(gui.tInputSize.getText())));
        System.out.println("Font is now size "+ gui.textArea.getFont().getSize());
        gui.dSizeChooser.dispose();
        if(Integer.parseInt(gui.tInputSize.getText()) != gui.textArea.getFont().getSize())  {System.out.println("INVALID INPUT");}
        // PLACE ERROR BOX IN PLACE OF TERMINAL OUTPUT HERE LATER PLEASE //
    }
    public void wordWrap() {
        if (wordWrapped)
            {gui.iWrap.setText("Word Wrap: Off");
            gui.textArea.setWrapStyleWord(false); wordWrapped = false; gui.textArea.setLineWrap(false);}
        else
            {gui.iWrap.setText("Word Wrap: On"); gui.textArea.setWrapStyleWord(true); wordWrapped = true; gui.textArea.setLineWrap(true);}
    }
    public void changeForegroundColor(String color) {
        System.out.println("Background Color Being Changed");
        switch (color) {
            case "Black": gui.textArea.setForeground(Color.BLACK); System.out.println("Color is Now " + color); break;
            case "Blue": gui.textArea.setForeground(Color.BLUE); System.out.println("Color is Now " + color); break;
            case "White": gui.textArea.setForeground(Color.WHITE); System.out.println("Color is Now " + color); break;
        }
    }

    public void customColorSetter() {
        Color color = gui.textArea.getForeground();
        Color newcolor = JColorChooser.showDialog(gui.window, "Pick A Font Color", color);
        System.out.println("Color Picker Open");
        gui.textArea.setForeground(newcolor);
        System.out.println("Color Set");
    }
    public void keyboardShortcuts() {
        JDialog dkeyBoardShortcuts = new JDialog(gui.window, "Keyboard Shortcuts", false);
        dkeyBoardShortcuts.setSize(350, 300);
        JLabel keyboardShortcutsLabel = new
                JLabel("<html>Ctrl + N ---> New <br> " + "Ctrl + O ---> Open <br>" + "Ctrl + S ---> Save<br>"
                +"Ctrl + Shift + S ---> Save As<br>"+"Ctrl + + ---> Increase Font Size By 1 <br>" + "Ctrl + - ---> Decrease Font Size By 1<br>"
                + "Ctrl + V ---> Encrypt Using Vigenère Cipher<br>" + "Ctrl + Shift + V ---> Decrypt Using Vigenère Cipher<br>"
                + "Ctrl + C ---> Encrypt Using Caesar Cipher<br>" + "Ctrl + Shift + C ---> Decrypt Using Caesar Cipher<br>"
                + "Ctrl + B ---> Make Text Bold<br>" + "Ctrl + I ---> Make Text Italic<br>" + "F11 ---> Toggle Fullscreen<br>"
                + "Alt + F4 ---> Exit SoftScribe");
        keyboardShortcutsLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
        JPanel keyboardShortcuts = new JPanel();
        keyboardShortcuts.setAlignmentX(Box.CENTER_ALIGNMENT);
        keyboardShortcuts.setLayout(new BoxLayout(keyboardShortcuts, BoxLayout.Y_AXIS));
        keyboardShortcuts.setBorder(new EmptyBorder(10, 10 ,10,10));
        keyboardShortcuts.add(Box.createVerticalStrut(10));
        keyboardShortcuts.add(keyboardShortcutsLabel);
        keyboardShortcuts.add(Box.createVerticalStrut(10));
        dkeyBoardShortcuts.add(keyboardShortcuts);
        dkeyBoardShortcuts.setVisible(true);
    }    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Use This Font": choosenFontSetter(); break;
            case "Use This Size": choosenSizeSetter(); break;
            case "Use This Color": customColorSetter(); break;
        }
    }
}
