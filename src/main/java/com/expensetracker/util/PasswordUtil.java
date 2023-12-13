package com.expensetracker.util;

/**
 * Util class to provide hashed password.
 */
public class PasswordUtil {

  public static String hashPassword(String plainPassword) {
    String secret = getSecretKey();
    String salt = getSalt();
    return AESEncryption.encrypt(plainPassword, secret, salt);
  }

  public static boolean matchPassword(String enterdPassword, String username) {
    String storedPassword = getPasswordForUser(username);
    return storedPassword.equals(enterdPassword) ? true : false;
  }

  private static String getSecretKey() {
    // TODO: Fetch from database
    return "MySecret";
  }

  private static String getSalt() {
    // TODO: create salt in User and get from there.
    // probably fetch the salt from the database
    // for that perticular user.
    return "MySalt";
  }

  private static String getPasswordForUser(String username) {
    // TODO: find the password for the user.
    return "password";
  }
}
