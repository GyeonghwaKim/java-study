package io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class ReadTextFileV2 {

    private static final String PATH="temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("== write String ==");
        System.out.println(writeString);

        Path path=Path.of(PATH);

        Files.writeString(path,writeString, StandardCharsets.UTF_8);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        System.out.println("== readString ==");

        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i+1)+": "+lines.get(i));
        }

        Stream<String> stringStream = Files.lines(path, StandardCharsets.UTF_8);
stringStream.forEach(line -> System.out.println(line));
    stringStream.close();}
}
