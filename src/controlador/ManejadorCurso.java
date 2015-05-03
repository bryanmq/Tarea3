/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Curso;
import modelo.RegistroCursos;
import org.jdom.Element;
import vista.GUIAdminCurso;
import vista.GUICurso;
import vista.PanelBotonesAccion;
import vista.PanelBotonesMantenimiento;
import vista.PanelCurso;
import vista.Ventana;

/**
 *
 * @author Bryan
 */
public class ManejadorCurso extends Controlador {

    private RegistroCursos registroCursos;
    private GUIAdminCurso guiAdminCurso;
    private GUICurso guiCurso;
    private PanelCurso panelCurso;

    public ManejadorCurso(RegistroCursos registroCursos, GUIAdminCurso guiAdminCurso) {
        this.registroCursos = registroCursos;
        this.guiAdminCurso = guiAdminCurso;
    }

    public ManejadorCurso(RegistroCursos registroCursos, GUIAdminCurso guiAdminCurso, GUICurso guiCurso, PanelCurso panelCurso) {
        this.registroCursos = registroCursos;
        this.guiAdminCurso = guiAdminCurso;
        this.guiCurso = guiCurso;
        this.panelCurso = panelCurso;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesMantenimiento.BOTON_TYPE_AGREGAR)) {
            GUICurso guiCurso = new GUICurso();
            guiCurso.init(Ventana.TYPE_VENTANA_AGREGAR, registroCursos, guiAdminCurso);
            guiCurso.setVisible(true);
            guiCurso.setEditable(1);
        }

        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesAccion.BOTON_TYPE_ACEPTAR)) {
            if (guiCurso.getTipo() == 1) {
                if (panelCurso.getStateOfJTextArea() == true) {
                    if (registroCursos.buscarCurso(panelCurso.getCurso().getSiglas(), 1) == null) {
                        try {
                            registroCursos.setCurso(panelCurso.getCurso());
                            guiAdminCurso.setDatosTabla(registroCursos.getMatrizCursos(), Curso.getEtiquetaAtributos());
                            panelCurso.clean();
                            guiCurso.showMessage("El curso fue registardo exitosamente");
                        } catch (IOException ex) {
                            guiAdminCurso.showMessage("Hubo un error al registrar el curso, por favor inténtelo mas tarde");
                        }
                    } else {
                        guiCurso.showMessage("Existe un curso registrado con las siglas: \"" + panelCurso.getCurso().getSiglas() + "\", por favor registre un curso con otras siglas distintas");
                    }
                } else {
                    guiCurso.showMessage("Existen campos vacíos, debe rellenar todos los espacios");
                }
            } else {

                try {
                    registroCursos.modificarCurso(panelCurso.getCurso());
                    guiAdminCurso.setDatosTabla(registroCursos.getMatrizCursos(), Curso.getEtiquetaAtributos());
                    guiCurso.dispose();
                    guiCurso.showMessage("El curso fue modificado exitosamente");
                } catch (IOException ex) {
                    guiAdminCurso.showMessage("Hubo un error al modificar el curso, por favor inténtelo mas tarde");
                }
            }
        }

        if (evento.getActionCommand().equals(PanelBotonesMantenimiento.BOTON_TYPE_EDITAR)) {
            if (guiAdminCurso.getStateOfRow() != -1) {
                GUICurso guiCurso = new GUICurso();
                guiCurso.init(Ventana.TYPE_VENTANA_MODIFICAR, registroCursos, guiAdminCurso);
                guiCurso.setVisible(true);
                guiCurso.setEditable(2);
                Curso curso = (Curso) registroCursos.buscarCurso(guiAdminCurso.getFilaSeleccionada()[1], 1);
                guiCurso.setText(curso.getNombre(), curso.getSiglas(), curso.getCreditos());
            } else {
                guiAdminCurso.showMessage("Debe seleccionar un curso de la tabla para editarlo");
            }
        }

        if (evento.getActionCommand().equals(PanelBotonesMantenimiento.BOTON_TYPE_ELIMINAR)) {

            if (guiAdminCurso.getStateOfRow() != -1) {
                switch (guiAdminCurso.showConfirmDialog("¿Está seguro de eliminar el curso:  \"" + guiAdminCurso.getFilaSeleccionada()[0] + "\"?", "Advertencia")) {
                    case 0: {
                        try {
                            registroCursos.eliminarCurso((Element) registroCursos.buscarCurso(guiAdminCurso.getFilaSeleccionada()[1], 0));
                        } catch (IOException ex) {
                            guiAdminCurso.showMessage("Hubo un error al eliminar el curso, por favor inténtelo mas tarde");
                        }
                    }
                    guiAdminCurso.setDatosTabla(registroCursos.getMatrizCursos(), Curso.getEtiquetaAtributos());
                }
            } else {
                guiAdminCurso.showMessage("Debe seleccionar un curso de la tabla para eliminarlo");
            }
        }

        if (evento.getActionCommand().equals(PanelBotonesMantenimiento.BOTON_TYPE_FILTRAR)) {
            if (!"".equals(guiAdminCurso.getTextoClave())) {
                guiAdminCurso.setDatosTabla(registroCursos.getMatrizCursosFiltrada(guiAdminCurso.getCampoClave(), guiAdminCurso.getTextoClave()), Curso.getEtiquetaAtributos());
            } else {
                guiAdminCurso.showMessage("Debe escribir una \"palabra clave\" para realizar la búsqueda");
            }
        }

        if (evento.getActionCommand().equals(PanelBotonesMantenimiento.BOTON_TYPE_CERRAR)) {
            guiAdminCurso.dispose();
        }
    }

}
