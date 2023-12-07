package FileFounder;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileFounder {

    List<File> fileList = new ArrayList<>();
    List<String> pathList = new ArrayList<>();
    String endsWith;


    public FileFounder(String path,
                       String endsWith) {
        this.endsWith = endsWith;
        File file = new File(path);
        searchFiles(List.of(file.listFiles()));
    }
    public List<File> getFileList() {
        return fileList;
    }

    public List<String> getPathList() {
        return pathList;
    }

    public List<File> searchFiles(List<File> file) {
        file.forEach(f -> {
            if (f != null) {
                if (f.isDirectory()) {
                    searchFiles(Arrays.asList(f.listFiles()));
                } else if (f.getName().toLowerCase().endsWith(endsWith)) {
                    fileList.add(f);
                    pathList.add(f.getPath());
                }
            }
        });
        if (fileList.isEmpty()) {
            return null;
        }
        return fileList;
    }


    @Override
    public String toString() {
        if (fileList.isEmpty()) {
            return "file type " + endsWith + " not found";
        }
        StringBuilder builder = new StringBuilder();
        fileList.forEach(f -> builder.append(f.getName()).append("   Путь к файлу: ").append(f.getPath()).append("\n"));
        return builder.toString();
    }
}
