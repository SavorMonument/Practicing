package TestingPurposes;

public abstract class Test {

    private int number;

    public Test(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static void main(String[] args) {


        Test first = new ExtendedTest(5);
        Test second = new ExtendedTest(7);

        System.out.println(first.getNumber());
        System.out.println(second.getNumber());
    }
}
