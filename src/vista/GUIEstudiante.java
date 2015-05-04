/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ManejadorEstudiante;
import modelo.RegistroEstudiantes;

/**
 * TAREA #3 UCR-Programación II-2015
 *
 * @author Bryan Marín Quesada(B23907)
 */
public class GUIEstudiante extends Ventana {

    private int tipo;
    private RegistroEstudiantes registro;
    private GUIAdminEstudiante gUIAdminEstudiante;
    private PanelEstudiante panelEstudiante;

    /**
     * Creates new form GUIEstudiante
     */
    public GUIEstudiante() {
        initComponents();
        panelBotonesAccion1.init(this);
    }

    public void init(int tipo, RegistroEstudiantes registro, GUIAdminEstudiante gUIAdminEstudiante) {
        this.tipo = tipo;
        this.registro = registro;
        this.gUIAdminEstudiante = gUIAdminEstudiante;
        ManejadorEstudiante manejador = new ManejadorEstudiante(registro, gUIAdminEstudiante, this, panelEstudiante1);
        panelBotonesAccion1.setControlador(manejador);
    }

    public int getTipo() {
        return tipo;
    }

    public void setEditable(int index) {
        if (index == 1) {
            panelEstudiante1.setEditable(true);
        } else {
            panelEstudiante1.setEditable(false);
        }
    }

    public void setText(String nombre, int añoIngreso, String identificador, String cedula) {
        panelEstudiante1.setText(nombre, añoIngreso, identificador, cedula);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelEstudiante1 = new vista.PanelEstudiante();
        panelBotonesAccion1 = new vista.PanelBotonesAccion();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Estudiantes");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEstudiante1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBotonesAccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBotonesAccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private vista.PanelBotonesAccion panelBotonesAccion1;
    private vista.PanelEstudiante panelEstudiante1;
    // End of variables declaration//GEN-END:variables
}
