public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() {
        position = 5;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public boolean jump(int steps) {
        if (steps > 0 && (MAX_POSITION - position) < steps) {
            System.out.println("Лягушка не может прыгнуть за границы поля");
            return false;
        } else if (steps < 0 && (position - MIN_POSITION) < Math.abs(steps)) {
            System.out.println("Лягушка не может прыгнуть за границы поля");
            return false;
        } else {
            position += steps;
            System.out.println("Лягушка прыгает");
            return true;
        }
    }
}
