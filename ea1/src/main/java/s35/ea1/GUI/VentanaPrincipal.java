package s35.ea1.GUI;

import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import s35.ea1.DAO.FuncionarioDAO;
import s35.ea1.DAO.GrupoFamiliarDAO;
import s35.ea1.DAO.InformacionAcademicaDAO;
import s35.ea1.Transfers.Funcionario;
import s35.ea1.Transfers.GrupoFamiliar;
import s35.ea1.Transfers.InformacionAcademica;
import s35.ea1.database.DBConnection;

public class VentanaPrincipal extends javax.swing.JFrame {

    private final DBConnection dbConnection;
    private final FuncionarioDAO funcionarios;
    private final GrupoFamiliarDAO gruposFamiliares;
    private final InformacionAcademicaDAO informacionAcademica;

    public VentanaPrincipal() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dbConnection = new DBConnection();
        this.funcionarios = new FuncionarioDAO(dbConnection);
        this.gruposFamiliares = new GrupoFamiliarDAO(dbConnection);
        this.informacionAcademica = new InformacionAcademicaDAO(dbConnection);
        setTitle("Gestion de Personal");
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icon.png"));
        setIconImage(icon.getImage());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        read = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        seleccion = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        create = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.setFont(new java.awt.Font("FiraCode Nerd Font SemBd", 0, 12)); // NOI18N

        read.setText("Ver Registros");
        read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readActionPerformed(evt);
            }
        });
        jPanel2.add(read);

        delete.setText("Eliminar registro");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 480, 40));

        jPanel4.setForeground(new java.awt.Color(51, 51, 51));
        jPanel4.setFont(new java.awt.Font("FiraCode Nerd Font SemBd", 0, 12)); // NOI18N

        jLabel1.setText("Selecciona la tabla que quieres gestionar:");
        jPanel4.add(jLabel1);

        seleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionarios", "GrupoFamiliar", "InformacionAcademica" }));
        jPanel4.add(seleccion);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 480, 60));

        jPanel3.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.setFont(new java.awt.Font("FiraCode Nerd Font SemBd", 0, 12)); // NOI18N

        update.setText("Editar Registro");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel3.add(update);

        create.setText("Añadir Registro");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        jPanel3.add(create);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 480, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readActionPerformed
        new Table(this, false, "Tabla " + seleccion.getSelectedItem().toString(), GetSelectedTableData());
    }//GEN-LAST:event_readActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String res = JOptionPane.showInputDialog(this, "Ingresa la ID del registro que quieres eliminar.", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
        if (!res.trim().isEmpty()) {
            try {
                DeleteSelectedTableRow(Integer.parseInt(res));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ingresa una ID Valida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingresa una ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        String res = JOptionPane.showInputDialog(this, "Ingresa la ID del registro que quieres eliminar.", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
        switch (seleccion.getSelectedItem().toString()) {
            case "Funcionarios":
                Funcionario aux = null;
                if (!res.trim().isEmpty()) {
                    try {
                        aux = funcionarios.findById(Integer.parseInt(res));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Ingresa una ID Valida", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ingresa una ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (aux != null) {
                    new FormFuncionario(this, true, aux, funcionarios);
                }
                break;
            case "GrupoFamiliar":
                GrupoFamiliar aux2 = null;
                if (!res.trim().isEmpty()) {
                    try {
                        aux2 = gruposFamiliares.findById(Integer.parseInt(res));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Ingresa una ID Valida", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ingresa una ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (aux2 != null) {
                    new FormGrupoFamiliar(this, true, aux2, gruposFamiliares);
                }
                break;
            case "InformacionAcademica":
                InformacionAcademica aux3 = null;
                if (!res.trim().isEmpty()) {
                    try {
                        aux3 = informacionAcademica.findById(Integer.parseInt(res));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Ingresa una ID Valida", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ingresa una ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (aux3 != null) {
                    new FormInformacionAcademica(this, true, aux3, informacionAcademica);
                }
                break;
        }
    }//GEN-LAST:event_updateActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed

        switch (seleccion.getSelectedItem().toString()) {
            case "Funcionarios":
                new FormFuncionario(this, false, null, funcionarios);
                break;
            case "GrupoFamiliar":
                new FormGrupoFamiliar(this, false, null, gruposFamiliares);
                break;
            case "InformacionAcademica":
                new FormInformacionAcademica(this, false, null, informacionAcademica);
                break;
        }
    }//GEN-LAST:event_createActionPerformed

    private void DeleteSelectedTableRow(int id) {
        boolean res = false;
        switch (seleccion.getSelectedItem().toString()) {
            case "Funcionarios":
                res = funcionarios.delete(id);
            case "GrupoFamiliar":
                res = gruposFamiliares.delete(id);
            case "InformacionAcademica":
                res = informacionAcademica.delete(id);
        }
        if (res) {
            JOptionPane.showMessageDialog(this, "Accion exitosa", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo realizar la accion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private List<Map<String, Object>> GetSelectedTableData() {
        switch (seleccion.getSelectedItem().toString()) {
            case "Funcionarios":
                return funcionarios.findAllMap();
            case "GrupoFamiliar":
                return gruposFamiliares.findAllMap();
            case "InformacionAcademica":
                return informacionAcademica.findAllMap();
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton read;
    private javax.swing.JComboBox<String> seleccion;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
