import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GUI gui;
    boolean fullscreen = false;
    public KeyHandler(GUI gui) {this.gui = gui;}
    @Override
    public void keyTyped(KeyEvent e) { //not using this

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //use this for shortcuts
     JTextArea textArea = (JTextArea) e.getSource();  
     if (e.getKeyCode() == KeyEvent.VK_S && e.isControlDown()) {gui.file.saveFile();}
     if (e.getKeyCode() == KeyEvent.VK_S && e.isControlDown() && e.isShiftDown()) {gui.file.saveAsFile();}
     if (fullscreen && e.getKeyCode() == KeyEvent.VK_F11) {
         GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
         gd.setFullScreenWindow(null); fullscreen = false;
         gui.window.setExtendedState(JFrame.MAXIMIZED_BOTH);
     } else if (!fullscreen && e.getKeyCode() == KeyEvent.VK_F11) {
         GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
         gd.setFullScreenWindow(gui.window); fullscreen = true;}
     if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O) {gui.file.openFile();}
     if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N) {gui.file.newFile();}
     if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_V) {gui.ciphers.createVigenèreEncryptionDialog();}
     if (e.isControlDown() && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_V) {gui.ciphers.createVigenèreDecryptionDialog();}
     if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_C) {gui.ciphers.createCaesarEncryptionDialog();}
     if (e.isControlDown() && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_V) {gui.ciphers.createCaesarDecryptionDialog();}
     if (e.isControlDown() && (e.getKeyCode() == KeyEvent.VK_PLUS || e.getKeyCode()==KeyEvent.VK_EQUALS)) {textArea.setFont(new Font(textArea.getFont().getFamily(), textArea.getFont().getStyle(), textArea.getFont().getSize()+1)); System.out.println("Font Size Increased by 1");}
     if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_MINUS) {textArea.setFont(new Font(textArea.getFont().getFamily(), textArea.getFont().getStyle(), textArea.getFont().getSize()-1));}

     if (textArea.getFont().isBold() && !textArea.getFont().isItalic() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_B) {
         textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, textArea.getFont().getSize())); 
     } else if (textArea.getFont().isBold() && textArea.getFont().isItalic() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_B) {
         textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN | Font.ITALIC, textArea.getFont().getSize())); 
     }
     else if (!textArea.getFont().isBold() && !textArea.getFont().isItalic() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_B) {
         textArea.setFont(new Font(textArea.getFont().getFamily(), Font.BOLD, textArea.getFont().getSize())); 
     }
     else if (!textArea.getFont().isBold() && textArea.getFont().isItalic() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_B) {
         textArea.setFont(new Font(textArea.getFont().getFamily(), Font.BOLD | Font.ITALIC, textArea.getFont().getSize())); 
     }
     if (textArea.getFont().isItalic() && !textArea.getFont().isBold() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_I) {
         textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, textArea.getFont().getSize())); }
     else if (textArea.getFont().isItalic() && textArea.getFont().isBold() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_I) {
         textArea.setFont(new Font(textArea.getFont().getFamily(), Font.BOLD, textArea.getFont().getSize())); 
     }
     else if (!textArea.getFont().isItalic() && !textArea.getFont().isBold() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_I) {
         textArea.setFont(new Font(textArea.getFont().getFamily(), Font.ITALIC, textArea.getFont().getSize())); 
     }
     else if (!textArea.getFont().isItalic() && textArea.getFont().isBold() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_I) {
         textArea.setFont(new Font(textArea.getFont().getFamily(), Font.ITALIC | Font.BOLD, textArea.getFont().getSize())); 
     }

    }


    @Override
    public void keyReleased(KeyEvent e) { //or this

    }
}
