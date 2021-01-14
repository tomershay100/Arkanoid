//323082701

/**
 * ScoreTrackingListener class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-05-21
 */
public class ScoreTrackingListener implements HitListener {
    private final Counter currentScore;

    /**
     * Constructor.
     *
     * @param scoreCounter the counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        if (!beingHit.isDupBalls() && !beingHit.isDeathBlock()) {
            this.currentScore.increase(5);
            if (beingHit.getHitCountLeft() == 0) {
                this.currentScore.increase(10);
            }
        }
    }
}