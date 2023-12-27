package com.expensetracker;

import com.expensetracker.controller.ExpenseController;
import com.expensetracker.database.DatabaseManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    try {
      Connection connection = DatabaseManager.connect();
      ExpenseController controller = new ExpenseController(connection);
      controller.display();
      DatabaseManager.disconnect(connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
