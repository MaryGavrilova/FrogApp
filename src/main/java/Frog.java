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

    public boolean comeAshore() {
        if (position == MIN_POSITION | position == MAX_POSITION) {
            System.out.println("Лягушка уже на берегу");
            return false;
        } else {
            if (MAX_POSITION - position > MAX_POSITION / 2) {
                position = MIN_POSITION;
                System.out.println("Лягушка добралась до левого берега");
                return true;
            } else if (MAX_POSITION - position < MAX_POSITION / 2) {
                position = MAX_POSITION;
                System.out.println("Лягушка добралась до правого берега");
                return true;
            } else {
                System.out.println("Лягушка не смогла решить к какому берегу плыть");
                return false;
            }
        }
    }
}
