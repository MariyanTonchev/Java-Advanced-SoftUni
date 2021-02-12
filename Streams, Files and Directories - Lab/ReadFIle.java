import java.io.FileInputStream;
import java.io.IOException;

public class ReadFIle {
    public static void main(String[] args) {
        String path = "E:\\Projects\\input.txt";
        try (FileInputStream fileInputStream = new FileInputStream(path)){
            int oneByte = fileInputStream.read();
            while (oneByte >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
