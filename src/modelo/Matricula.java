package modelo;

/**
 * TAREA #3 UCR-Programación II-2015
 *
 * @author Bryan Marín Quesada(B23907)
 */
public class Matricula {

    private String fecha;
    private String arrayEstudiantes[];
    private String arrayCurso[];
    private static String[] atributos = {"Curso", "Estudiantes ", "Fecha de matrícula"};

    public Matricula(String estudiante[], String fecha, String curso[]) {
        setEstudiantes(estudiante);
        setFecha(fecha);
        setCurso(curso);
    }

    public static String[] getEtiquetasAtributos() {
        return atributos;
    }

    public String getAtributo(int numeroAtributo) {
        switch (numeroAtributo) {
            case 0:
                return getCurso();
            case 1:
                return getEstudiantes();
            case 2:
                return getFecha();
            default:
                return null;
        }
    }

    public static int getConteoAtributos() {
        return atributos.length;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setEstudiantes(String estudiantes[]) {
        arrayEstudiantes = estudiantes;
    }

    public String getEstudiantes() {
        String finalHTLM = "<html>";
        String separador = "<br>";
        String informacion = "<html>";//Este formato html se realiza para que existan saltos de linea en el JTable debido a que con "\n" no sirve
        for (int i = 0; i < arrayEstudiantes.length; i++) {
            if (arrayEstudiantes[i] != null) {
                informacion += separador + arrayEstudiantes[i];
            }
        }
        return informacion + finalHTLM;
    }

    public void setCurso(String c[]) {
        this.arrayCurso = c;
    }

    public String getCurso() {
        return arrayCurso[0];
    }

    public String getInfo() {
        return "\nCurso: " + getCurso() + "\n\nEstudiantes: \n" + getEstudiantes() + "\n>>Fecha de matrícula: " + getFecha() + "\n__________________________________________________";
    }

}
