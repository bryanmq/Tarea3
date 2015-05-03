/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Bryan
 */
public class Curso{

    private String nombre, siglas, creditos;
    private static String etiquetaAtributos[]={"Nombre","Siglas","Créditos"};

    public Curso(String nombre, String siglas, String creditos) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.creditos = creditos;
    }

    public static int size(){
            return etiquetaAtributos.length;
    }

    public static String[] getEtiquetaAtributos(){
            return etiquetaAtributos;
    }

    public String getAtributos(int indice){
        switch (indice) {
            case 0:
                    return getNombre();
            case 1:
                    return getSiglas();
            case 2:
                    return getCreditos();
            default: 
                    return null;
        }
    }

    public String getNombre() {
            return nombre;
    }

    public void setNombre(String nombre) {
            this.nombre = nombre;
    }

    public String getSiglas() {
            return siglas;
    }

    public void setSiglas(String siglas) {
            this.siglas = siglas;
    }
    
    public String getCreditos() {
            return creditos;
    }

    public void setCreditos(String creditos) {
            this.creditos = creditos;
    }
   
    public String getInfo(){
        return "\nCurso: "+getNombre()+"\nSilgas: "+getSiglas()+"\nCréditos: "+getCreditos()+"\n";
    }

	
}

