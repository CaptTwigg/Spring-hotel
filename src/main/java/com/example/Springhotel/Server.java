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
          new Person.Builder()
            .name(resultSet.getString("first_name"))
            .last_name(resultSet.getString("last_name"))
            .id(Integer.parseInt(resultSet.getString("id")))
            .startDate(resultSet.getString("start_date"))
            .endDate(resultSet.getString("end_date"))
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

  public static void delete(String table, String id) throws SQLException {
    Connection conn = getConnection();
    assert conn != null;
    PreparedStatement updateEXP = conn.prepareStatement("DELETE FROM" + table + "' WHERE id = " + id);
    updateEXP.executeUpdate();
  }

//  public static void main(String[] args) throws SQLException {
//    change("people", "first_name", "Kim", "1");
//  }


}
