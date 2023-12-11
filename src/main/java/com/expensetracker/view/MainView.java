package com.expensetracker.view;

/**
 * MainView
 * This is the main view for the application.
 */
public class MainView {
  public static void getUserInput() {
    System.out.println("📝 Welcome to the Expense Tracker 📝");
    System.out.println();
    System.out.println("Enter '1': To add Expenses.");
    System.out.println("Enter '2': To print your expenses.");
    System.out.println("Enter '0': To exit.");
  }

  public static void displayMenu(int option) {
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
}
