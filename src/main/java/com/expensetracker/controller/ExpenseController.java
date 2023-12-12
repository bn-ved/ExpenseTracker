package com.expensetracker.controller;

import com.expensetracker.view.MainView;
import java.util.Scanner;

/**
 * ExpenseController
 * Main class to perfrom all the expense tracking operations.
 */
public class ExpenseController {
  private Scanner scanner = new Scanner(System.in);

  public void display() {
    MainView.enterUser();
    int option = scanner.nextInt();
  }

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
}
