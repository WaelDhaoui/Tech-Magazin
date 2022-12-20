package serv;

import java.io.InputStream;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

import json.User;

import java.net.ServerSocket;

import java.net.Socket;

public class Serveur {
	public static void main(String[] args) {
		try{  
			ServerSocket serverSocket = new ServerSocket(405);
			System.out.print("le serveur attend la connexion \n");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root",""); 
			
			Socket socket = serverSocket.accept();
			System.out.println("le client est connecte!");
			
			Statement stmt = con.createStatement();
		    
			InputStream sr = socket.getInputStream();
			InputStreamReader r = new InputStreamReader(sr);
			BufferedReader br = new BufferedReader(r);
			
			String[] s = br.readLine().split(",");

			String sql = "INSERT INTO users VALUES (?,?,?,?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, s[0]);
			statement.setString(2, s[1]);
			statement.setString(3, s[2]);
			statement.setString(4, s[3]);
			statement.executeUpdate();
			
			System.out.println("Insert Successfull !!");
			
			con.close();  
			socket.close();
	   
	   }catch(Exception e){System.out.println(e);} 
	}
}