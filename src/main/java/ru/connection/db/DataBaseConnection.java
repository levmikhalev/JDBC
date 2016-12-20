package ru.connection.db;

import java.sql.*;

public class DataBaseConnection {

    //инициализируем переменные-константы для подключения к БД
    private static final String HOST = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    DataBaseConnection dbc = new DataBaseConnection();
    Connection connection;

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
                System.out.println("Увы, подключение к БД уже закрыто :(");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось загрузить драйвер!");
        }
    }

    public void addUser(String name, String age, String email) {
        try {
            PreparedStatement statement1 = dbc.getConnection().prepareStatement("INSERT INTO users (name, age, email) VALUES ('"+name+"','"+age+"','"+email+"')");
            statement1.executeUpdate();
            statement1.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Wops! Что то пошло не так, и SQL запрос не сработал...");
        }
    }

    public void delUser(int id) {
        try {
            PreparedStatement statement2 = dbc.getConnection().prepareStatement("DELETE FROM users WHERE id = '"+id+"';");
            statement2.executeUpdate();
            statement2.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Wops! Что то пошло не так, и SQL запрос не сработал...");
        }
    }
}
