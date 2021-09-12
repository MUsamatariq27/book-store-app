package bookstoreapp;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

    private static Stage stg;
    private static final ObservableList<Book> BooksList = FXCollections.observableArrayList(); //list of books
    private static final ObservableList<Customer> CustomerList = FXCollections.observableArrayList(); //list of books

    @Override
    public void start(Stage primaryStage) {
        try {
            stg = primaryStage;
            primaryStage.setResizable(false);
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Bookstore App");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeScene(String fxml) throws IOException {

        BorderPane pane = (BorderPane) FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(pane);
        stg.setScene(scene);

    }

    public static void addBook(String name, double price) {

        Book nbook = new Book(name, price);
        BooksList.add(nbook);

    }

    public static void removeBook(Book b) {

        BooksList.remove(b);

    }

    public static void addCustomer(String username, String pass) {

        Customer cus = new Customer(username, pass);
        CustomerList.add(cus);

    }

    public static void removeCustomer(Customer cus) {

        CustomerList.remove(cus);

    }

    private static void loadData() {

        File file = new File("dbfolder/customers.txt");

        Scanner sc;
        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String s = sc.nextLine();

                String strArray[] = s.split(" ");
                int pts = Integer.parseInt(strArray[2]);
                Customer c = new Customer(strArray[0], strArray[1]);
                c.setPoints(pts);
                CustomerList.add(c);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        file = new File("dbfolder/books.txt");

        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String s = sc.nextLine();

                String strArray[] = s.split(" ");
                Double price = Double.parseDouble(strArray[1]);
                Book b = new Book(strArray[0], price);
                BooksList.add(b);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void WriteData() {

        FileWriter fw;
        try {
            fw = new FileWriter("dbfolder/books.txt");
            for (Book b : BooksList) {

                String s = b.getName() + " " + b.getPrice();
                fw.write(s);
                fw.write(System.getProperty("line.separator"));
            }

            fw.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            fw = new FileWriter("dbfolder/customers.txt");

            for (Customer c : CustomerList) {

                String s = c.getUsername() + " " + c.getPassword() + " " + c.getPoints();
                fw.write(s);
                fw.write(System.getProperty("line.separator"));
            }

            fw.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) {

        loadData();
        launch(args);
        WriteData();

    }

    public static void removeIfselect() {
        BooksList.removeIf(b -> b.getSelect().isSelected() == true);

    }

    public static ObservableList<Book> getBooksList() {

        return BooksList;
    }

    public static ObservableList<Customer> getCustomerList() {

        return CustomerList;
    }
}
