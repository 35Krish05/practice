import java.util.ArrayList;

public class Library implements Borrowable, Searchable {

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