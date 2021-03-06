/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ManejadorMatricula;
import modelo.Curso;
import modelo.RegistroEstudiantes;
import modelo.RegistroMatricula;
import modelo.RegistroCursos;

/**
 * TAREA #3 UCR-Programación II-2015
 *
 * @author Bryan Marín Quesada(B23907)
 */
public class GUIMatricula extends Ventana {

    private RegistroMatricula registroMatricula;
    private RegistroEstudiantes registroEstudiantes;
    private RegistroCursos registroCursos;
    private ManejadorMatricula manejadorMatricula;

    public GUIMatricula() {
        initComponents();
        panelBotonesAccion1.init(this);
    }

    public void init(RegistroMatricula registroMatricula, RegistroEstudiantes registroEstudiantes, RegistroCursos registroCursos) {
        this.registroMatricula = registroMatricula;
        this.registroEstudiantes = registroEstudiantes;
        this.registroCursos = registroCursos;
        manejadorMatricula = new ManejadorMatricula(registroMatricula, registroEstudiantes, registroCursos, this);
        setVisible(true);
        setDatosJComboBox();
        setDatosJTable();
        setRegistro();
        setManejador(manejadorMatricula);
    }

    public void setManejador(ManejadorMatricula manejadorMatricula) {
        panelBotonesAccion1.setControlador(manejadorMatricula);
    }

    public void setDatosJComboBox() {
        panelMatricula1.setValoresJComboBox(registroEstudiantes.getVectorEstudiantes());
    }

    public void setDatosJTable() {
        panelMatricula1.setValoresJTable(registroCursos.getMatrizCursos(), Curso.getEtiquetaAtributos());
    }

    public void setRegistro() {
        panelMatricula1.setRegistro(registroCursos, registroEstudiantes);
    }

    public String[] getDatosEstudiantes() {
        return panelMatricula1.getVectorEstudiantes();
    }

    public String[] getDatosCurso() {
        return panelMatricula1.getdatosTabla();
    }

    public String getDatosFecha() {
        return panelMatricula1.setAndGetFecha();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelBotonesAccion1 = new vista.PanelBotonesAccion();
        panelMatricula1 = new vista.PanelMatricula();

        setTitle("eMatrícula UCR");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelMatricula1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(panelBotonesAccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(panelMatricula1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotonesAccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private vista.PanelBotonesAccion panelBotonesAccion1;
    private vista.PanelMatricula panelMatricula1;
    // End of variables declaration//GEN-END:variables
}
