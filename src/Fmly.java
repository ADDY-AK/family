import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Fmly {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adarsh?serverTimezone=UTC", "root", "");
        //String s="insert into ak values(?,?)";
        String s1 = "create table ak(ak int(2),ad int(3))";
        PreparedStatement ps = con.prepareStatement(s1);
        //PreparedStatement ps1= con.prepareStatement(s);
        // ps.setInt(1,sc.nextInt());
        //ps.setInt(2,sc.nextInt());
        ps.execute();
        // ResultSet rs=ps.executeQuery("select * from family");
        //int row=ps.executeUpdate();
        //System.out.println(row);
        //System.out.println(rs);
    }
}
