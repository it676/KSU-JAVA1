package library;

import java.util.Scanner;

/**
 *
 * @author IT676
 */
public class Library {

    private static Book[] books = new Book[100];

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int userChoice;
        do {

            //print a list for the user 
            System.out.print("\n1. Add a new book.\n"
                    + "2. Find a Book.\n"
                    + "3. Display all books.\n"
                    + "4. Display the total number of books.\n"
                    + "5. Exit\n"
                    + "Enter Your Choice :");

            userChoice = input.nextInt();

            switch (userChoice) {
                case 1:

                    System.out.print("Enter Book ISBN: ");
                    int ISBN = input.nextInt();

                    /*
                     the next statement is important  
                     if the user clicked enter this will help us to allow user to enter the Author name 
                     otherwise he will not be able to enter the name of the author
                     */
                    input.nextLine();

                    System.out.print("Enter Book Title: ");
                    String Title = input.nextLine();
                    System.out.print("Enter Book Published Year: ");
                    int publishedyear = input.nextInt();

                    input.nextLine();//same before 

                    System.out.print("Enter Book Author: ");
                    String Author = input.nextLine();

                    //call the method and store the returned value 
                    boolean isAdded = addBook(ISBN, Title, publishedyear, Author);

                    if (isAdded) {
                        System.out.println(Title + " has been added successfully !");
                    } else {

                        System.out.println("Failed to add : " + Title + " , Please Check ISBN Again !");

                    }

                    break;//end of case #1

                case 2:

                    System.out.print("Enter Book ISBN: ");//ask the user to enter the ISBN of the book to search for
                    ISBN = input.nextInt();
                    int bookIndex = findBook(ISBN);//call the method and store the result

                    if (bookIndex != -1) {//if  not equal -1 that means the book is found
                        System.out.println("Book was found at index : " + bookIndex);
                    } else {

                        //this means  the book was not found dear lovely greatly super man student :) 
                        System.out.println("Sorry , The Book was not found.");
                    }

                    break;//end of case #2

                case 3: //our lovely and short case ^_^ 

                    //display all the books by just calling the method
                    printAll();

                    break; //Thank you case#3 you're short and easy to do 

                case 4:
                    int totalNumBook = allBooks(); //call the method and store the result 
                    System.out.println("Total Number of Books is : " + totalNumBook);

                    break; //end of case #4

                case 5:
                    /*
                     no need to do anything in this case
                     the program will be terminated (stopped)
                     */

                    break;

                default://If the user selected any number not in the correct range[1,5]
                    System.out.println("Invalid Choice ! [1-5 Allowed Only] ");
            }

        } while (userChoice != 5);//stop only if the user entered 5 

    }//end of main

    public static boolean addBook(int ISBN, String Title, int publishedyear, String Author) {

        Book book = new Book(ISBN, Title, publishedyear, Author);

        //check if the array(books) full or not 
        if (Book.totalBooks == books.length) {
            return false;
        }

        //check ISBN 
        if (book.Verify_ISBN() == true) {

            books[Book.totalBooks++] = book; //store the book in th array

            return true;

        } else {
            return false;
        }
    }//end of addBook

    /*
     This method should enable the user to search for a book using
     ISBN, and then display the information of the book. This method should
     returns the index of a given book in the system if the book is found, or -1 if
     the book is not found
    
     */
    public static int findBook(int ISBN) {

        /*loop through the array and compare the ISBN
         don't use  i<books.length  or you will have an error : NullPointerException 
         If you want you must add a condetion  :
         if(books[i] != null) before the if st of the if checking the ISBN
         */
        for (int i = 0; i < Book.totalBooks; i++) {

            if (books[i].getISBN() == ISBN) {//we found the book 

                return i; //stop the method and return the index of the book , you can use break; alo

            }

        }
        //if the program reched here that means the book is not found , so return -1

        return -1;
    }//end of findBook

    /*
     This method should enable the user to display the information
     of all the books in the system. If there are no books, “No books” is printed.
     */
    public static void printAll() {

        //check if there're no books
        if (Book.totalBooks == 0) {
            System.out.println("No books");
        } else {

            for (int i = 0; i < Book.totalBooks; i++) {

                System.out.println("");//new line space - for the output to be cool
                books[i].printBookInfo(); // call the method to print book's info
                System.out.println("--------------------------------------");//print this line after each book
            }
        }
    }//end of printAll

    /*
     This method should enable user to display
     the total number of books in the system.
     */
    public static int allBooks() {

        int totalNumberOfBooks = Book.totalBooks;

        return totalNumberOfBooks;
    }//end of allBooks
}
