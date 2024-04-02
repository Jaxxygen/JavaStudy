import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

public class ImageSclr {
    public static BufferedImage resize(BufferedImage src, int targetWidth, BufferedImageOp... ops) {
        return Scalr.resize(src, Scalr.Method.ULTRA_QUALITY, targetWidth, ops);
    }
}
