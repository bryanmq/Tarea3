/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ManejadorCurso;
import modelo.Curso;
import modelo.RegistroCursos;

/**
 * TAREA #3 UCR-Programación II-2015
 *
 * @author Bryan Marín Quesada(B23907)
 */
public class GUIAdminCurso extends GUIMantenimiento {

    private RegistroCursos registroCursos;

    public void setRegistroCursos(RegistroCursos registroCursos) {
        this.registroCursos = registroCursos;
    }

    public void init() {
        setDatosTabla(registroCursos.getMatrizCursos(), Curso.getEtiquetaAtributos());
        setCamposClave(Curso.getEtiquetaAtributos());
        ManejadorCurso manejadorCurso = new ManejadorCurso(registroCursos, this);
        setControlador(manejadorCurso);
        setTitle("Mantenimiento de \"Cursos\"");
    }

}
