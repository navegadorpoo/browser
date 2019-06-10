package gui.components.interaction;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Dialog {
    public static int showConfirm(String title, String message) {
        Object[] options = { "Confirmar", "Cancelar" };
        
        int answer = JOptionPane.showOptionDialog(null,
            message,
            title,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE,
            new ImageIcon("src/main/resources/error.png"),
            options,
            options[0]
        );
        
        return answer;
    }

    public static void showMessage(String type, String title, String message) {
        JOptionPane.showMessageDialog(
            null,
            message,
            title,
            JOptionPane.PLAIN_MESSAGE,
            new ImageIcon(String.format("src/main/resources/%s.png", type))
        );
    }
    
    public static String showInput(String message) {
        Object response = JOptionPane.showInputDialog(
            null,
            message,
            "Informação",
            JOptionPane.PLAIN_MESSAGE,
            new ImageIcon("src/main/resources/info.png"),
            null,
            null
        );

        return response != null ? response.toString() : null;
    }
}
