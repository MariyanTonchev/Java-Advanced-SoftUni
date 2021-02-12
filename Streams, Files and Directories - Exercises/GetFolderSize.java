import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "E:\\Projects\\Exercises Resources";
        File root = new File(path);
        long size = 0;
        File[] files = root.listFiles();
        for (File file : files) {
            size += file.length();
        }
        System.out.println("Folder size: " + size);
    }
}