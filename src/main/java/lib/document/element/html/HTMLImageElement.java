package lib.document.element.html;

import lib.net.UrlComplete;
import gui.components.page.Page;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import lib.browser.Browser;

public class HTMLImageElement extends HTMLElement {
    @Override
    public void render(Page page) {
        String urlBase  = Browser.getInstance().getWindow().getLocation().getUrl();
        String urlImage = urlBase + getAttribute("src");
        
        try {
            BufferedImage image = ImageIO.read(new URL(urlImage));
            JLabel label = new JLabel(new ImageIcon(image));
            page.add(label);
            page.revalidate();
        } catch (IOException e) {
            System.out.println("Não achou a imagem");
        }
    }

}
