package com.expensetracker.controller;

import com.expensetracker.database.DatabaseManager;
import com.expensetracker.util.InputValidator;
import com.expensetracker.util.PasswordUtil;
import com.expensetracker.view.MainView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * ExpenseController
 * Main class to perfrom all the expense tracking operations.
 */
public class ExpenseController {
  private Scanner scanner = new Scanner(System.in);
  private final Connection connection;

  public ExpenseController(Connection connection) {
    this.connection = connection;
    initializeDatabase();
  }

  private void initializeDatabase() {
    try {
      DatabaseManager.initializeDatabase(connection);
      DatabaseManager.createExpensesTable(connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void display() {
    MainView.enterUser();
    String option = scanner.nextLine();
    boolean isValidUserName = InputValidator.validString(option);
    validateUser(isValidUserName);
  }

  /**
   * This method is responsible for performing certain
   * operaions based on the input option.
   *
   * @param option takes a option input to process.
   */
  public static void processOption(int option) {

    switch (option) {
      case 1:
        // TODO: addExpense();
        System.out.println("✅ Expense add Successfully.");
        break;
      case 0:
        System.out.println("Exiting Expense Tracker. Good Bye 👋");
        System.exit(0);
        break;
      default:
        System.out.println("❌ Wrong Input Type");
    }
  }

  /**
   * If the username is a valid username then this method checks if the
   * user is a existing user or a new user.
   *
   * @param isValidUserName a boolean value for a valid or invalid user.
   */
  public static void validateUser(boolean isValidUserName) {
    // TODO: check if the user is an existing user of new user
    if (isValidUserName) {
      String password = "hello";
      String hashedPassword = PasswordUtil.hashPassword(password);
      System.out.println(hashedPassword);
    } else {
      System.out.println("This is user is invalid");
    }
  }
}
