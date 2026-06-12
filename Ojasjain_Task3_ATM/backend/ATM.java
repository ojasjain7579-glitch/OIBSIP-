package backend;

import java.sql.*;
import java.util.Scanner;

public class ATM {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            System.out.println("===== ATM LOGIN =====");

            System.out.print("Enter Account Number: ");
            String account = sc.nextLine();

            System.out.print("Enter PIN: ");
            String pin = sc.nextLine();

            String query = "SELECT * FROM users WHERE account_no=? AND pin=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, account);
            pst.setString(2, pin);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {

                double balance = rs.getDouble("balance");

                System.out.println("Login Successful!");

                while(true) {

                    System.out.println("\n===== ATM MENU =====");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Exit");

                    System.out.print("Choose Option: ");

                    int choice = sc.nextInt();

                    switch(choice) {

                        case 1:

                            System.out.println("Current Balance: " + balance);
                            break;

                        case 2:

                            System.out.print("Enter Deposit Amount: ");

                            double deposit = sc.nextDouble();

                            balance += deposit;

                            PreparedStatement pst2 = con.prepareStatement(
                                    "UPDATE users SET balance=? WHERE account_no=?"
                            );

                            pst2.setDouble(1, balance);
                            pst2.setString(2, account);

                            pst2.executeUpdate();

                            System.out.println("Amount Deposited Successfully!");
                            break;

                        case 3:

                            System.out.print("Enter Withdraw Amount: ");

                            double withdraw = sc.nextDouble();

                            if(withdraw > balance) {

                                System.out.println("Insufficient Balance!");

                            } else {

                                balance -= withdraw;

                                PreparedStatement pst3 = con.prepareStatement(
                                        "UPDATE users SET balance=? WHERE account_no=?"
                                );

                                pst3.setDouble(1, balance);
                                pst3.setString(2, account);

                                pst3.executeUpdate();

                                System.out.println("Withdraw Successful!");
                            }

                            break;

                        case 4:

                            System.out.println("Thank You!");

                            System.exit(0);

                        default:

                            System.out.println("Invalid Option");
                    }
                }

            } else {

                System.out.println("Invalid Account Number or PIN!");
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}
