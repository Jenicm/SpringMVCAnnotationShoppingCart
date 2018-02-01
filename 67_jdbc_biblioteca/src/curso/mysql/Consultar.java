package curso.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultar {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
		
		Statement st = conn.createStatement();
		
		
		System.out.println("-------------------------LISTAR----------------------------------------");

		ResultSet rs = st.executeQuery("select * from libros");
		while (rs.next()) {
			System.out.println("Titulo: " + rs.getString("titulo"));
			System.out.println("Precio: " + rs.getFloat("precio"));
			System.out.println("Fecha: " + rs.getDate("fecha_publicacion"));
		}
		
		
		
		System.out.println("-------------------------INSERTAR----------------------------------------");
		
		int insertar = st.executeUpdate("insert into libros(id, titulo, autor, precio, fecha_publicacion, portada) values(null, 'Mas alla del invierno', 'Isabel Allende', 19.2, '2001-12-08', null)");
		System.out.println("Fila insertada " + insertar);
		
		
		
		System.out.println("-------------------------LISTAR CON PREPARESTATEMENT PIDIENDO TITULO----------------------------------------");
		
		PreparedStatement pstmt = conn.prepareStatement("select * from libros where titulo=?");
		pstmt.setString(1, "El Quijote");
		
		ResultSet rs2 = pstmt.executeQuery();
		while (rs2.next()) {
			System.out.println("Titulo: " + rs2.getString("titulo"));
			System.out.println("Precio: " + rs2.getFloat("precio"));
			System.out.println("Fecha: " + rs2.getDate("fecha_publicacion"));
		}
		
		
		
		System.out.println("-------------------------LISTAR CON CALLABLESTATEMENT----------------------------------------");

		CallableStatement cstmt = conn.prepareCall("{call listalibros()}");
		
		ResultSet rs3 = cstmt.executeQuery();
		while (rs3.next()) {
			System.out.println("Titulo: " + rs3.getString("titulo"));
			System.out.println("Precio: " + rs3.getFloat("precio"));
			System.out.println("Fecha: " + rs3.getDate("fecha_publicacion"));
		}
		
		
		
		System.out.println("-------------------------LISTAR CON CALLABLESTATEMENT POR AUTOR----------------------------------------");

		cstmt = conn.prepareCall("{call listalibrosporautor(?)}");
		
		cstmt.setString(1, "Isabel Allende");
		
		ResultSet rs4 = cstmt.executeQuery();
		while (rs4.next()) {
			System.out.println("Titulo: " + rs4.getString("titulo"));
			System.out.println("Precio: " + rs4.getFloat("precio"));
			System.out.println("Fecha: " + rs4.getDate("fecha_publicacion"));
		}
		
	}
}
