import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizeByImgesclrThread implements Runnable {

    File[] files;
    String dstFolder;
    int newWidth;

    public ImageResizeByImgesclrThread(File[] files, String dstFolder, int newWidth) {
        this.files = files;
        this.dstFolder = dstFolder;
        this.newWidth = newWidth;
    }

    @Override
    public void run() {
        long timeStart = System.currentTimeMillis();
        try {

            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                BufferedImage newImage = ImageSclr.resize(image, newWidth);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Imgsclr duration: " + (System.currentTimeMillis() - timeStart));
    }
}
