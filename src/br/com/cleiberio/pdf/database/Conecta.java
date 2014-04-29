package br.com.cleiberio.pdf.database;

import java.sql.*;

public class Conecta {
	
	
	public static Connection connectDB()throws Exception {
        Connection connect = null;
         try {
             String url = "jdbc:mysql://futmanager.com/radar";
             Class.forName( "com.mysql.jdbc.Driver" );
             connect = DriverManager.getConnection( url , "radar" , "vieira102040" );
        } catch(SQLException s){
            System.out.println( "SQL Error:" + s.toString() + " " 
               + s.getErrorCode() + " " + s.getSQLState());
        } catch(Exception e){
        	System.out.println("Error: " + e.toString() + e.getMessage());
        }
        return connect;
     }
}

