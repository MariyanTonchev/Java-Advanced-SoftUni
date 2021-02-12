import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String path = "E:\\Projects\\input.txt";
        String path2 = "E:\\Projects\\write.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
             PrintWriter printWriter = new PrintWriter(new FileWriter(path2))) {
            int i = 1;
            String line = bufferedReader.readLine();
            while (line != null){
                if(i % 3 == 0){
                    printWriter.println(line);
                }
                i++;
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
