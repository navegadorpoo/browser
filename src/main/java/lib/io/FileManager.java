package lib.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import gui.components.interaction.Dialog;

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
            Dialog.showMessage("error", "Atenção", "O arquivo solicitado não pode ser lido");
        }

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            Dialog.showMessage("error", "Atenção", "Problemas na leitura do arquivo");
        }

        return this;
    }

    public String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException | NullPointerException e) {
            Dialog.showMessage("error", "Atenção", "Problemas na leitura do arquivo");
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
