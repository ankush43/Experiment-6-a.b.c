import java.sql.*;
import java.util.Scanner;

public class ProductCRUD {
    static String url = "jdbc:mysql://localhost:3306/testdb";
    static String username = "root";
    static String password = "password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n==== Product CRUD Menu ====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product Price");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: viewProducts(); break;
                case 3: updateProduct(); break;
                case 4: deleteProduct();
