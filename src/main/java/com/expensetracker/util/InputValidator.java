package com.expensetracker.util;

/**
 * InputValidator
 * It validates the input entered by the user is correct or not.
 * - removes triling and leading white spaces
 * - checks if the string is integer
 */
public class InputValidator {
  public static boolean valid(String option) {
    option = option.strip();
    try {
      int value = Integer.parseInt(option);
      if (value < 0) {
        return false;
      }
    } catch (NumberFormatException e) {
      System.out.println("❌ Enter a Valid Number.");
    }
    return true;
  }
}
