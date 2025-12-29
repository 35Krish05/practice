public class Member {

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