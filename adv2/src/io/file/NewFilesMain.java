package io.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class NewFilesMain {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");


        System.out.println("File exists: "+ Files.exists(file));

        try{
            Files.createFile(file);
            System.out.println("File created");
        } catch (FileAlreadyExistsException e) {
            System.out.println(file+" File already exists");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            Files.createDirectory(directory);
            System.out.println("Directory created");
        } catch (FileAlreadyExistsException e) {
            System.out.println(directory+" Directory already exists");
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Files.delete(file);
        //System.out.println("File deleted");

        System.out.println("is regular file "+Files.isRegularFile(file));
        System.out.println("is Directory "+Files.isDirectory(directory));
        System.out.println("fileName "+file.getFileName());
        System.out.println("File size "+Files.size(file)+" bytes");

        Path newFile = Path.of("temp/newExample.txt");
        Files.move(file,newFile, StandardCopyOption.REPLACE_EXISTING); //파일을 복사할 때 같은 이름의 파일이 이미 존재하면 덮어쓰기 위해 사용합니다.
        System.out.println("File moved/renamed");

        System.out.println("Last modified: "+Files.getLastModifiedTime(newFile));

        BasicFileAttributes attrs = Files.readAttributes(newFile, BasicFileAttributes.class);
        System.out.println("==== Attributes ===");
        System.out.println("Create time: "+attrs.creationTime());
        System.out.println("isDirectory: "+attrs.isDirectory());
        System.out.println("isRegularFile: "+attrs.isRegularFile());
        System.out.println("isSymbolicLink: "+attrs.isSymbolicLink());
        System.out.println("Size: "+attrs.size());
    }
}
