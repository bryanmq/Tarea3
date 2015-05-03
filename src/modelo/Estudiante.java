/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ronald
 */
public class Estudiante {

    private String nombre;
    private int añoIngreso;
    private String identificador;
    private String cedula;
    private static String[] atributos = {"Identificador", "Nombre", "Año Ingreso", "Cédula"};

    public Estudiante() {
    }

    public Estudiante(String nombre, int añoIngreso, String identificador, String cedula) {
        this.nombre = nombre;
        this.añoIngreso = añoIngreso;
        this.identificador = identificador;
        this.cedula = cedula;
    }

    public int getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(int añoIngreso) {
        this.añoIngreso = añoIngreso;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String[] getEtiquetasAtributos() {
        return atributos;
    }

    public String getAtributo(int numeroAtributo) {
        switch (numeroAtributo) {
            case 0:
                return getIdentificador();
            case 1:
                return getNombre();
            case 2:
                return Integer.toString(getAñoIngreso());
            case 3:
                return getCedula();
            default:
                return null;
        }
    }
    
    public static int getConteoAtributos(){
      return  atributos.length;
    }
    
    public String getInformacion(){
        return "\nIdentificador:"+ getIdentificador()+ "\nNombre:" + getNombre() + "\nAño Ingreso:"+getAñoIngreso()+ "\nCédula:"+getCedula();
    }
    
}
