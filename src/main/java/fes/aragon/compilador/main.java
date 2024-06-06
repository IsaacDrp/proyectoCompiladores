package fes.aragon.compilador;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws Exception {
        ArrayList<String> out = new ArrayList<>();
        Compilador comp = new Compilador();
        comp.setArchivo("fuente.fes");
        out = comp.task();
        for (String s : out) System.out.println(s);
    }
}
