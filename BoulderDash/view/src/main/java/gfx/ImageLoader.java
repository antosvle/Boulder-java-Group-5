package gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Nicolas on 21/06/2017.
 */
public class ImageLoader {
    /**
     * Load image buffered image.  method which will load images
     *
     * @param path the path
     * @return the buffered image
     */

    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
