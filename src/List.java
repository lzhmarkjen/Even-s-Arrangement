import java.util.ArrayList;

public class List {
    private ArrayList<Num> list;
    private static List List = new List();

    private List() {
        list = new ArrayList<>();
    }

    public static List getInstance() {
        return List;
    }

    public void initList(int n) {
        for (int i = 1; i <= n; i++) {
            this.list.add(new Num(i));
        }
    }

    public void go() {
        //step 1:find the biggest moveable number
        int max = findMaxMoveableNum();
        while (max != -1) {
            printList();
            int maxNumber = list.get(max).getNumber();
            //step 2：move the number
            move(max);
            //step 3:reverse all the directions whose number is bigger than maxNumber
            reverseBigger(maxNumber);
            max = findMaxMoveableNum();
        }
        printList();
        System.exit(0);
    }

    private int findMaxMoveableNum() {
        int max = -1;
        int maxNumber = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getDirection() == 'l' & list.get(i - 1).getNumber() < list.get(i).getNumber()) {
                if (maxNumber < list.get(i).getNumber()) {
                    max = i;
                    maxNumber = list.get(i).getNumber();
                }
            }

        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getDirection() == 'r' & list.get(i).getNumber() > list.get(i + 1).getNumber()) {
                if (maxNumber < list.get(i).getNumber()) {
                    max = i;
                    maxNumber = list.get(i).getNumber();
                }
            }
        }
        return max;
    }

    private void move(int max) {
        char direction = list.get(max).getDirection();
        if (direction == 'l') {
            moveLeft(max);
        } else if (direction == 'r') {
            moveRight(max);
        }
    }

    private void moveLeft(int i) {
        Num temp = list.get(i);
        list.set(i, list.get(i - 1));
        list.set(i - 1, temp);
    }

    private void moveRight(int i) {
        Num temp = list.get(i);
        list.set(i, list.get(i + 1));
        list.set(i + 1, temp);
    }

    private void reverseBigger(int maxNumber) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumber() > maxNumber) {
                list.get(i).reverse();
            }
        }
    }

    private void printList() {
        for (int i = 0; i < list.size(); i++) {
            String direction = list.get(i).getDirection() == 'l' ? "<-" : "->";
            System.out.print(direction + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < list.size(); i++) {
            String number = String.format("%2d ", list.get(i).getNumber());
            System.out.print(number);
        }
        System.out.print("\n");

    }
}
