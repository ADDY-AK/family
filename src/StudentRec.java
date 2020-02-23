import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Tstu {
    int RollNo;
    String Name;
    String Email;
    int PhNo;

    public Tstu(int rollNo, String name, String email, int phNo) {
        RollNo = rollNo;
        Name = name;
        Email = email;
        PhNo = phNo;
    }

    public String toString() {
        return RollNo + " " + Name + " " + Email + " " + PhNo;
    }

}

public class StudentRec {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adarsh?serverTimezone=UTC", "root", "");
        Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement("insert into Student values(?,?,?,?)");
        ps.setInt(1, sc.nextInt());
        ps.setString(2, sc.next());
        ps.setString(3, sc.next());
        ps.setInt(4, sc.nextInt());
        ps.execute();
        ResultSet rs = st.executeQuery("select * from Student");
        ArrayList<Tstu> l = new ArrayList<>();
        Pattern P = Pattern.compile("[A-Za-z0-9][A-Za-z0-9_]*[@]gmail[.]com");
        while (rs.next()) {
            Matcher m = P.matcher(rs.getString(3));
            if (m.find()) {
                l.add(new Tstu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        }
        con.close();
        System.out.println(l);


    }
}
