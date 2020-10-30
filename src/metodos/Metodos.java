package metodos;
/** import's**/
import Conn.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos extends Conectar{
    private String base;
    private String mensaje = "";
    
    public Metodos (String base){
        super (base);
    	}
    
  //============================ Ingreso de datos ===============================================
    
    //=================Tabla===============
    

       //========= INGRESAR PRODUCTO ===============
  public boolean ingreso(String descripcion, int costo, int venta, int stock){
		PreparedStatement cons_pre = null;
		
		try{
			String consulta = ("Insert Into producto (pro_descripcion, pro_precio_costo, pro_precio_venta, pro_stock) Value (?,?,?,?)");
			cons_pre = Conecta().prepareStatement(consulta);
				
			cons_pre.setString(1, descripcion);
			cons_pre.setInt(2, costo);
			cons_pre.setInt(3, venta);
			cons_pre.setInt(4, stock);
				
			cons_pre.executeUpdate();
				
			return true;
				
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"ta malo el añañin"+e);
			return false;			
		}
               }
//========================== MODIFICA DE DATOS ===============================
	
	public boolean Modifica(String descripcion, int costo, int venta, int stock){
		PreparedStatement cons_pre = null;
			
		try{
			String consulta = ("Update producto Set (pro_descripcion, pro_precio_costo, pro_precio_venta, pro_stock) Value (?,?,?,?)");
				
			cons_pre = Conecta().prepareStatement(consulta);
				
			cons_pre.setString(1, descripcion);
			cons_pre.setInt(2, costo);
			cons_pre.setInt(3, venta);
			cons_pre.setInt(4, stock);
		
			cons_pre.executeUpdate();
			return true;
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"ta malo el modificar"+e);
			return false;
		}
        }
     //========================= BUSCA DATOS ==================================
		public boolean Elimina(int codigo, String producto, int costo, int valor, int stock){
			PreparedStatement consul_pre = null;
			
				
			try{
				String consulta = ("SELECT pro_codigo FROM producto WHERE pro_codigo = ?");
				
				consul_pre = Conecta().prepareStatement(consulta);
				consul_pre.setInt(1, codigo);
                                consul_pre.setString(2, producto);
                                consul_pre.setInt(3, costo);
                                consul_pre.setInt(4, valor);
                                consul_pre.setInt(5, stock);
					consul_pre.executeQuery();
					return true;	
				
								
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
				return false;
			}
		}
    
}