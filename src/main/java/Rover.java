public class Rover {

    public static final String EAST = "E";
    public static final String WEST = "W";
    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    public static final String DIRECTION_CIRCLE = NORTH + EAST + SOUTH + WEST;
    public static final String[] S = new String[]{NORTH, EAST, SOUTH, WEST};
    public static final String TURN_LEFT = "L";
    public static final String TURN_RIGHT = "R";
    private int xLocation;
    private int yLocation;
    private String direction;
    private Area area;


    public void land(Area areaParamter, int i, int j, String h) {
        this.area = areaParamter;
        if (area.containXDirection(i, Area.DIRECTION_X)) {
            throw new IllegalArgumentException("out of bound !");
        }
        if (area.containXDirection(j, Area.DIRECTION_Y)) {
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
        int x, y;
        switch (direction) {
            case EAST:
                x = xLocation + 1;
                if (area.containXDirection(x, Area.DIRECTION_X)) {
                    throw new IllegalArgumentException("out of bound !");
                }
                xLocation = x;
                break;
            case WEST:
                xLocation -= 1;
                break;
            case NORTH:
                y = yLocation + 1;
                if (area.containXDirection(y, Area.DIRECTION_X)) {
                    throw new IllegalArgumentException("out of bound !");
                }
                yLocation = y;
                break;
            case SOUTH:
                yLocation -= 1;
                break;
            default:
                throw new IllegalArgumentException("Command is not Found");

        }

    }

    public void turnLeft() {

        direction = findDirection(direction, TURN_LEFT);
    }

    public void turnRight() {
        direction = findDirection(direction, TURN_RIGHT);
    }

    private String findDirection(String direction, String turnDirection) {
        int i = fintDirection(direction, turnDirection);
        return S[i];
    }

    private int fintDirection(String direction, String leftOrRight) {
        int i = DIRECTION_CIRCLE.indexOf(direction);
        if (TURN_RIGHT.equals(leftOrRight)) {
            if (i == 3) {
                i = 0;
            } else {
                i++;
            }
        } else if (TURN_LEFT.equals(leftOrRight)) {
            if (i == 0) {
                i = 3;
            } else {
                i--;
            }
        }
        return i;
    }
}
