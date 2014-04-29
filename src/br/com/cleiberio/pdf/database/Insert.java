package br.com.cleiberio.pdf.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Insert {
	public static void insert(String r, String d){
		try {
			String[] data = d.split("/");
			d = data[2] + "-" + data[1] + "-" + data[0];
			
			if(!Select.isExiste(r, d)){
	            Connection con = Conecta.connectDB();
	            PreparedStatement prstmt;
	            Statement stmt = con.createStatement();
	            String query = "INSERT INTO tabela (rua, data) VALUES (?, ?)";
	            prstmt = con.prepareStatement(query);
	            prstmt.setString(1, r);
	            prstmt.setString(2, d);
	            
	            prstmt.execute();
	            
	            prstmt.close();
	            stmt.close();
	            con.close();
			}
        } catch (Exception e) { e.printStackTrace(); }
	}
}
