package unit1.FileInputOutputStream;

import java.io.*;
public class Example {
    public static void main(String[] args) {
        String fileName = "unit1/FileInputOutputStream/file.txt";
        String outputFile = "unit1/FileInputOutputStream/output.txt";
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(outputFile);
//            int content;
//            while ((content = fis.read()) != -1) {
//                System.out.print((char)content);
//            }


            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
