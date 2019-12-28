public class Rover {

    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    private int xLocation;
    private int yLocation;
    private String direction;
    private Area area;

    public void land(Area areaParamter, int i, int j, String h) {
        this.area = areaParamter;
        if (i > area.getX()) {
            throw new IllegalArgumentException("out of bound !");
        }
        if (j > area.getY()) {
            throw new IllegalArgumentException("out of bound !");
        }
        xLocation = i;
        yLocation = j;
        direction = h;
    }

    public String getPosition() {
        return String.valueOf(xLocation) + String.valueOf(yLocation) + direction;
    }

    public void move() {
        int x,y;
        switch (direction) {
            case EAST:
                x = xLocation +1;
                xLocation += 1;
                if (x>area.getX()) {
                    throw new IllegalArgumentException("out of bound !");
                }
                xLocation = x;
                break;
            case WEST:
                xLocation -= 1;
                break;
            case NORTH:
                y = yLocation + 1;
                if (y>area.getY()) {
                    throw new IllegalArgumentException("out of bound !");
                }
                yLocation =y;
                break;
            case SOUTH:
                yLocation -= 1;
                break;
        }

    }

    public void turnLeft() {

        switch (direction) {
            case EAST:
                direction = NORTH;
                break;
            case WEST:
                direction = SOUTH;
                break;
            case NORTH:
                direction = WEST;
                break;
            case SOUTH:
                direction = EAST;
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case EAST:
                direction = SOUTH;
                break;
            case WEST:
                direction = NORTH;
                break;
            case NORTH:
                direction = EAST;
                break;
            case SOUTH:
                direction = WEST;
                break;
        }
    }
}
