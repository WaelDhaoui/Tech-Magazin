package serv;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		try{  
			ServerSocket serverSocket = new ServerSocket(111);
			System.out.print("le serveur attend la connexion \n");
			
			while(true) {
				Class.forName("com.mysql.cj.jdbc.Driver");
			    
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
				
				Socket socket = serverSocket.accept();
				System.out.println("le client est connecte!");
				
				InputStream sr = socket.getInputStream();
				InputStreamReader r = new InputStreamReader(sr);
				BufferedReader br = new BufferedReader(r);
				
				String[] s = br.readLine().split(",");
				Statement stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from users"); 
				
				OutputStream os = socket.getOutputStream();
				
				int nb = 0;
				
				while(rs.next()) {
					if(s[0].equals(rs.getString(3)) && s[1].equals(rs.getString(4))) {
						nb = 1;
						os.write(nb);
						break;
					}
				}
				
				if(!rs.next()) {
					os.write(nb);
					System.out.println("Resultat : ++++ "+nb);
				}
				
				
				con.close();  
				socket.close();
			}
			
			
	   
	   }catch(Exception e){System.out.println(e);} 
		

	}

}
