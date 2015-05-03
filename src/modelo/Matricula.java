
package modelo;
/**
 * TAREA #2
 * UCR-Programación II-2015
 * @author Bryan Marín Quesada(B23907)
 */
public class Matricula {
    
    private String fecha;
    private String arrayEstudiantes[];
    private String arrayCurso[];

    public Matricula(String estudiante[], String fecha, String curso[]) {
        setEstudiantes(estudiante);
        setFecha(fecha);
        setCurso(curso);
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setEstudiantes(String estudiantes[]){
        arrayEstudiantes=estudiantes;
    }
    
    public String getEstudiantes(){
        String informacion="";
        for(int i=0; i<arrayEstudiantes.length; i++){
            if(arrayEstudiantes[i]!=null){
                informacion+="           -"+arrayEstudiantes[i]+"\n";
            }
        }
        return informacion;
    }
    
    public void setCurso(String c[]){
        this.arrayCurso=c;
    }
    
    public String getCurso(){
       return arrayCurso[0];
    }
    
    public String getInfo(){
        return "\nCurso: "+getCurso()+"\n\nEstudiantes: \n"+getEstudiantes()+"\n>>Fecha de matrícula: "+getFecha()+"\n__________________________________________________";    
    }
    
    
}
