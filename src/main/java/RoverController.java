public class RoverController {
    public RoverController(Rover rover) {

    }

    public String excute(String mission) {
        String[] commond = mission.split(",");
        int areaWidth = Integer.parseInt(commond[0]);
        int areaHeight = Integer.parseInt(commond[1]);
        int xLocation = Integer.parseInt(commond[2]);
        int yLocation = Integer.parseInt(commond[3]);
        String direction = commond[4];
        Rover rover = new Rover();
        rover.land(new Area(areaWidth, areaHeight), xLocation, yLocation, direction);
        for (int i = 5; i < commond.length; i++) {
            if ("M".equals(commond[i])) {
                rover.move();
            }
            if ("L".equals(commond[i])) {
                rover.turnLeft();
            }
            if ("R".equals(commond[i])) {
                rover.turnRight();
            }

        }
        return rover.getPosition();
    }
}
