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
import modelo.Matricula;
import modelo.RegistroCursos;
import modelo.RegistroEstudiantes;
import modelo.RegistroMatricula;
import vista.GUIMatricula;
import vista.PanelBotonesAccion;

/**
 * TAREA #3 UCR-Programación II-2015
 *
 * @author Bryan Marín Quesada(B23907)
 */
public class ManejadorMatricula extends Controlador {

    private RegistroMatricula registroMatricula;
    private RegistroEstudiantes registroEstudiantes;
    private RegistroCursos registroCursos;
    private GUIMatricula gUIMatricula;

    public ManejadorMatricula(RegistroMatricula registroMatricula, RegistroEstudiantes registroEstudiantes, RegistroCursos registroCursos, GUIMatricula gUIMatricula) {
        this.registroMatricula = registroMatricula;
        this.registroEstudiantes = registroEstudiantes;
        this.registroCursos = registroCursos;
        this.gUIMatricula = gUIMatricula;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(PanelBotonesAccion.BOTON_TYPE_ACEPTAR)) {
            if (gUIMatricula.getDatosEstudiantes()[0] != null) {
                if (gUIMatricula.getDatosCurso()[0] != null) {
                    try {
                        Matricula matricula = new Matricula(gUIMatricula.getDatosEstudiantes(), gUIMatricula.getDatosFecha(), gUIMatricula.getDatosCurso());
                        registroMatricula.setMatricula(matricula);
                        gUIMatricula.showMessage("Matricula Realizada exitosamente");
                        gUIMatricula.dispose();
                        gUIMatricula = new GUIMatricula();
                        gUIMatricula.init(registroMatricula, registroEstudiantes, registroCursos);
                        gUIMatricula.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(ManejadorMatricula.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    gUIMatricula.showMessage("Debe seleccionar al menos un curso para realizar la matricula");
                }
            } else {
                gUIMatricula.showMessage("Debe seleccionar al menos un estudiante para realizar la matricula");
            }
        }
    }

}
