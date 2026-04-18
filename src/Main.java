import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521/xe";
        String usuario = "USUARIO";
        String contraseña = "ribera";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             Statement st = conn.createStatement()) {

            String sql = "SELECT AVG(salario) AS promedio FROM empleado2";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                double promedio = rs.getDouble("promedio");
                System.out.println("Salario promedio: " + promedio);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}