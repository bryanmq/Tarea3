/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Bryan
 */
public class GUIMantenimientoRegistro extends Ventana {

    /**
     * Creates new form GUIMantenimientoRegistro
     */
    public GUIMantenimientoRegistro() {
        initComponents();
        setVisible(true);
        panelBotonesAccion1.init(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMantenimientoRegistro1 = new vista.PanelMantenimientoRegistro();
        panelBotonesAccion1 = new vista.PanelBotonesAccion();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMantenimientoRegistro1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelBotonesAccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMantenimientoRegistro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotonesAccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setInformacion(String datos){
        panelMantenimientoRegistro1.setDatos(datos);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.PanelBotonesAccion panelBotonesAccion1;
    private vista.PanelMantenimientoRegistro panelMantenimientoRegistro1;
    // End of variables declaration//GEN-END:variables
}
