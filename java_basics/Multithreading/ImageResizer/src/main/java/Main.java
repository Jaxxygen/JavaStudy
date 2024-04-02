import java.io.File;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "./resources/ImagesSrc";
        String dstFolder = "./resources/ImagesDst";
        String dstImgsclrFolder = "./resources/ImgsclrResized";

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();
        int newWidth = 300;

        double availableCores = Runtime.getRuntime().availableProcessors();
        int threadCount = (int) Math.ceil(files.length / availableCores);

        if (threadCount == 0) {
            //Resizer через код
            ImageResizerThread imageResizerThread = new ImageResizerThread(files, dstFolder, newWidth);
            new Thread(imageResizerThread).start();
        } else {
            for (int i = 0; i < files.length; i = i + threadCount) {
                if ((threadCount + i) > files.length) {
                    threadCount = (threadCount + i) - files.length;
                }
                File[] fileCopy = new File[threadCount];
                if (i == 0) {
                    //Resizer через код
                    System.arraycopy(files, 0, fileCopy, 0, threadCount);
                    ImageResizerThread imageResizerThread = new ImageResizerThread(fileCopy, dstFolder, newWidth);
                    new Thread(imageResizerThread).start();

                    //Imgsclr
                    ImageResizeByImgesclrThread imageResize = new ImageResizeByImgesclrThread(fileCopy, dstImgsclrFolder, newWidth);
                    new Thread(imageResize).start();

                } else {
                    //Resizer через код
                    System.arraycopy(files, i, fileCopy, 0, threadCount);
                    ImageResizerThread imageResizerThread = new ImageResizerThread(fileCopy, dstFolder, newWidth);
                    new Thread(imageResizerThread).start();

                    //Imgsclr
                    ImageResizeByImgesclrThread imageResize = new ImageResizeByImgesclrThread(fileCopy, dstImgsclrFolder, newWidth);
                    new Thread(imageResize).start();
                }
            }
        }
    }
}
