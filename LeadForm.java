package LeadForm;
import java.sql.*;

import java.util.Scanner;

public class NewLeadForm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an action:");
        System.out.println("1. Fill Details");
        System.out.println("2. Fetch Details");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                fillLeadDetails();
                break;
            case 2:
                displayLeadDetails();
                break;
            default:
                System.out.println("Invalid choice. Please choose 1 or 2.");
        }

        scanner.close();
    }

    private static void fillLeadDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter lead details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

      
        saveLeadToDatabase(name, email, phone);

        scanner.close();
    }

    private static void displayLeadDetails() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
           
            String dbURL = "jdbc:mysql://localhost:3306/your_database";
            String username = "your_username";
            String password = "your_password";
            connection = DriverManager.getConnection(dbURL, username, password);

          
            String selectQuery = "SELECT * FROM leads";
            preparedStatement = connection.prepareStatement(selectQuery);

         
            resultSet = preparedStatement.executeQuery();

         
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");

                System.out.println("Lead Details:");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Phone: " + phone);
                System.out.println("----------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void saveLeadToDatabase(String name, String email, String phone) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
          
            String dbURL = "jdbc:mysql://localhost:3306/your_database";
            String username = "your_username";
            String password = "your_password";
            connection = DriverManager.getConnection(dbURL, username, password);

        
            String insertQuery = "INSERT INTO leads (name, email, phone) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);

         
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);

            
            preparedStatement.executeUpdate();

            System.out.println("Lead details successfully saved to MySQL database.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
          
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

