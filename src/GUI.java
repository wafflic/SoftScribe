import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;


public class GUI implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JScrollPane inputScroll, sizeScroll, encryptionScroll; // encryptionScroll is also used for decryption dialogs
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuEncrypt, menuColor, menuDecrypt;
    JMenu menuFont, menuFontSize, menuFontColor;
    JMenuItem iFontWhite, iFontBlack, iFontBlue, iFontCustomColor, iKeyboardShortcuts; // Font Colors (Format --> Font Colors)
    JMenuItem iNew, iSave, iOpen, iSaveAs, iExit, iSizeChooser; // File Menu Items
    JMenuItem iUndo, iRedo; // Edit Menu Items
    JMenuItem iEncryptionVigenère, iEncryptionCaesar; // Encrypt Menu Items
    JMenuItem iDecryptionVigenère, iDecryptionCaesar; // Decrypt Menu Items
    JMenuItem iWrap, iFontAptos, iFontChooser, iFontTNR, iFontArial, iFontCS; // Format --> Font Menu Items + Wrap
    JMenuItem iSize12, iSize24, iSize36, iSize48; // Font --> Size Menu Items
    JMenuItem iWhite, iBlack, iBlue, iCustomColor, iDarkTheme, iLightTheme;
    JTextArea tInputFont, tInputSize, tEncryption; // tEncryption is also used for decryption dialogs
    JDialog dFontChooser, dSizeChooser, dEncryption, dDecryption; // dEncryption --> All Encryption Dialogs // dDecryption --> All Decryption Dialogs
    JButton bInputFont, bSizeChooser, bEncryption, bDecryption; // Same As Dialogs

    JTabbedPane fileTab;

    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Ciphers ciphers = new Function_Ciphers(this);
    Function_Color color = new Function_Color(this);
    Function_Edit edit = new Function_Edit(this);
    KeyHandler shortcuts = new KeyHandler(this);
    UndoManager um = new UndoManager();
    public static void main(String[] args) {
        new GUI();
    }
    public GUI() {
        createWindow();
        createTextArea();
        createTabBar();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createEncryptMenu();
        createDecryptMenu();
        createColorMenu();
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("SoftScribe");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("C://Users//ZOZINHO//Downloads//pics//ChatGPT Image Apr 4, 2025, 10_26_57 PM.png");
        window.setIconImage(icon.getImage());
        window.setLocation(0, 0);
        window.setUndecorated(false);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
    public void createTextArea() {
        textArea = new JTextArea();

        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });

        textArea.addKeyListener(shortcuts);
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
        textArea.setBorder(new EmptyBorder(3, 5, 0, 0));
    }
    public JScrollPane createNewTextArea(JTextArea newTextArea, UndoManager newUM, KeyHandler kh) {
        newTextArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                newUM.addEdit(e.getEdit());
            }
        });

        newTextArea.addKeyListener(kh);
        JScrollPane newScrollPane = new JScrollPane(newTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        newScrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(newScrollPane);
        newTextArea.setBorder(new EmptyBorder(3, 5, 0, 0));
        return newScrollPane;
    }
    public void createTabBar() {
        fileTab = new JTabbedPane();
        window.add(fileTab);
        JFileChooser fc = new JFileChooser();
        File file1 = fc.getSelectedFile();
        if (file1!=null) {fileTab.addTab(file1.getName(), textArea);} else{fileTab.addTab("New.txt", textArea);}

    }
    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);
        menuEncrypt = new JMenu("Encrypt");
        menuBar.add(menuEncrypt);
        menuDecrypt = new JMenu("Decrypt");
        menuBar.add(menuDecrypt);
        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }
    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");

        iOpen= new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");

        menuFile.add(iNew);
        menuFile.add(iSave);
        menuFile.add(iOpen);
        menuFile.add(iSaveAs);
        menuFile.add(iExit);
    }
    public void createEditMenu() {
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);
        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }
    public void createEncryptMenu() {
        iEncryptionVigenère = new JMenuItem("Vigenère");
        iEncryptionVigenère.addActionListener(this);
        iEncryptionVigenère.setActionCommand("Vigenère");
        iEncryptionCaesar = new JMenuItem("Caesar");
        iEncryptionCaesar.addActionListener(this);
        iEncryptionCaesar.setActionCommand("Caesar");
        menuEncrypt.add(iEncryptionVigenère);
        menuEncrypt.add(iEncryptionCaesar);
    }
    public void createDecryptMenu() {
        iDecryptionVigenère = new JMenuItem("Vigenère");
        iDecryptionVigenère.addActionListener(this);
        iDecryptionVigenère.setActionCommand("Decrypt Vigenère");
        menuDecrypt.add(iDecryptionVigenère);
        iDecryptionCaesar = new JMenuItem("Caesar");
        iDecryptionCaesar.addActionListener(this);
        iDecryptionCaesar.setActionCommand("Decrypt Caesar");
        menuDecrypt.add(iDecryptionCaesar);
    }
    public void createFormatMenu() {
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);
        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);
            iFontAptos = new JMenuItem("Aptos");
            iFontAptos.addActionListener(this);
            iFontAptos.setActionCommand("Aptos");
            menuFont.add(iFontAptos);
            iFontArial = new JMenuItem("Arial");
            iFontArial.addActionListener(this);
            iFontArial.setActionCommand("Arial");
            menuFont.add(iFontArial);
            iFontCS = new JMenuItem("Comic Sans");
            iFontCS.addActionListener(this);
            iFontCS.setActionCommand("Comic Sans");
            menuFont.add(iFontCS);
            iFontTNR = new JMenuItem("Times New Roman");
            iFontTNR.addActionListener(this);
            iFontTNR.setActionCommand("Times New Roman");
            menuFont.add(iFontTNR);
            iFontChooser = new JMenuItem("Choose Another Font");
            iFontChooser.addActionListener(this);
            iFontChooser.setActionCommand("Choose Another Font");
            menuFont.add(iFontChooser);
        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);
            iSize12 = new JMenuItem("12");
            iSize12.addActionListener(this);
            iSize12.setActionCommand("12");
            menuFontSize.add(iSize12);
            iSize24 = new JMenuItem("24");
            iSize24.addActionListener(this);
            iSize24.setActionCommand("24");
            menuFontSize.add(iSize24);
            iSize36 = new JMenuItem("36");
            iSize36.addActionListener(this);
            iSize36.setActionCommand("36");
            menuFontSize.add(iSize36);
            iSize48 = new JMenuItem("48");
            iSize48.addActionListener(this);
            iSize48.setActionCommand("48");
            menuFontSize.add(iSize48);
            iSizeChooser = new JMenuItem("Pick A Different Size");
            iSizeChooser.addActionListener(this);
            iSizeChooser.setActionCommand("Pick A Different Size");
            menuFontSize.add(iSizeChooser);
        menuFontColor = new JMenu("Font Color");
        menuFormat.add(menuFontColor);
        iFontBlack = new JMenuItem("Black");
            iFontBlack.addActionListener(this);
            iFontBlack.setActionCommand("Font Black");
            menuFontColor.add(iFontBlack);
            iFontBlue = new JMenuItem("Blue");
            iFontBlue.addActionListener(this);
            iFontBlue.setActionCommand("Font Blue");
            menuFontColor.add(iFontBlue);
            iFontWhite = new JMenuItem("White");
            iFontWhite.addActionListener(this);
            iFontWhite.setActionCommand("Font White");
            menuFontColor.add(iFontWhite);
            iFontCustomColor = new JMenuItem("Choose A Different Color");
            iFontCustomColor.addActionListener(this);
            iFontCustomColor.setActionCommand("Choose A Different Color");
            menuFontColor.add(iFontCustomColor);
        iKeyboardShortcuts = new JMenuItem("Keyboard Shortcuts");
        iKeyboardShortcuts.addActionListener(this);
        iKeyboardShortcuts.setActionCommand("Keyboard Shortcuts");
        menuFormat.add(iKeyboardShortcuts);
    }
    public void createColorMenu() {
     iWhite = new JMenuItem("White");
     iWhite.addActionListener(this);
     iWhite.setActionCommand("White");
     menuColor.add(iWhite);
     iBlack = new JMenuItem("Black");
     iBlack.addActionListener(this);
     iBlack.setActionCommand("Black");
     menuColor.add(iBlack);
     iBlue = new JMenuItem("Blue");
     iBlue.addActionListener(this);
     iBlue.setActionCommand("Blue");
     menuColor.add(iBlue);
        iLightTheme = new JMenuItem("Light Theme");
        iLightTheme.addActionListener(this);
        iLightTheme.setActionCommand("Light Theme");
        menuColor.add(iLightTheme);
     iDarkTheme = new JMenuItem("Dark Theme");
     iDarkTheme.addActionListener(this);
     iDarkTheme.setActionCommand("Dark Theme");
     menuColor.add(iDarkTheme);
     iCustomColor = new JMenuItem("Choose A Different Background Color");
     iCustomColor.addActionListener(this);
     iCustomColor.setActionCommand("Choose A Different Background Color");
     menuColor.add(iCustomColor);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New": file.newFile(); break;
            case "Open": file.openFile(); break;
            case "Save As": file.saveAsFile(); break;
            case "Save": file.saveFile(); break;
            case "Exit": file.exitFile(); break;
            case "Aptos": format.fontAptos(); break;
            case "Choose Another Font": format.createFontChooserDialog(); break;
            case "Use This Font": format.choosenFontSetter(); break;
            case "Arial": format.fontArial(); break;
            case "Comic Sans": format.fontCS(); break;
            case "Times New Roman": format.fontTNR(); break;
            case "Pick A Different Size": format.createSizeChooserDialog(); break;
            case "12": format.setSize12(); break;
            case "24": format.setSize24(); break;
            case "36": format.setSize36(); break;
            case "48": format.setSize48(); break;
            case "Word Wrap": format.wordWrap(); break;
            case "Undo": edit.undo(); System.out.println("Undo Performed"); break;
            case "Redo": edit.redo(); System.out.println("Redo Performed"); break;
            case "Vigenère": ciphers.createVigenèreEncryptionDialog(); System.out.println("Action command: " + command); break;
            case "Decrypt Vigenère": ciphers.createVigenèreDecryptionDialog(); System.out.println("Action command: " + command); break;
            case "Caesar": ciphers.createCaesarEncryptionDialog(); System.out.println("Action command: " + command); break;
            case "Decrypt Caesar": ciphers.createCaesarDecryptionDialog(); System.out.println("Action command: " + command); break;
            case "Font Black": format.changeForegroundColor("Black"); break;
            case "Font Blue": format.changeForegroundColor("Blue"); break;
            case "Font White": format.changeForegroundColor("White"); break;
            case "Black": color.changeBackgroundColor("Black"); break;
            case "Blue": color.changeBackgroundColor("Blue"); break;
            case "White": color.changeBackgroundColor("White"); break;
            case "Choose A Different Color": format.customColorSetter(); break;
            case "Choose A Different Background Color": color.customBackgroundColorSetter(); break;
            case "Dark Theme": color.darkTheme(); break;
            case "Light Theme": color.lightTheme(); break;
            case "Keyboard Shortcuts": format.keyboardShortcuts(); break;
        }
    }
}
