package io.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.*;

public class ReaderWriterMainV1 {
    public static void main(String[] args) throws IOException {
        String wirteString = "ABC";

        byte[] writeBytes = wirteString.getBytes(UTF_8);
        System.out.println(wirteString);
        System.out.println(Arrays.toString(writeBytes));

        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        fos.write(writeBytes);
        fos.close();

        FileInputStream fis = new FileInputStream(FILE_NAME);
        byte[] readBytes = fis.readAllBytes();
        fis.close();

        String readString = new String(readBytes, UTF_8);
        System.out.println(readString);

    }
}
