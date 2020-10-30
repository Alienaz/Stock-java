package Conn;
import java.sql.*;
import javax.swing.*;

public class Conectar {
	private String user = "root";
	private String pass = "";
	private String host = "localhost";
	private String port = "3306";
	private String clas = "com.mysql.jdbc.Driver";
	private String url;
	private String base;
	private Connection conecta;
	
	public Conectar(String base){
		this.base = base;
		this.url = "jdbc:mysql://"+host+":"+port+"/"+base;
		
		try {
			Class.forName(clas);
			conecta = DriverManager.getConnection(url,user,pass);
			
		} catch (ClassNotFoundException  e){
			JOptionPane.showMessageDialog(null, "error 1 "+e);
		
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, "error en la base "+e);	
		}
	}
	
	public Connection Conecta(){
		return conecta;
	}
	
	public Connection Deconecta(){
		return conecta = null;
	}
}
