/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.Matricula;
import modelo.RegistroCursos;
import modelo.RegistroEstudiantes;
import modelo.RegistroMatricula;
import vista.GUIMatricula;
import vista.PanelBotonesAccion;
import vista.PanelMatricula;

/**
 *
 * @author Bryan
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
                    Matricula matricula = new Matricula(gUIMatricula.getDatosEstudiantes(), "", gUIMatricula.getDatosCurso());
                    registroMatricula.setMatricula(matricula);
                    gUIMatricula.showMessage("Matricula Realizada exitosamente");
                    gUIMatricula.dispose();
                    gUIMatricula = new GUIMatricula();
                    gUIMatricula.init(registroMatricula, registroEstudiantes, registroCursos);
                    gUIMatricula.setVisible(true);

                } else {
                    gUIMatricula.showMessage("Debe seleccionar al menos un curso para realizar la matricula");
                }
            } else {
                gUIMatricula.showMessage("Debe seleccionar al menos un estudiante para realizar la matricula");
            }
        }
    }

}
