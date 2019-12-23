package com.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Folder {
    private  List<Folder> subfolders;
    private  List<File> files;
    private final String path;
    public Folder(String path){
        this.path = path;
        subfolders = new ArrayList<>();
        files = new ArrayList<>();
        getCatalogue();
    }
    private void getCatalogue(){
        File file = new File(path);
        List<File> subfiles = Arrays.asList(Objects.requireNonNull(file.listFiles()));

        for (File subfile:subfiles) {
            if(!subfile.isDirectory()) files.add(subfile);
            else{
                Folder folder = new Folder(subfile.getPath());
                subfolders.add(folder);
            }
        }
    }
    public void writeIntoFile(FileOutputStream fos, String spaces) throws IOException {
        for (File file: files) {
            fos.write(("\n"+spaces+file.getName()).getBytes());
        }
        for (Folder folder: subfolders) {
            File file = new File(folder.path);
            fos.write(("\n"+spaces+file.getName()).getBytes());
            folder.writeIntoFile(fos, spaces+" ");
        }
    }

}
