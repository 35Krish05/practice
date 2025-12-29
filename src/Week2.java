import java.util.ArrayList;
public class Week2 {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book(1, "Java Basics", "James Gosling");
        Book b2 = new Book(2, "OOP in Java", "Herbert Schildt");

        library.addBook(b1);
        library.addBook(b2);

        Member m1 = new Member(101, "Rahul");
        Member m2 = new PremiumMember(102, "Amit");

        library.registerMember(m1);
        library.registerMember(m2);

        library.displayBooks();
        library.displayMembers();

        library.borrowBook(b1, m1);
        library.borrowBook(b2, m2);

        library.displayBooks();
        library.displayMembers();

        library.searchByAuthor("James Gosling");

        library.returnBook(b1, m1);
    }
}


