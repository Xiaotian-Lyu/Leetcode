package Uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

class Library {
//    private HashSet<Integer> remainBook = new HashSet<>();
//    private HashSet<Integer> borrowBook = new HashSet<>();

    private Map<Integer, Book> inventory = new HashMap<>();
    private Map<Integer, Member> memberMap = new HashMap<>();
    private Map<String, List<Book>> bookNameToBook = new HashMap<>();

    public Library() {

    }

    public void addBook(Book book) {
        int id = book.id;
        if (inventory.containsKey(id)) {
            System.out.println("duplicated book");
            return;
        }
        inventory.put(id, book);
        bookNameToBook.putIfAbsent(book.name, new ArrayList<>());
    }

    public List<Book> lookup(String bookName) {
        return bookNameToBook.get(bookName);
    }
    public void borrow(int bookId, int memberID) {
        if (!memberMap.containsKey(memberID)) {
            System.out.println("No mmeber");
            return;
        }

        Book book = inventory.get(bookId);
        if (book == null) {
            System.out.println("Invalid book id");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("not avaiable");
            return;
        }
        Member member = memberMap.get(memberID);
        member.borrowBookList.add(book);
        book.isAvailable = false;
    }

    public void returnBook(Book book, int memberID) {

    }
}

class Book{
    int id;
    boolean isAvailable;
    String name;

    public Book(int id, boolean isAvailable, String name){
        this.id = id;
        this.isAvailable = true;
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

class Member{
    String name;
    int memberId;
    static int nextId = 1;
    List<Book> borrowBookList;

    public Member(String name, int memberId){
        this.name = name;
        this.memberId = nextId++;
        this.borrowBookList = new ArrayList<>();
    }

    public void borrowBook(int bookID){
//        if(book.isAvailable){
//            borrowBookList.add(book);
//            System.out.println("Succeed");
//        }else{
//            System.out.println("Sorry, the book is borrowed");
//        }
    }

    public void returnBook(int bookID){
//        borrowBookList.remove(book);
    }


}
