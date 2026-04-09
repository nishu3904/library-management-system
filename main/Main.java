package main;

import model.*;
import service.LibraryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LibraryService service = new LibraryService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Book 2.View Books 3.Add User 4.Issue 5.Return 6.Search 7.Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter id, title, author:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    String title = sc.nextLine();
                    String author = sc.nextLine();
                    service.addBook(new Book(id, title, author));
                    break;

                case 2:
                    service.viewBooks();
                    break;

                case 3:
                    System.out.println("Enter user id and name:");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    String name = sc.nextLine();
                    service.addUser(new User(uid, name));
                    break;

                case 4:
                    System.out.println("Enter bookId and userId:");
                    service.issueBook(sc.nextInt(), sc.nextInt());
                    break;

                case 5:
                    System.out.println("Enter bookId:");
                    service.returnBook(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Enter keyword:");
                    sc.nextLine();
                    service.searchBook(sc.nextLine());
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}