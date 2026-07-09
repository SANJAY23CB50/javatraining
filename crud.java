

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class crud{

    static String url = "jdbc:mysql://localhost:3306/HW";
    static String user = "root";
    static String password = "82562425";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- VEHICLE DATABASE MENU ---");
            System.out.println("1. Add a record");
            System.out.println("2. View all records");
            System.out.println("3. Update a record");
            System.out.println("4. Delete a record");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1 -> addRecord(sc);
                case 2 -> viewRecords();
                case 3 -> updateRecord(sc);
                case 4 -> deleteRecord(sc);
                case 5 -> running = false;
                default -> System.out.println("Invalid option, try again.");
            }
        }
        sc.close();
    }

    // CREATE
    static void addRecord(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Year: ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Make: ");
        String make = sc.nextLine();

        System.out.print("Enter Model: ");
        String model = sc.nextLine();

        String sql = "INSERT INTO VEHICLE (ID, YEAR, MAKE, MODEL) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.setInt(2, year);
            pstmt.setString(3, make);
            pstmt.setString(4, model);

            pstmt.executeUpdate();
            System.out.println("✅ Record added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    static void viewRecords() {
        String sql = "SELECT * FROM VEHICLE";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- VEHICLE RECORDS ---");
            System.out.println("ID | YEAR | MAKE | MODEL");
            System.out.println("----------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("ID") + " | " +
                    rs.getInt("YEAR") + " | " +
                    rs.getString("MAKE") + " | " +
                    rs.getString("MODEL")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    static void updateRecord(Scanner sc) {
        System.out.print("Enter ID of record to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new Year: ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new Make: ");
        String make = sc.nextLine();

        System.out.print("Enter new Model: ");
        String model = sc.nextLine();

        String sql = "UPDATE VEHICLE SET YEAR = ?, MAKE = ?, MODEL = ? WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, year);
            pstmt.setString(2, make);
            pstmt.setString(3, model);
            pstmt.setInt(4, id);

            int rows = pstmt.executeUpdate();
            System.out.println("✅ " + rows + " record(s) updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    static void deleteRecord(Scanner sc) {
        System.out.print("Enter ID of record to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM VEHICLE WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            System.out.println("✅ " + rows + " record(s) deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
