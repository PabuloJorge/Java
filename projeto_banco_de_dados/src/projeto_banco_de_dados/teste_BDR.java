package projeto_banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class teste_BDR {

 public static void main(String[] args) {
try {
Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/intel/Sistema_Bancario_Tabajara.mdb");
Statement s = conn.createStatement();
ResultSet rs = s.executeQuery("SELECT numero, nome_cliente , saldo FROM CONTA");
System.out.println("Contas na base de dados:\n");
while (rs.next()) {
System.out.println("código: " + rs.getString("numero") + " nome do cliente: "+ rs.getString("nome_cliente") + " saldo: "+ rs.getDouble("saldo"));
}
rs.close();
s.close();
conn.close();
} catch(Exception e) {
System.out.println("Hi, deu bronca...");
}
}
}
