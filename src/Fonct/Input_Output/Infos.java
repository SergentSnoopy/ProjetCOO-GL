package Fonct.Input_Output;

import java.util.ArrayList;

public class Infos extends ArrayList<ArrayList<String>> {

    public static abstract class Writable<T> {//transforme une liste d'objets en chaine de caractères pour écriture dans un fichier
        private ArrayList<T> list;

        public Writable(ArrayList<T> l) {
            this.list = l;
        }

        public abstract String parse(T e);

        public byte[] getData() {
            String out = "";
            for (T e : this.list)
                out += this.parse(e) + '\n';
            return out.getBytes();
        }
    }
}