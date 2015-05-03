/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.Estudiante;

/**
 *
 * @author ronald
 */
public class PanelEstudiante extends javax.swing.JPanel {

    /**
     * Creates new form PanelEstudiante
     */
    public PanelEstudiante() {
        initComponents();
    }
    
    public void setEstudiante(Estudiante estudiante) {
        jtIdentificador.setText(estudiante.getIdentificador());
        jtNombre.setText(estudiante.getNombre());
        jtCedula.setText(estudiante.getCedula());
        jtAnoIngreso.setText(Integer.toString(estudiante.getAñoIngreso()));
    }
    
    public Estudiante getEstudiante() {
        return new Estudiante(jtNombre.getText(), Integer.parseInt(jtAnoIngreso.getText()), jtIdentificador.getText(), jtCedula.getText());
    }
    
    public boolean getStateOfJTextArea() {
        return !jtAnoIngreso.getText().equals("") && !jtCedula.getText().equals("") && !jtIdentificador.getText().equals("") && !jtNombre.getText().equals("");
    }
    
    public void clean() {
        jtAnoIngreso.setText("");
        jtCedula.setText("");
        jtIdentificador.setText("");
        jtNombre.setText("");
    }
    
    public void setText(String nombre, int añoIngreso, String identificador, String cedula) {
        jtAnoIngreso.setText(Integer.toString(añoIngreso));
        jtCedula.setText(cedula);
        jtIdentificador.setText(identificador);
        jtNombre.setText(nombre);
    }
    
    public void setEditable(boolean action) {
        if (action==true) {
            jtIdentificador.setEditable(true);
            jtIdentificador.setEnabled(true);
        } else {
            jtIdentificador.setEditable(false);
            jtIdentificador.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlIdentificador = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlCedula = new javax.swing.JLabel();
        jlAnoIngreso = new javax.swing.JLabel();
        jtIdentificador = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtCedula = new javax.swing.JTextField();
        jtAnoIngreso = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 153, 255));

        jlIdentificador.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jlIdentificador.setText("Identificador");

        jlNombre.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jlNombre.setText("Nombre");

        jlCedula.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jlCedula.setText("Cédula");

        jlAnoIngreso.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jlAnoIngreso.setText("Año Ingreso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlIdentificador)
                    .addComponent(jlNombre)
                    .addComponent(jlCedula)
                    .addComponent(jlAnoIngreso))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtAnoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdentificador)
                    .addComponent(jtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAnoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtAnoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlAnoIngreso;
    private javax.swing.JLabel jlCedula;
    private javax.swing.JLabel jlIdentificador;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JTextField jtAnoIngreso;
    private javax.swing.JTextField jtCedula;
    private javax.swing.JTextField jtIdentificador;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}