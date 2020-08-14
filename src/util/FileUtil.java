package util;

import java.io.*;

/**
 * @anthor: Banana
 * @function:
 * @date: 2020/8/10
 */
public class FileUtil {

    public static String getJson(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            File file = new File(fileName);
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void write(String fileName, String json) {
        File file = new File(fileName);
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
            output.print(json);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            output.close();
        }
    }
}
