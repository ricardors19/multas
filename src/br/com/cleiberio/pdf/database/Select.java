package br.com.cleiberio.pdf.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {
	public static boolean isExiste(String r, String d){
		boolean retorno = false;
		try {
            Connection con = Conecta.connectDB();
            PreparedStatement prstmt;
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM tabela WHERE rua = ? AND data = ?";
            prstmt = con.prepareStatement(query);
            prstmt.setString(1, r);
            prstmt.setString(2, d);
            
            ResultSet rs = prstmt.executeQuery();
            
            if(rs.next()){
            	retorno = true;
            }
            
            prstmt.close();
            stmt.close();
            con.close();
        } catch (Exception e) { e.printStackTrace(); }
        
        return retorno;
    }
	
	public static String getDate(){
		String date = "";
		try {
            Connection con = Conecta.connectDB();
            PreparedStatement prstmt;
            Statement stmt = con.createStatement();
            String query = "SELECT NOW() as data";
            prstmt = con.prepareStatement(query);
            
            ResultSet rs = prstmt.executeQuery();
            
            if(rs.next()){
            	date = rs.getString("data");
            	date = date.substring(8, 10) + "/" + date.substring(5, 7) + "/" + date.substring(0, 4);
            }
            
            prstmt.close();
            stmt.close();
            con.close();
        } catch (Exception e) { e.printStackTrace(); }
        
        return date;
    }
}
