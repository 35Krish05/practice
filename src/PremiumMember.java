public class PremiumMember extends Member {

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