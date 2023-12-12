package com.expensetracker.util;

/**
 * Utility class for input validation.
 */
public class InputValidator {
  /**
   * If the option is not a number then it throws {@link NumberFormatException}.
   * If number is less than 0 then it returns false else true.
   *
   * @param option user entered option for the Menu
   * @return boolean value based on a valid option.
   */
  public static boolean validOption(String option) {
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

  /**
   * @param input user string input.
   * @return boolean value based on the validity of the string.
   */
  public static boolean validString(String input) {
    input = input.strip();
    if (input.isBlank()) {
      return false;
    }
    return true;
  }
}
