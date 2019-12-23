package com.files;

import java.io.FileOutputStream;
import java.io.IOException;

public class User {
    public static void getFile(String folder, String file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        Folder myFolder = new Folder(folder);
        myFolder.writeIntoFile(fos, "");
    }
    public static void main(String[] args) throws IOException {
        getFile("D:\\Temp","D:\\result.txt");
    }
}

