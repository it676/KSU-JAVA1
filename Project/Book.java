package library;

/**
 *
 * @author IT676
 */
public class Book {

    private int ISBN;
    private String Author;
    private int publishedyear;
    private String Title;
    private String Ref_code;
    public static int totalBooks = 0; //this is a counter of books ,  and it's a static cuz we need it shared btw all books (single copy) 

    //a constructor that will initialize every new book with the default values :
    public Book() {

        ISBN = 12340;
        Author = "-";
        publishedyear = 2012;
        Title = "-";
        Ref_code = " ##-##";
    }

    public Book(int isbn, String title, int year, String author) {

        ISBN = isbn;
        Title = title;
        publishedyear = year;
        Author = author;

        //generate a reference for this book
        Ref_code = Generate_Reference();//this method will genrate a reference code and then assigns it to the attribute

    }

    // this methof will return the reference code
    public String getRef_Code() {

        return Ref_code;
    }

    // this methof will return the ISBN of the book 
    public int getISBN() {

        return ISBN;
    }

    /*
     generate a reference for each the book; the reference is
     formed from taking the first two characters of the author name and the first
     two characters of the book title and separate them with a dash. The reference
     will be assigned to attribute Ref_code
    
     Example: Author = Doyle, Title = SherlockHolmes  Ref_code = Do-Sh
    
     
    
     */
    public String Generate_Reference() {

        String author = "##";//to store the first two characters of the author name , default is ##
        String title = "##";//to store the first two characters of the book title,default is ##

        //first: better to check the length of the author , it should be >= 2
        if (Author.length() >= 2) {
            author = Author.substring(0, 2);//take the two first letters of the author name
        } else {

            System.out.println("Error : Invalid Author Name !");
        }

        //first: better to check the length of the title , it should be >= 2
        if (Title.length() >= 2) {
            title = Title.substring(0, 2);//take the two first letters of the title 
        } else {

            System.out.println("Error : Invalid Title !");
        }

        String refCode = author + "-" + title;

        return refCode;
    }//end of Generate_Reference

    /*
     return true if the entered ISBN is correct, the ISBN is correct if
     the fifth digit is an even number. If a book ISBN is not authentic display a
     message stating the book’s title.
     */
    public boolean Verify_ISBN() {

        String isbnStr = "" + ISBN;//store this ISBN in a string to process it

        //get the last digit from the string in the last index using .length() -1 
        //and then parse(convert) it to an integer using parseInt() method  
        int lastDigit = Integer.parseInt("" + isbnStr.charAt(isbnStr.length() - 1));

        //check if even or not , if so  then return true otherwise  return false
        if (lastDigit % 2 == 0) {
            return true;
        } else {

            return false;
        }

        /*
         You can use another way to do that  using %10
         Examples :   745%10 = 5    ,   89572%10 = 2
         
         int number = ISBN % 10 ;// this will give us alwyas the last digit from the right
         if(number % 2 == 0 ) 
         return true;
         else
         return false;
        
         */
    }//end of Verify_ISBN

    /*
     this method should display the information of a book
     using the following format:
     Book ISBN Code:
     Title:
     Author:
     Publishedyear:
     a book reference:
     */
    public void printBookInfo() {

        System.out.printf("Book ISBN Code: %d\n"
                + "Title: %s\n"
                + "Author: %s\n"
                + "Publishedyear: %d\n"
                + "a book reference: %s%n",
                ISBN, Title, Author, publishedyear, Ref_code);
    }

}
