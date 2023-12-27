package com.expensetracker.model;

/**
 * Expense
 */
public class Expense {

  private int id;
  private String username;
  private double amount;
  private String description;
  private String date;

  public Expense(int id, String username, double amount, String description,
      String date) {
    this.id = id;
    this.username = username;
    this.amount = amount;
    this.description = description;
    this.date = date;
  }

  // Getter methods

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public double getAmount() {
    return amount;
  }

  public String getDescription() {
    return description;
  }

  public String getDate() {
    return date;
  }
}
