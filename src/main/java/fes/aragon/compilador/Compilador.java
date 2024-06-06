package fes.aragon.compilador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;


public class Compilador {
    private FileReader archivo;
    private String path;
    private ArrayList<String> salida = new ArrayList<>();
    private ArrayList<TError> errores = new ArrayList<TError>();
    public void setArchivo(String path) throws FileNotFoundException {
        this.path = path;
        archivo = new FileReader(path);
    }
    public ArrayList<String> task() throws Exception {
        BufferedReader rdlex = new BufferedReader(archivo);
        AnalizadorLexico lexico= new AnalizadorLexico(rdlex);
        parser par = new parser(lexico);
        par.parse();
        if(par.errores.isEmpty() && lexico.getError().isEmpty()){
            System.out.println("analisis exitoso");
            BufferedReader rd = new BufferedReader(new FileReader(path));;
            String renglon;
            String[] cad;
            try {
                while ((renglon = rd.readLine()) != null) {
                    salida.add(renglon);
                }
            }catch(Exception e){
                    e.printStackTrace();
            }
            return salida;
            }else {
            salida.addAll(par.getErrores());
            salida.addAll(lexico.getError());
            return salida;
        }

    }
}