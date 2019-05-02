/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author richard.290894
 */
public class FileManager {
    
    private File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String text = "";
    
    public FileManager(File file) {
        this.file = file;
    }
    
    public FileManager prepare() {
        if (!file.canRead()) {
            //do something
        }
        
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            //do something
        }
        
        return this;
    }
    
    public String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            //do something
        } catch (NullPointerException e) {
           // do something
        }
        return null;
    }
    
    public String readWholeFile() {
        String line;
        while ((line = readLine()) != null) {
            text += line;
        }
        return text;
    }
}
