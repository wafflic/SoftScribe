import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.abs;

public class Function_Ciphers  implements ActionListener {
    GUI gui;
    char[] plaintextCharArray;
    char[] lowercaseAlphabet= new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] keyToChar;
    int[] plaintextIntArray;
    int[] keyToInt;
    char[] uppercaseAlphabet = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M',
            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public Function_Ciphers(GUI gui) {this.gui = gui;}

    public void createInputEncryptionKey() {
        gui.tEncryption = new JTextArea();
        gui.encryptionScroll = new JScrollPane(gui.tEncryption, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        gui.encryptionScroll.setBorder(BorderFactory.createEmptyBorder());
        gui.tEncryption.setBorder(new EmptyBorder(3,5,0,0));
    }
    public void charToNumber() {
        plaintextCharArray = gui.textArea.getText().toCharArray();
        String ciphertext = new String(plaintextCharArray);
        System.out.println(ciphertext);
        keyToChar = gui.tEncryption.getText().toCharArray();
        keyToInt = new int[keyToChar.length];
        plaintextIntArray = new int[gui.textArea.getText().length()];
        for (int j = 0; j< plaintextCharArray.length; j++) {
            char plaintextChar = plaintextCharArray[j];
            switch (plaintextChar) {
                case 'a': case 'A': plaintextIntArray[j] = 0; break;
                case 'b': case 'B': plaintextIntArray[j] = 1; break;
                case 'c': case 'C': plaintextIntArray[j] = 2; break;
                case 'd': case 'D': plaintextIntArray[j] = 3; break;
                case 'e': case 'E': plaintextIntArray[j] = 4; break;
                case 'f': case 'F': plaintextIntArray[j] = 5; break;
                case 'g': case 'G': plaintextIntArray[j] = 6; break;
                case 'h': case 'H': plaintextIntArray[j] = 7; break;
                case 'i': case 'I': plaintextIntArray[j] = 8; break;
                case 'j': case 'J': plaintextIntArray[j] = 9; break;
                case 'k': case 'K': plaintextIntArray[j] = 10; break;
                case 'l': case 'L': plaintextIntArray[j] = 11; break;
                case 'm': case 'M': plaintextIntArray[j] = 12; break;
                case 'n': case 'N': plaintextIntArray[j] = 13; break;
                case 'o': case 'O': plaintextIntArray[j] = 14; break;
                case 'p': case 'P': plaintextIntArray[j] = 15; break;
                case 'q': case 'Q': plaintextIntArray[j] = 16; break;
                case 'r': case 'R': plaintextIntArray[j] = 17; break;
                case 's': case 'S': plaintextIntArray[j] = 18; break;
                case 't': case 'T': plaintextIntArray[j] = 19; break;
                case 'u': case 'U': plaintextIntArray[j] = 20; break;
                case 'v': case 'V': plaintextIntArray[j] = 21; break;
                case 'w': case 'W': plaintextIntArray[j] = 22; break;
                case 'x': case 'X': plaintextIntArray[j] = 23; break;
                case 'y': case 'Y': plaintextIntArray[j] = 24; break;
                case 'z': case 'Z': plaintextIntArray[j] = 25; break;
            }
        }
    }

    public void createVigenèreEncryptionDialog(){
        gui.dEncryption = new JDialog(gui.window, "Choose A Key", true);
        gui.bEncryption = new JButton("Encrypt Using This Key");
        gui.bEncryption.addActionListener(this);
        gui.bEncryption.setActionCommand("Encrypt Using This Vigenère Key");
        gui.bEncryption.setAlignmentX(Box.CENTER_ALIGNMENT);
        gui.dEncryption.setSize(400,200);
        JPanel encryptionPanel = new JPanel();
        encryptionPanel.setLayout(new BoxLayout(encryptionPanel, BoxLayout.Y_AXIS));
        JLabel encryptionLabel = new JLabel("Enter The Key You Would Like To Use For Vigenère Encryption:");
        encryptionLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
        encryptionPanel.add(encryptionLabel);
        encryptionPanel.add(Box.createVerticalStrut(10));
        createInputEncryptionKey();
        encryptionPanel.add(gui.tEncryption);
        encryptionPanel.add(Box.createVerticalStrut(10));
        JLabel encryptionWarningLabel = new JLabel("Key Must Be 2 English Letters or Longer");
        encryptionWarningLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
        encryptionWarningLabel.setFont(new Font(gui.textArea.getFont().getFamily(), Font.ITALIC, 12));
        encryptionPanel.add(encryptionWarningLabel);
        encryptionPanel.add(Box.createVerticalStrut(10));
        encryptionPanel.add(gui.bEncryption);
        encryptionPanel.add(Box.createVerticalStrut(10));
        gui.dEncryption.getContentPane().add(encryptionPanel);
        gui.dEncryption.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        gui.dEncryption.setLocationRelativeTo(gui.window);
        gui.dEncryption.setVisible(true);
    }
    public void createCaesarEncryptionDialog(){
        gui.dEncryption = new JDialog(gui.window, "Choose A Key", true);
        gui.bEncryption = new JButton("Encrypt Using This Key");
        gui.bEncryption.addActionListener(this);
        gui.bEncryption.setActionCommand("Encrypt Using This Caesar Key");
        gui.bEncryption.setAlignmentX(Box.CENTER_ALIGNMENT);
        gui.dEncryption.setSize(400,200);
        JPanel encryptionPanel = new JPanel();
        encryptionPanel.setLayout(new BoxLayout(encryptionPanel, BoxLayout.Y_AXIS));
        JLabel encryptionLabel = new JLabel("Enter The Key You Would Like To Use For Caesar Encryption:");
        encryptionLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
        encryptionPanel.add(encryptionLabel);
        encryptionPanel.add(Box.createVerticalStrut(10));
        createInputEncryptionKey();
        encryptionPanel.add(gui.tEncryption);
        encryptionPanel.add(Box.createVerticalStrut(10));
        JLabel encryptionWarningLabel = new JLabel("Key Must Be A Number");
        encryptionWarningLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
        encryptionWarningLabel.setFont(new Font(gui.textArea.getFont().getFamily(), Font.ITALIC, 12));
        encryptionPanel.add(encryptionWarningLabel);
        encryptionPanel.add(Box.createVerticalStrut(10));
        encryptionPanel.add(gui.bEncryption);
        encryptionPanel.add(Box.createVerticalStrut(10));
        gui.dEncryption.getContentPane().add(encryptionPanel);
        gui.dEncryption.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        gui.dEncryption.setLocationRelativeTo(gui.window);
        gui.dEncryption.setVisible(true);
    }
    public void createCaesarDecryptionDialog(){
        gui.dDecryption = new JDialog(gui.window, "Choose A Key", true);
        gui.bDecryption = new JButton("Decrypt Using This Key");
        gui.bDecryption.addActionListener(this);
        gui.bDecryption.setActionCommand("Decrypt Using This Caesar Key");
        gui.bDecryption.setAlignmentX(Box.CENTER_ALIGNMENT);
        gui.dDecryption.setSize(400,200);
        JPanel decryptionPanel = new JPanel();
        decryptionPanel.setLayout(new BoxLayout(decryptionPanel, BoxLayout.Y_AXIS));
        JLabel decryptionLabel = new JLabel("Enter The Key You Would Like To Use For Caesar Decryption:");
        decryptionLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
        decryptionPanel.add(decryptionLabel);
        decryptionPanel.add(Box.createVerticalStrut(10));
        createInputEncryptionKey();
        decryptionPanel.add(gui.tEncryption);
        decryptionPanel.add(Box.createVerticalStrut(10));
        JLabel DecryptionWarningLabel = new JLabel("Key Must Be A Number");
        DecryptionWarningLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
        DecryptionWarningLabel.setFont(new Font(gui.textArea.getFont().getFamily(), Font.ITALIC, 12));
        decryptionPanel.add(DecryptionWarningLabel);
        decryptionPanel.add(Box.createVerticalStrut(10));
        decryptionPanel.add(gui.bDecryption);
        decryptionPanel.add(Box.createVerticalStrut(10));
        gui.dDecryption.getContentPane().add(decryptionPanel);
        gui.dDecryption.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        gui.dDecryption.setLocationRelativeTo(gui.window);
        gui.dDecryption.setVisible(true);
    }
    public void vigenèreEncryptionCalled() {
        vigenèreCipherNumbering();
        vigenèreCipherSetting();
        gui.dEncryption.dispose();
    }
    public void createVigenèreDecryptionDialog(){
        gui.dDecryption = new JDialog(gui.window, "Choose A Key", true);
        gui.bDecryption = new JButton("Decrypt Using This Key");
        gui.bDecryption.addActionListener(this);
        gui.bDecryption.setActionCommand("Decrypt Using This Vigenère Key");
        gui.bDecryption.setAlignmentX(Box.CENTER_ALIGNMENT);
        gui.dDecryption.setSize(400,200);
        JPanel decryptionPanel = new JPanel();
        decryptionPanel.setLayout(new BoxLayout(decryptionPanel, BoxLayout.Y_AXIS));
        JLabel decryptionLabel = new JLabel("Enter The Key You Would Like To Use For Vigenère Decryption:");
        decryptionLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
        decryptionPanel.add(decryptionLabel);
        decryptionPanel.add(Box.createVerticalStrut(10));
        createInputEncryptionKey();
        decryptionPanel.add(gui.tEncryption);
        decryptionPanel.add(Box.createVerticalStrut(10));
        JLabel DecryptionWarningLabel = new JLabel("Key Must Be 2 English Letters or Longer");
        DecryptionWarningLabel.setAlignmentX(Box.CENTER_ALIGNMENT);
        DecryptionWarningLabel.setFont(new Font(gui.textArea.getFont().getFamily(), Font.ITALIC, 12));
        decryptionPanel.add(DecryptionWarningLabel);
        decryptionPanel.add(Box.createVerticalStrut(10));
        decryptionPanel.add(gui.bDecryption);
        decryptionPanel.add(Box.createVerticalStrut(10));
        gui.dDecryption.getContentPane().add(decryptionPanel);
        gui.dDecryption.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        gui.dDecryption.setLocationRelativeTo(gui.window);
        gui.dDecryption.setVisible(true);
    }
    public void vigenèreDecryptionCalled() {
        vigenèreCipherNumbering();
        vigenèreCipherDecrypting();
        gui.dDecryption.dispose();
    }

    public void vigenèreCipherNumbering() {
        charToNumber();
        for (int i = 0; i< keyToChar.length; i++) {
            char keyChar = keyToChar[i];
            switch (keyChar) {
                case 'a': case 'A':
                    keyToInt[i] = 0;
                    break;
                case 'b': case 'B':
                    keyToInt[i] = 1;
                    break;
                case 'c': case 'C':
                    keyToInt[i] = 2;
                    break;
                case 'd': case 'D':
                    keyToInt[i] =3;
                    break;
                case 'e': case 'E':
                    keyToInt[i] = 4;
                    break;
                case 'f': case 'F':
                    keyToInt[i] = 5;
                    break;
                case 'g': case 'G':
                    keyToInt[i] = 6;
                    break;
                case 'h': case 'H':
                    keyToInt[i] = 7;
                    break;
                case 'i': case 'I':
                    keyToInt[i] = 8;
                    break;
                case 'j': case 'J':
                    keyToInt[i] = 9;
                    break;
                case 'k': case 'K':
                    keyToInt[i] = 10;
                    break;
                case 'l': case 'L':
                    keyToInt[i] = 11;
                    break;
                case 'm': case 'M':
                    keyToInt[i] = 12;
                    break;
                case 'n': case 'N':
                    keyToInt[i] = 13;
                    break;
                case 'o': case 'O':
                    keyToInt[i] = 14;
                    break;
                case 'p': case 'P':
                    keyToInt[i] = 15;
                    break;
                case 'q': case 'Q':
                    keyToInt[i] = 16;
                    break;
                case 'r': case 'R':
                    keyToInt[i] = 17;
                    break;
                case 's': case 'S':
                    keyToInt[i] = 18;
                    break;
                case 't': case 'T':
                    keyToInt[i] = 19;
                    break;
                case 'u': case 'U':
                    keyToInt[i] = 20;
                    break;
                case 'v': case 'V':
                    keyToInt[i] = 21;
                    break;
                case 'w': case 'W':
                    keyToInt[i] = 22;
                    break;
                case 'x': case 'X':
                    keyToInt[i] = 23;
                    break;
                case 'y': case 'Y':
                    keyToInt[i] = 24;
                    break;
                case 'z': case 'Z':
                    keyToInt[i] = 25;
                    break;
            }
        }
        }

    public void vigenèreCipherSetting() {
        int keyIndex = 0;
        for (int k = 0; k < plaintextCharArray.length; k++) {
            int ptIndex = (plaintextIntArray[k%plaintextCharArray.length]);
            int cipheredKeyIndex = (keyToInt[keyIndex%keyToChar.length]);
            if (plaintextCharArray[k] >= 'a' && plaintextCharArray[k] <= 'z') {
                plaintextCharArray[k] = lowercaseAlphabet[(ptIndex+cipheredKeyIndex)%26];
                keyIndex++;
            } else if (plaintextCharArray[k] >= 'A' && plaintextCharArray[k] <= 'Z') {
                plaintextCharArray[k] = uppercaseAlphabet[(ptIndex+cipheredKeyIndex)%26];
                keyIndex++;
            }
        }
    String ciphertext = new String(plaintextCharArray);
        System.out.println(ciphertext);
        gui.textArea.setText(ciphertext);
    }

    public void vigenèreCipherDecrypting() {
        int keyIndex = 0;
        for (int k = 0; k < plaintextCharArray.length; k++) {
            int ptIndex = (plaintextIntArray[k % plaintextCharArray.length]);
            int cipheredKeyIndex = (keyToInt[keyIndex % keyToChar.length]);
            if (plaintextCharArray[k] >= 'a' && plaintextCharArray[k] <= 'z') {
                plaintextCharArray[k] = lowercaseAlphabet[(ptIndex - cipheredKeyIndex + 26) % 26];
                keyIndex++;
            } else if (plaintextCharArray[k] >= 'A' && plaintextCharArray[k] <= 'Z') {
                plaintextCharArray[k] = uppercaseAlphabet[(ptIndex - cipheredKeyIndex + 26) % 26];
                keyIndex++;
            }
        }
        String decipheredText = new String(plaintextCharArray);
        gui.textArea.setText(decipheredText);
    }

    public void caesarCipherSetting() {
        charToNumber();
        int caesarCipherIndex = Integer.parseInt(gui.tEncryption.getText());
        for (int k = 0; k < plaintextCharArray.length; k++) {
            int ptIndex = (plaintextIntArray[k % plaintextCharArray.length]);
            if (plaintextCharArray[k] >= 'a' && plaintextCharArray[k] <= 'z') {
                plaintextCharArray[k] = lowercaseAlphabet[(ptIndex + caesarCipherIndex + 26) % 26];
            } else if (plaintextCharArray[k] >= 'A' && plaintextCharArray[k] <= 'Z') {
                plaintextCharArray[k] = uppercaseAlphabet[(ptIndex + caesarCipherIndex + 26) % 26];
            }
        }
        String ciphertext = new String(plaintextCharArray);
        System.out.println(ciphertext);
        gui.textArea.setText(ciphertext);
        gui.dEncryption.dispose();
        System.out.println("Caesar Cipher Setting Performed");
    }

    public void caesarCipherDecrypting() {
        charToNumber();
        int caesarCipherIndex = Integer.parseInt(gui.tEncryption.getText());
        for (int k = 0; k < plaintextCharArray.length; k++) {
            int ptIndex = (plaintextIntArray[k % plaintextCharArray.length]);
            if (plaintextCharArray[k] >= 'a' && plaintextCharArray[k] <= 'z') {
                plaintextCharArray[k] = lowercaseAlphabet[(ptIndex - caesarCipherIndex + 26) % 26];
            } else if (plaintextCharArray[k] >= 'A' && plaintextCharArray[k] <= 'Z') {
                plaintextCharArray[k] = uppercaseAlphabet[(ptIndex - caesarCipherIndex + 26) % 26];
            }
        }
        String ciphertext = new String(plaintextCharArray);
        System.out.println(ciphertext);
        gui.textArea.setText(ciphertext);
        gui.dEncryption.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    switch (command) {
        case "Encrypt Using This Vigenère Key": vigenèreEncryptionCalled(); System.out.println("Action command: " + command); break;
        case "Decrypt Using This Vigenère Key": vigenèreDecryptionCalled(); System.out.println("Action command: " + command); break;
        case "Encrypt Using This Caesar Key": caesarCipherSetting(); System.out.println("Action command: " + command); break;
        case "Decrypt Using This Caesar Key": caesarCipherDecrypting(); System.out.println("Action command: " + command); break;
    }
    }
}
