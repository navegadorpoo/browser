package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ResponsiveDimension extends Dimension {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    public ResponsiveDimension(int width, int height) {
        this.width = getResponsiveWidth(width);
        this.height = getResponsiveHeight(height);
    }
    
    public int getResponsiveWidth(int percentage) {
        return screenSize.width * percentage / 100;
    }
    
    public int getResponsiveHeight(int percentage) {
        return screenSize.height * percentage / 100;
    }
}
