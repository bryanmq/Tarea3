package vista;

import controlador.Controlador;

/**
 * TAREA #3 UCR-Programación II-2015
 *
 * @author Bryan Marín Quesada(B23907)
 */
public class PanelBotonesMantenimiento extends javax.swing.JPanel {

    public static String BOTON_TYPE_AGREGAR = "Agregar";
    public static String BOTON_TYPE_EDITAR = "Editar";
    public static String BOTON_TYPE_CERRAR = "Cerrar";
    public static String BOTON_TYPE_FILTRAR = "Filtrar";
    public static String BOTON_TYPE_ELIMINAR = "Eliminar";

    public PanelBotonesMantenimiento() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbAgregar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jlCampoClave = new javax.swing.JLabel();
        jcCampoClave = new javax.swing.JComboBox();
        jlTextoClave = new javax.swing.JLabel();
        jtTextoClave = new javax.swing.JTextField();
        jbFiltrar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(56, 52, 221));

        jbAgregar.setBackground(new java.awt.Color(51, 255, 51));
        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jbAgregar.setToolTipText("Agregar");
        jbAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAgregar.setMaximumSize(new java.awt.Dimension(54, 54));
        jbAgregar.setPreferredSize(new java.awt.Dimension(54, 54));
        jbAgregar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbEditar.setBackground(new java.awt.Color(255, 204, 0));
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        jbEditar.setToolTipText("Modificar");
        jbEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEditar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jbEliminar.setBackground(new java.awt.Color(255, 102, 51));
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        jbEliminar.setToolTipText("Eliminar");
        jbEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEliminar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jlCampoClave.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlCampoClave.setForeground(java.awt.Color.white);
        jlCampoClave.setText("Filtrar por:");

        jcCampoClave.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlTextoClave.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlTextoClave.setForeground(java.awt.Color.white);
        jlTextoClave.setText("Texto Clave:");

        jbFiltrar.setBackground(new java.awt.Color(51, 204, 255));
        jbFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/funnel.png"))); // NOI18N

        jbSalir.setBackground(new java.awt.Color(204, 204, 255));
        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/outside.png"))); // NOI18N
        jbSalir.setToolTipText("Salir");
        jbSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbSalir.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlCampoClave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcCampoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jlTextoClave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCampoClave)
                    .addComponent(jcCampoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTextoClave)
                    .addComponent(jtTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Este método permite agregar los campos clave por los cuales puede filtrar
     * el buscador
     *
     * @param camposClave
     */
    public void addCamposClave(String[] camposClave) {
        jcCampoClave.setModel(new javax.swing.DefaultComboBoxModel(camposClave));
        jbAgregar.setActionCommand(BOTON_TYPE_AGREGAR);
        jbEditar.setActionCommand(BOTON_TYPE_EDITAR);
        jbEliminar.setActionCommand(BOTON_TYPE_ELIMINAR);
        jbFiltrar.setActionCommand(BOTON_TYPE_FILTRAR);
        jbSalir.setActionCommand(BOTON_TYPE_CERRAR);
    }

    public void setControladorMantenimiento(Controlador manejador) {
        jbAgregar.addActionListener(manejador);
        jbEliminar.addActionListener(manejador);
        jbEditar.addActionListener(manejador);
        jbFiltrar.addActionListener(manejador);
        jbSalir.addActionListener(manejador);
    }

    public String getCampoClave() {
        return jcCampoClave.getSelectedItem().toString();
    }

    public String getTextoClave() {
        return jtTextoClave.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbFiltrar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox jcCampoClave;
    private javax.swing.JLabel jlCampoClave;
    private javax.swing.JLabel jlTextoClave;
    private javax.swing.JTextField jtTextoClave;
    // End of variables declaration//GEN-END:variables

}
