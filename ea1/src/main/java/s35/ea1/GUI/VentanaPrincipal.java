
package s35.ea1.GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import s35.ea1.database.DBConnection;

public class VentanaPrincipal extends JFrame{

    private final DBConnection dbConnection;

    public VentanaPrincipal(){
        this.dbConnection = new DBConnection();
        setTitle("Gestion de Personal");
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icon.png"));
        setIconImage(icon.getImage());
        setSize(500, 500);
    }

    public void initComponents(){

    }
    
    // public void llenarTabla() {
    //     DefaultTableModel model = (DefaultTableModel) tabla.getModel();
    //     List<Articulo> list = IO.obtenerListaArticulos();
    //     model.setRowCount(0);
    //     for (Articulo x : list) {
    //         model.addRow(x.toArray());
    //     }
    // }

    public void closeChild(JFrame child){
        child.setVisible(false);
        //dispatch
    }
    
}
