package controlador;

import java.awt.event.ActionEvent;
import java.io.IOException;
import modelo.Estudiante;
import modelo.RegistroEstudiantes;
import org.jdom.Element;
import vista.GUIAdminEstudiante;
import vista.GUIEstudiante;
import vista.GUIMantenimiento;
import vista.PanelBotonesAccion;
import vista.PanelBotonesMantenimiento;
import vista.PanelEstudiante;
import vista.Ventana;

/**
 * TAREA #3 UCR-Programación II-2015
 *
 * @author Bryan Marín Quesada(B23907)
 */
public class ManejadorEstudiante extends Controlador {

    private RegistroEstudiantes registro;
    private GUIAdminEstudiante guiAdminEstudiante;
    private GUIEstudiante guiEstudiante;
    private PanelEstudiante panelEstudiante;
    private GUIMantenimiento gUIMantenimiento;

    public ManejadorEstudiante(RegistroEstudiantes registro, GUIAdminEstudiante guiAdminEstudiante, GUIMantenimiento guiMantenimiento) {
        this.registro = registro;
        this.guiAdminEstudiante = guiAdminEstudiante;
        this.gUIMantenimiento = guiMantenimiento;
    }//Proveniete de GUIAdminEstudiante

    public ManejadorEstudiante(RegistroEstudiantes registro, GUIAdminEstudiante guiAdminEstudiante, GUIEstudiante guiEstudiante, PanelEstudiante panelEstudiante) {
        this.registro = registro;
        this.guiAdminEstudiante = guiAdminEstudiante;
        this.guiEstudiante = guiEstudiante;
        this.panelEstudiante = panelEstudiante;
    }//Proveniente de GUIEstudiante

    public void actionPerformed(ActionEvent evento) {

        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesMantenimiento.BOTON_TYPE_AGREGAR)) {
            GUIEstudiante guiEstudiante = new GUIEstudiante();
            guiEstudiante.init(Ventana.TYPE_VENTANA_AGREGAR, registro, guiAdminEstudiante);
            guiEstudiante.setVisible(true);
            guiEstudiante.setEditable(1);
        }

        if (evento.getActionCommand().equals(PanelBotonesAccion.BOTON_TYPE_ACEPTAR)) {
            if (guiEstudiante.getTipo() == 1) {
                if (panelEstudiante.getStateOfJTextArea() == true) {
                    if (registro.buscarEstudiante(panelEstudiante.getEstudiante().getIdentificador(), 1) == null) {
                        try {
                            registro.setEstudiante(panelEstudiante.getEstudiante());
                            guiAdminEstudiante.setDatosTabla(registro.getMatrizEstudiantes(), Estudiante.getEtiquetasAtributos());
                            panelEstudiante.clean();
                            guiEstudiante.showMessage("Estudiante registrado exitosamente");
                        } catch (IOException ex) {
                            guiAdminEstudiante.showMessage("Error al crear o analizar el documento, verifique e intente de nuevo");
                        }
                    } else {
                        guiAdminEstudiante.showMessage("Existe un estudiante registrado en la base de datos en el identificador: \"" + panelEstudiante.getEstudiante().getIdentificador() + "\", por favor intente de nuevo");
                    }
                } else {
                    guiAdminEstudiante.showMessage("Existen campos vacíos, por favor rellene todos los espacios para ingresar un estudiante");
                }
            } else {
                if (panelEstudiante.getStateOfJTextArea() == true) {
                    try {
                        registro.modificarEstudiante(panelEstudiante.getEstudiante());
                        guiAdminEstudiante.setDatosTabla(registro.getMatrizEstudiantes(), Estudiante.getEtiquetasAtributos());
                        guiEstudiante.dispose();
                        guiAdminEstudiante.showMessage("El estudiante fue modificado exitosamente");
                    } catch (IOException ex) {
                        guiAdminEstudiante.showMessage("Ocurrió un error al modificar al estudiante, por favor inténtelo mas tarde");
                    }
                } else {
                    guiAdminEstudiante.showMessage("Existen campos vacios");
                }
            }//fin else principal if
        }//fin if aceptar

        if (evento.getActionCommand().equals(PanelBotonesMantenimiento.BOTON_TYPE_EDITAR)) {
            if (guiAdminEstudiante.getStateOfRow() != -1) {
                GUIEstudiante guiEstudiante = new GUIEstudiante();
                guiEstudiante.init(Ventana.TYPE_VENTANA_MODIFICAR, registro, guiAdminEstudiante);
                guiEstudiante.setVisible(true);
                guiEstudiante.setEditable(2);
                Estudiante estudiante = (Estudiante) registro.buscarEstudiante(guiAdminEstudiante.getFilaSeleccionada()[0], 1);
                guiEstudiante.setText(estudiante.getNombre(), estudiante.getAñoIngreso(), estudiante.getIdentificador(), estudiante.getCedula());
            } else {
                guiAdminEstudiante.showMessage("Debe seleccionar un estudiante de la tabla para editarlo");
            }
        }//fin if editar

        if (evento.getActionCommand().equals(PanelBotonesMantenimiento.BOTON_TYPE_ELIMINAR)) {
            if (guiAdminEstudiante.getStateOfRow() != -1) {
                try {
                    switch (guiAdminEstudiante.showConfirmDialog("¿Está seguro de eliminar al estudiante:  \"" + guiAdminEstudiante.getFilaSeleccionada()[1] + "\"?", "Advertencia")) {
                        case 0:
                            registro.eliminarEstudiante((Element) registro.buscarEstudiante(guiAdminEstudiante.getFilaSeleccionada()[0], 0));
                            guiAdminEstudiante.setDatosTabla(registro.getMatrizEstudiantes(), Estudiante.getEtiquetasAtributos());
                            break;
                        case 1:
                            break;
                    }
                } catch (IOException ex) {
                    guiAdminEstudiante.showMessage("¡Ocurrió un error al eliminaar el estudiante, por favor inténtelo mas tarde!");
                }
            } else {
                guiAdminEstudiante.showMessage("Debe seleccionar un estudiante el la tabla para eliminarlo");
            }
        }//fin if eliminar

        if (evento.getActionCommand().equals(PanelBotonesMantenimiento.BOTON_TYPE_FILTRAR)) {
            if (!"".equals(guiAdminEstudiante.getTextoClave())) {
                guiAdminEstudiante.setDatosTabla(registro.getMatrizEstudiantesFiltrada(guiAdminEstudiante.getCampoClave(), guiAdminEstudiante.getTextoClave()), Estudiante.getEtiquetasAtributos());
            } else {
                guiAdminEstudiante.showMessage("Debe escribir una \"palabra clave\" para realizar la búsqueda");
            }
        }

        if (evento.getActionCommand().equals(PanelBotonesMantenimiento.BOTON_TYPE_CERRAR)) {
            guiAdminEstudiante.dispose();
        }

    }//fin metodo actionPerformed
}//fin clase
