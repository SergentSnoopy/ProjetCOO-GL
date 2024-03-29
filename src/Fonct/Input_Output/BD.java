package Fonct.Input_Output;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class BD {
    private String path;

    public BD(String path) {
        this.path = path;
    }

    // getInfo permet de charger les données d'un fichier csv dans une liste 

    public Infos getInfo(String path) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(this.path + "/" + path))) {
            String line;
            Infos out = new Infos();
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("#"))
                    out.add(new ArrayList<String>(Arrays.asList(line.split(";"))));
            }
            return out;
        }
    }

    public <T> void write(String path, Infos.Writable<T> w) throws IOException {
        write(path, w, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public <T> void write(String path, Infos.Writable<T> w, OpenOption... option) throws IOException {
        Files.write(Paths.get(this.path + "/" + path), w.getData(), option);
    }
}










































