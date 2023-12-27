package com.expensetracker.database;

import com.expensetracker.model.Expense;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseManager
 */
public class DatabaseManager {
  private static final String JDBC_URL = "jdbc:sqlite:expense_tracker.db";

  public static Connection connect() throws SQLException {
    try {
      Class.forName("org.sqlite.JDBC");
      return DriverManager.getConnection(JDBC_URL);
    } catch (ClassNotFoundException e) {
      throw new SQLException("SQLite JDBC driver not found", e);
    }
  }

  public static void disconnect(Connection connection) throws SQLException {
    if (connection != null && !connection.isClosed()) {
      connection.close();
    }
  }

  public static void initializeDatabase(Connection connection)
      throws SQLException {
    createUsersTable(connection);
  }

  public static void createUsersTable(Connection connection)
      throws SQLException {
    try (Statement statement = connection.createStatement()) {
      statement.execute("CREATE TABLE IF NOT EXISTS users ("
          + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
          + "username TEXT NOT NULL UNIQUE,"
          + "password TEXT NOT NULL"
          + ")");
    }
  }

  public static boolean isUserExists(Connection connection, String username)
      throws SQLException {
    String sql = "SELECT COUNT(*) FROM users WHERE username = ?";

    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, username);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        return resultSet.next() && resultSet.getInt(1) > 0;
      }
    }
  }

  public static void insertUser(Connection connection, String username,
      String hashedPassword) throws SQLException {
    String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, hashedPassword);
      preparedStatement.executeQuery();
    }
  }

  public static void createExpensesTable(Connection connection)
      throws SQLException {
    try (Statement statement = connection.createStatement()) {
      statement.execute("CREATE TABLE IF NOT EXISTS expenses ("
          + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
          + "username TEXT NOT NULL,"
          + "amount DOUBLE NOT NULL,"
          + "description TEXT,"
          + "date DATE NOT NULL,"
          + "FOREIGN KEY (username) REFERENCES users(username)"
          + ")");
    }
  }

  public static void insertExpense(Connection connection, String username,
      double amount, String description,
      String date) throws SQLException {
    String sql = "INSERT INTO expenses (username, amount, description, date) VALUES (?, ?, ?, ?)";

    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, username);
      preparedStatement.setDouble(2, amount);
      preparedStatement.setString(3, description);
      preparedStatement.setString(4, date);
      preparedStatement.executeUpdate();
    }
  }

  public static List<Expense> getExpenseForUser(Connection connection,
      String username)
      throws SQLException {
    List<Expense> expenses = new ArrayList<>();

    String sql = "SELECT * FROM expenses WHERE username = ?";

    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, username);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          int id = resultSet.getInt("id");
          double amount = resultSet.getDouble("amount");
          String description = resultSet.getString("description");
          String date = resultSet.getString("date");

          // Create an Expense object and add it to the list
          Expense expense = new Expense(id, username, amount, description, date);
          expenses.add(expense);
        }
      }
    }
    return expenses;
  }
}
