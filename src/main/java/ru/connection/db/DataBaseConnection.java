package ru.connection.db;

import java.sql.*;

public class DataBaseConnection {

    //инициализируем переменные-константы для подключения к БД
    private static final String HOST = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Не удалось загрузить JDBC драйвер!");
        }
    }

    //метод добавления записи в БД
    public void addUser(String name, String age, String email) throws SQLException {
        try {
            String sql = "INSERT INTO users (name, age, email) VALUES ('"+name+"','"+age+"','"+email+"')";
            connection = DriverManager.getConnection(HOST, USER, PASSWORD);
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Что-то пошло не так, и SQL запрос на добавление не сработал...");
        }
    }

    //метод удаления записи из БД по ID записи
    public void delUser(int id) {
        try {
            String sql = "DELETE FROM users WHERE id = '"+id+"'";
            connection = DriverManager.getConnection(HOST, USER, PASSWORD);
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Что-то пошло не так, и SQL запрос на удаление по ID не сработал...");
        }
    }
}
