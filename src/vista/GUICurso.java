package vista;

import controlador.ManejadorCurso;
import modelo.RegistroCursos;

/**
 * TAREA #3 UCR-Programación II-2015
 *
 * @author Bryan Marín Quesada(B23907)
 */
public class GUICurso extends Ventana {

    private int tipo;
    private RegistroCursos registroCursos;
    private GUIAdminCurso guiAdminCurso;

    public GUICurso() {
        initComponents();
        panelBotonesAccion1.init(this);
    }

    public void init(int tipo, RegistroCursos registroCursos, GUIAdminCurso guiAdminCurso) {
        this.tipo = tipo;
        this.registroCursos = registroCursos;
        this.guiAdminCurso = guiAdminCurso;
        ManejadorCurso manejadorCurso = new ManejadorCurso(registroCursos, guiAdminCurso, this, panelCurso1);
        panelBotonesAccion1.setControlador(manejadorCurso);
    }

    public void setText(String nombre, String siglas, String creditos) {
        panelCurso1.setText(nombre, siglas, creditos);
    }

    public int getTipo() {
        return tipo;
    }

    public void setEditable(int index) {
        if (index == 1) {
            panelCurso1.setEditable(1);
        } else {
            panelCurso1.setEditable(2);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelBotonesAccion1 = new vista.PanelBotonesAccion();
        panelCurso1 = new vista.PanelCurso();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Cursos");
        setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelBotonesAccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(panelCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBotonesAccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private vista.PanelCurso panelCurso1;
    // End of variables declaration//GEN-END:variables
}
