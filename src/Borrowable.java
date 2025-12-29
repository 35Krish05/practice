public interface Borrowable {
    void borrowBook(Book book, Member member);
    void returnBook(Book book, Member member);
}
