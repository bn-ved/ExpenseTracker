package com.expensetracker;

import com.expensetracker.controller.ExpenseController;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    ExpenseController controller = new ExpenseController();
    controller.display();
  }
}
