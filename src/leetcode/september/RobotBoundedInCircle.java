package leetcode.september;

public class RobotBoundedInCircle {
    private boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, dirX = 0, dirY = 1, temp;
        for (int i = 0; i < instructions.length(); i++) {
            switch (instructions.charAt(i)) {
                case 'L':
                    temp = dirX;
                    dirX = dirY;
                    dirY = -temp;
                    break;
                case 'R':
                    temp = dirX;
                    dirX = -dirY;
                    dirY = temp;
                    break;
                default:
                    x = x + dirX;
                    y = y + dirY;
            }
        }
        return (x == 0 && y == 0) || !(dirX == 0 && dirY == 1);
    }

    public static void main(String[] args) {
        RobotBoundedInCircle rb = new RobotBoundedInCircle();
        System.out.println(rb.isRobotBounded("GGLLGG"));
        System.out.println(rb.isRobotBounded("GG"));
        System.out.println(rb.isRobotBounded("GL"));
    }
}
