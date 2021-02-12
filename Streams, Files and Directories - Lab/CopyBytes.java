import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CopyBytes {
    public static void main(String[] args) {
        String path = "E:\\Projects\\input.txt";
        String path2 = "E:\\Projects\\write2.txt";
        try (FileInputStream inputStream = new FileInputStream(path);
             OutputStream outputStream = new FileOutputStream(path2)) {
            int oneByte = 0;
            while ((oneByte = inputStream.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    outputStream.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        outputStream.write(digits.charAt(i));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
