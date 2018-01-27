package com.example.Springhotel;


import java.sql.*;
import java.util.ArrayList;


public class Server {

  // con.prepareStatement("INSERT INTO people (first_name, last_name) VALUES('Johnny' , 'Die')").executeUpdate();


  public static Connection getConnection() {
    try {
      return DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useSSL=false", "admin", "1234");
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    return null;
  }

  public static ArrayList getArray() {
    ArrayList<Person> persons = new ArrayList<>();
    try {
      Connection con = getConnection();
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from people");

      while (resultSet.next()) {
        //System.out.println(resultSet.getString("first_name") + ", " + resultSet.getString("last_name"));

        persons.add(
          new Person.PersonBuilder()
            .BuilderName(resultSet.getString("first_name"))
            .BuilderLast_name(resultSet.getString("last_name"))
            .BuilderId(Integer.parseInt(resultSet.getString("id")))
            .build());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return persons;
  }

  public static void change(String table, String column, String replace, String id) throws SQLException {
    Connection conn = getConnection();
    PreparedStatement updateEXP = conn.prepareStatement("UPDATE " + table + " SET " + column + " = '" + replace + "' WHERE id = " + id);
    updateEXP.executeUpdate();
  }

//  public static void main(String[] args) throws SQLException {
//    change("people", "first_name", "Kim", "1");
//  }


}
