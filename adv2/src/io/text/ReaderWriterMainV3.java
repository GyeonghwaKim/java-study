package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV3 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println(writeString);

        FileWriter fw = new FileWriter(FILE_NAME,UTF_8);
        fw.write(writeString);
        fw.close();

        StringBuilder builder = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME,UTF_8);
        int data;
        while((data = fr.read()) != -1){
            builder.append((char) data);
        }
        fr.close();
        System.out.println(builder.toString());

    }
}
