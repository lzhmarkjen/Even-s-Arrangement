public class Num {
    private int number;
    private char direction;

    public Num(int number) {
        this.number = number;
        this.direction = 'l';
    }

    public char getDirection() {
        return direction;
    }

    public int getNumber() {
        return number;
    }

    public void reverse() {
        if (this.direction == 'l') {
            this.direction = 'r';
        } else if (this.direction == 'r') {
            this.direction = 'l';
        }
    }
}
