import javax.swing.*;
import java.awt.*;

public class Function_Color {
    GUI gui;
    public Function_Color(GUI gui) {this.gui = gui;}
    public void changeBackgroundColor(String color) {
        System.out.println("Background Color Being Changed");
        switch (color) {
            case "Black": gui.textArea.setBackground(Color.BLACK); System.out.println("Color is Now " + color); break;
            case "Blue": gui.textArea.setBackground(Color.BLUE); System.out.println("Color is Now " + color); break;
            case "White": gui.textArea.setBackground(Color.WHITE); System.out.println("Color is Now " + color); break;
        }
    }
    public void customBackgroundColorSetter() {
        Color color = gui.textArea.getBackground();
        Color newcolor = JColorChooser.showDialog(gui.window, "Pick A Font Color", color);
        System.out.println("Color Picker Open");
        gui.textArea.setBackground(newcolor);
        System.out.println("Color Set");
    }
    public void darkTheme() {
        gui.textArea.setBackground(Color.BLACK);
        gui.textArea.setForeground(Color.WHITE);
    }
    public void lightTheme() {
        gui.textArea.setBackground(Color.WHITE);
        gui.textArea.setForeground(Color.BLACK);
    }
}
