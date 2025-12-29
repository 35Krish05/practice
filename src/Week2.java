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
interface Borrowable {
    void borrowBook(Book book, Member member);
    void returnBook(Book book, Member member);
}
interface Searchable {
    void searchByTitle(String title);
    void searchByAuthor(String author);
}
class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        isAvailable = false;
    }

    public void giveBack() {
        isAvailable = true;
    }

    public void display() {
        System.out.println(bookId + " | " + title + " | " + author +
                " | Available: " + isAvailable);
    }
}
class Member {

    protected int memberId;
    protected String name;
    protected int borrowedCount;
    protected int maxBooks = 2;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public boolean canBorrow() {
        return borrowedCount < maxBooks;
    }

    public void borrowBook() {
        borrowedCount++;
    }

    public void returnBook() {
        borrowedCount--;
    }

    public void display() {
        System.out.println(memberId + " | " + name +
                " | Borrowed: " + borrowedCount + "/" + maxBooks);
    }
}
class PremiumMember extends Member {

    public PremiumMember(int memberId, String name) {
        super(memberId, name);
        this.maxBooks = 5;
    }

    @Override
    public void display() {
        System.out.println(memberId + " | " + name +
                " | PREMIUM | Borrowed: " + borrowedCount + "/" + maxBooks);
    }
}


class Library implements Borrowable, Searchable {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    @Override
    public void borrowBook(Book book, Member member) {
        if (!book.isAvailable()) {
            System.out.println("Book not available");
            return;
        }
        if (!member.canBorrow()) {
            System.out.println("Borrow limit reached for " + member.name);
            return;
        }

        book.borrow();
        member.borrowBook();
        System.out.println(member.name + " borrowed " + book.getTitle());
    }

    @Override
    public void returnBook(Book book, Member member) {
        book.giveBack();
        member.returnBook();
        System.out.println(member.name + " returned " + book.getTitle());
    }

    @Override
    public void searchByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.display();
            }
        }
    }

    @Override
    public void searchByAuthor(String author) {
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                b.display();
            }
        }
    }

    public void displayBooks() {
        System.out.println("---- Books ----");
        for (Book b : books) {
            b.display();
        }
    }

    public void displayMembers() {
        System.out.println("---- Members ----");
        for (Member m : members) {
            m.display();
        }
    }
}

