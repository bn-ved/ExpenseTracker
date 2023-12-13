package com.expensetracker.view;

/**
 * MainView
 * This is the main view for the application.
 */
public class MainView {
  public static void enterUser() {
    System.out.println("📝 Welcome to the Expense Tracker 📝");
    System.out.print("➡️ Enter User name: ");
  }

  public static void loginView() {
    System.out.println("Welcome back 🚀");
    System.out.println();
    System.out.print("➡️ Enter Username: ");
    System.out.print("➡️ Enter Password: ");
  }

  public static void registerView() {
    System.out.println("📝 Welcome to the Expense Tracker 📝");
    System.out.print("➡️ Enter Username: ");
    System.out.print("➡️ Enter Password: ");
    System.out.print("➡️ Re-Enter Password: ");
  }

  public static void displayMenu() {
    System.out.println("📝 Welcome to the Expense Tracker 📝");
    System.out.println();
    System.out.println("Enter '1': To add Expenses.");
    System.out.println("Enter '2': To print your expenses.");
    System.out.println("Enter '0': To exit.");
    System.out.println();
    System.out.print("➡️ Enter your Option: ");
  }
}
