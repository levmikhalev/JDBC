package ru.connection.db;

import java.sql.*;

public class DataBaseConnection {

    //инициализируем переменные-константы для подключения к БД
    private static final String HOST = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection connection;
    public Connection getConnection() {
        return connection;
    }

    public DataBaseConnection() {
        try {
            connection = DriverManager.getConnection(HOST, USER, PASSWORD);

            //добавление записи
            //statement.execute("INSERT  INTO users (name, age, email) VALUES ('Max', 21, 'max@gmail.com');");

            //апдейт записи
            //statement.executeUpdate("UPDATE users SET name = 'Remax' WHERE id = 5");

            //удаление записи
            //statement.executeUpdate("DELETE FROM users WHERE id = 5;");

            /*батчим записи
            statement.addBatch("INSERT  INTO users (name, age, email) VALUES ('Eva', 23, 'eva@gmail.com');");
            statement.addBatch("INSERT  INTO users (name, age, email) VALUES ('Catrin', 24, 'catrin@gmail.com');");
            statement.addBatch("INSERT  INTO users (name, age, email) VALUES ('Mise', 25, 'misa@gmail.com');");
            statement.executeBatch();
            statement.clearBatch();*/

            if (connection.isClosed()) {
                System.out.println("Увы, подключение к БД уже закрыто.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось загрузить JDBC драйвер!");
        }
    }

    //метод добавления записи в БД
    public void addUser(String name, String age, String email) {
        try {
            String sql = "INSERT INTO users (name, age, email) VALUES ('"+name+"','"+age+"','"+email+"')";
            DataBaseConnection dbc = new DataBaseConnection();
            PreparedStatement statement = dbc.getConnection().prepareStatement(sql);
            statement.executeUpdate();
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
            DataBaseConnection dbc = new DataBaseConnection();
            PreparedStatement statement = dbc.getConnection().prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Что-то пошло не так, и SQL запрос на удаление по ID не сработал...");
        }
    }
}
