package com.expensetracker.controller;

import com.expensetracker.view.MainView;
import java.util.Scanner;

/**
 * ExpenseController
 * Main class to perfrom all the expense tracking operations.
 */
public class ExpenseController {
  private Scanner scanner = new Scanner(System.in);

  public void displayMainMenu() {
    MainView.getUserInput();
    int option = scanner.nextInt();
  }
}
