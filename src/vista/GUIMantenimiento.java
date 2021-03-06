package vista;

import controlador.Controlador;

/**
 * TAREA #3 UCR-Programación II-2015
 *
 * @author Bryan Marín Quesada(B23907)
 */
public class GUIMantenimiento extends Ventana {

    public GUIMantenimiento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelListado2 = new vista.PanelListado();
        panelBotonesMantenimiento2 = new vista.PanelBotonesMantenimiento();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelListado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBotonesMantenimiento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBotonesMantenimiento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelListado2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setControlador(Controlador manejador) {
        panelBotonesMantenimiento2.setControladorMantenimiento(manejador);
    }

    public void setCamposClave(String[] CamposClave) {
        panelBotonesMantenimiento2.addCamposClave(CamposClave);
    }

    public void setDatosTabla(String datos[][], String etiquetas[]) {
        panelListado2.setValores(datos, etiquetas);
    }

    public String[] getFilaSeleccionada() {
        return panelListado2.getdatosFila();
    }

    public int getStateOfRow() {
        return panelListado2.getFila();
    }

    public String getCampoClave() {
        return panelBotonesMantenimiento2.getCampoClave();
    }

    public String getTextoClave() {
        return panelBotonesMantenimiento2.getTextoClave();
    }

    public void uptDate() {
        this.validate();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.PanelBotonesMantenimiento panelBotonesMantenimiento2;
    private vista.PanelListado panelListado2;
    // End of variables declaration//GEN-END:variables
}
