import java.io.Serializable;

/**
 * Defenseman
 * Class contains information and methods specific to a player with a defensive position.
 */

public class Defenseman extends Skater implements Serializable {
    private int shotsBlocked;

    /**
     * Acts like basic Skater position and initializes variables with their respective arguments or to 0.
     * @throws IllegalArgumentException Thrown if the given position is not a defensive position
     */
    public Defenseman(String name, int playerNumber, String stickHand, Position side) throws IllegalArgumentException {
        super(name, playerNumber, stickHand, side);

        if (side != Position.LEFT_DEFENSE && side != Position.RIGHT_DEFENSE) {
            throw new IllegalArgumentException("Position must be a defensive position");
        }

        shotsBlocked = 0;
    }

    /**
     * Initializes variables with the values of their respective arguments.
     * @throws IllegalArgumentException Thrown if given position is not a defensive position or if shotsBlocked argument
     * is negative
     */
    public Defenseman(String name, int playerNumber, String stickHand, Position side,
                      int goals, int assists, int plusMinus, int shotsBlocked) throws IllegalArgumentException {
        super(name, playerNumber, stickHand, side, goals, assists, plusMinus);

        if (side != Position.LEFT_DEFENSE && side != Position.RIGHT_DEFENSE) {
            throw new IllegalArgumentException("Position must be a defensive position");
        }
        if (shotsBlocked < 0) {
            throw new IllegalArgumentException("Shots Blocked stat must be positive");
        } else {
            this.shotsBlocked = shotsBlocked;
        }
    }

    public int getShotsBlocked() {
        return shotsBlocked;
    }

    // Increments shots blocked up by 1
    public void blockedShot() {
        shotsBlocked++;
    }

    /**
     * @throws IllegalArgumentException Thrown if given argument is negative
     */
    public void setShotsBlocked(int shotsBlocked) throws IllegalArgumentException {
        if (shotsBlocked < 0) {
            throw new IllegalArgumentException("Shots Blocked stat must be positive");
        } else {
            this.shotsBlocked = shotsBlocked;
        }
    }

    // Resets stats to 0
    @Override
    public void resetStats() {
        super.resetStats();
        shotsBlocked = 0;
    }

    /**
     * @return A formatted String that contains all relevant information about the player
     */
    @Override
    public String statsDisplay() {
        return super.statsDisplay() +
                String.format("\n    Shots Blocked: %d", shotsBlocked);
    }
}