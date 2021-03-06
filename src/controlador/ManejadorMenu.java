/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Curso;
import modelo.Estudiante;
import modelo.Matricula;
import modelo.RegistroCursos;
import modelo.RegistroEstudiantes;
import modelo.RegistroMatricula;
import org.jdom.JDOMException;
import vista.GUIAdminCurso;
import vista.GUIAdminEstudiante;
import vista.GUIMantenimientoRegistro;
import vista.GUIMatricula;
import vista.Menu;

/**
 * TAREA #3 UCR-Programación II-2015
 *
 * @author Bryan Marín Quesada(B23907)
 */
public class ManejadorMenu extends Controlador {

    private RegistroEstudiantes registroEstudiantes;
    private RegistroCursos registroCursos;
    private RegistroMatricula registroMatricula;

    public ManejadorMenu(RegistroEstudiantes registroEstudiantes, RegistroCursos registroCursos, RegistroMatricula registroMatricula) {
        this.registroEstudiantes = registroEstudiantes;
        this.registroCursos = registroCursos;
        this.registroMatricula = registroMatricula;
        stateOfDocumentXML();
    }

    public void stateOfDocumentXML() {
        try {
            if (RegistroEstudiantes.analizarDirectorio() == false) {
                RegistroEstudiantes.crearDocumento();
                registroEstudiantes = RegistroEstudiantes.abrirDocumento();
            } else {
                registroEstudiantes = RegistroEstudiantes.abrirDocumento();
            }

            if (RegistroCursos.analizarDirectorio() == false) {
                RegistroCursos.crearDocumento();
                registroCursos = RegistroCursos.abrirDocumento();
            } else {
                registroCursos = RegistroCursos.abrirDocumento();
            }

            if (RegistroMatricula.analizarDirectorio() == false) {
                RegistroMatricula.crearDocumento();
                registroMatricula = RegistroMatricula.abrirDocumento();
            } else {
                registroMatricula = RegistroMatricula.abrirDocumento();
            }

        } catch (IOException | JDOMException ex) {
            Logger.getLogger(ManejadorMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(Menu.ITEM_ESTUDIANTE)) {
            GUIAdminEstudiante guiAdminEstudiante = new GUIAdminEstudiante();
            guiAdminEstudiante.setRegistroEstudiantes(registroEstudiantes);
            guiAdminEstudiante.init();
            guiAdminEstudiante.setVisible(true);
        }

        if (event.getActionCommand().equals(Menu.ITEM_CURSO)) {
            GUIAdminCurso guiAdminCurso = new GUIAdminCurso();
            guiAdminCurso.setRegistroCursos(registroCursos);
            guiAdminCurso.init();
            guiAdminCurso.setVisible(true);
        }

        if (event.getActionCommand().equals(Menu.ITEM_MATRICULA)) {
            GUIMatricula guiMatricula = new GUIMatricula();
            guiMatricula.init(registroMatricula, registroEstudiantes, registroCursos);
        }

        if (event.getActionCommand().equals("Registro Estudiantes")) {
            GUIMantenimientoRegistro gUIMantenimientoRegistro = new GUIMantenimientoRegistro();
            gUIMantenimientoRegistro.setTitle("Registro Estudiantes");
            gUIMantenimientoRegistro.setDatosTabla(registroEstudiantes.getMatrizEstudiantes(), Estudiante.getEtiquetasAtributos());
        }

        if (event.getActionCommand().equals("Registro Cursos")) {
            GUIMantenimientoRegistro gUIMantenimientoRegistro = new GUIMantenimientoRegistro();
            gUIMantenimientoRegistro.setTitle("Registro Cursos");
            gUIMantenimientoRegistro.setDatosTabla(registroCursos.getMatrizCursos(), Curso.getEtiquetaAtributos());
        }

        if (event.getActionCommand().equals("Registro Matrícula")) {
            GUIMantenimientoRegistro gUIMantenimientoRegistro = new GUIMantenimientoRegistro();
            gUIMantenimientoRegistro.setTamaño();
            gUIMantenimientoRegistro.setTitle("Registro Matrícula");
            gUIMantenimientoRegistro.setDatosTabla(registroMatricula.getMatrizMatrícula(), Matricula.getEtiquetasAtributos());
        }
    }//fin metodo actionPerformed

}
