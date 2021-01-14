//323082701

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * GameLevel class.
 *
 * @author Tomer Shay <tomershay100@gmail.com>
 * @version 1.0
 * @since 2020-06-05
 */
public class GameLevel implements Animation {
    private final LevelInformation levelInformation;
    private final SpriteCollection sprites;
    private final GameEnvironment environment;
    private final Counter remainingBlocks;
    private final Counter availabeBalls;
    private final ScoreTrackingListener scoreTrackingListener;
    private final BlockRemover blockR;
    private final BallRemover ballR;
    private final AnimationRunner runner;
    private final KeyboardSensor keyboard;
    private final Counter score;
    private boolean running;
    private Counter lives;
    private Paddle paddle;

    /**
     * Constructor.
     *
     * @param levelInformation the LevelInformation.
     * @param keyboardSensor   the KeyboardSensor.
     * @param animationRunner  the AnimationRunner.
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboardSensor,
                     AnimationRunner animationRunner) {
        this.levelInformation = levelInformation;
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        remainingBlocks = new Counter();
        availabeBalls = new Counter();
        score = new Counter();
        scoreTrackingListener = new ScoreTrackingListener(this.score);
        blockR = new BlockRemover(this, this.remainingBlocks);
        ballR = new BallRemover(this, this.availabeBalls);
        running = true;
        runner = animationRunner;
        keyboard = keyboardSensor;
    }

    /**
     * return the lives.
     *
     * @return the lives.
     */
    public Counter getLives() {
        return lives;
    }

    /**
     * set the lives.
     *
     * @param lives1 the lives.
     */
    public void setLives(Counter lives1) {
        this.lives = lives1;
    }

    /**
     * return the remainingBlocks counter.
     *
     * @return the remainingBlocks counter.
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }

    /**
     * Add collidable to the game.
     *
     * @param c the Interfaces.Collidable that needs to be add.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * remove c from environment.
     *
     * @param c the Collidable we want to remove.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * Add Interfaces.Sprite to the game.
     *
     * @param s the Interfaces.Sprite that needs to be add.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * remove s from sprites.
     *
     * @param s the Sprite we want to remove.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball.Ball (and BlocksPackage.Paddle) and add them to the game.
     */
    public void initialize() {
        int gameWidth = 800;
        int gameHeight = 600;

        addSprite(this.levelInformation.getBackground());

        int borderThickness = 17;
        int borderSpace = 0;
        List<Block> borders = new ArrayList<>();

        Block border1 = new Block(new Rectangle(new Point(borderSpace, borderSpace), borderThickness, gameHeight));
        Block border2 = new Block(new Rectangle(new Point(borderThickness + 2 * borderSpace, borderSpace),
                gameWidth - borderThickness - 3 * borderSpace, borderThickness * 2));
        Block border3 = new Block(new Rectangle(new Point(gameWidth - borderThickness - borderSpace,
                borderThickness * 2 + 2 * borderSpace), borderThickness,
                gameHeight - borderThickness * 2 - 2 * borderSpace));

        //Block border4 = new Block(new Rectangle(new Point(-gameWidth, gameHeight), gameWidth * 3,
        //        borderThickness));
        //border4.setDeathBlock(true);
        //border4.addHitListener(blockR);
        //border4.addHitListener(ballR);
        //border4.setColor(Color.GRAY.brighter());
        //border4.addToGame(this);

        borders.add(border1);
        borders.add(border2);
        borders.add(border3);
        //borders.add(border4);

        createPaddle();

        for (Block b : borders) {
            b.setColor(Color.GRAY.brighter());
            b.setIsBorder(true);
            b.addHitListener(blockR);
            b.addHitListener(ballR);
            b.addToGame(this);
        }

        for (int i = 0; i < this.levelInformation.blocks().size(); i++) {
            Block block = this.levelInformation.blocks().get(i);

            block.addToGame(this);
            block.addHitListener(this.blockR);
            block.addHitListener(this.ballR);
            block.addHitListener(this.scoreTrackingListener);
        }
        this.remainingBlocks.increase(this.levelInformation.numberOfBlocksToRemove());
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        this.addSprite(scoreIndicator);

        NameOfLevelIndicator nameOfLevelIndicator = new NameOfLevelIndicator(this.levelInformation.levelName());
        this.addSprite(nameOfLevelIndicator);

        LivesIndicator livesIndicator = new LivesIndicator(this.lives);
        this.addSprite(livesIndicator);

        /*
        int amountOfLines = 6;
        int amountInLine = 12;
        int blockHeight = 33;
        int blockWidth = 55;
        int blockYSpace = 2;
        int blockXSpace = 1;
        List<Block> lineOfBlocks = new ArrayList<>();
        for (int i = 0; i < amountOfLines; i++) {
            lineOfBlocks.clear();
            for (int j = 0; j < amountInLine; j++) {
                this.remainingBlocks.increase(1);
                Block b = new Block(new Rectangle(new Point(gameWidth - borderThickness - borderSpace
                        - (amountInLine - j) * (blockWidth + blockXSpace),
                        110 + (blockHeight + blockYSpace) * i), blockWidth, blockHeight));
                lineOfBlocks.add(b);
                lineOfBlocks.get(j).setColor(getColor(i));
                lineOfBlocks.get(j).addToGame(this);
                b.addHitListener(this.blockR);
                b.addHitListener(this.ballR);
                b.addHitListener(this.scoreTrackingListener);
            }
            amountInLine--;
            if (amountInLine == 6) {
                break;
            }
        }

        //System.out.println(this.remainingBlocks.getValue());
        int specialBlocksSize = 40;
        Block addBalls = new Block(new Rectangle(new Point(
                gameWidth - borderThickness - borderSpace * 2 - specialBlocksSize,
                borderSpace * 2 + 2 * borderThickness), specialBlocksSize, specialBlocksSize));
        addBalls.setDupBalls(true);
        addBalls.addHitListener(this.blockR);
        addBalls.addHitListener(this.ballR);
        addBalls.setColor(Color.WHITE);
        addBalls.addToGame(this);

        Block deathBlock = new Block(new Rectangle(new Point(borderSpace * 2 + borderThickness,
                borderSpace * 2 + 2 * borderThickness),
                specialBlocksSize, specialBlocksSize));
        deathBlock.setDeathBlock(true);
        deathBlock.addHitListener(blockR);
        deathBlock.addHitListener(ballR);
        deathBlock.setColor(Color.GRAY.darker().darker().darker());
        deathBlock.addToGame(this);
        */
    }

    /**
     * plays one turn.
     */
    public void playOneTurn() {
        this.createBallsOnTopOfPaddle(); // or a similar method
        this.setPaddlePosition();
        Block border4 = new Block(new Rectangle(new Point(0, 601), 800,
                1));
        border4.setDeathBlock(true);
        //border4.addHitListener(blockR);
        BallRemover ballRemover = new BallRemover(this, this.availabeBalls);
        //System.out.println(this.availabeBalls);
        border4.addHitListener(ballRemover);
        //border4.addHitListener(this.blockR);
        border4.setColor(Color.GRAY.brighter());
        border4.addToGame(this);
        if (levelInformation.levelName().equals("Final Four")) {
            Block deathBlock = new Block(new Rectangle(new Point(2 * 2 + 17,
                    2 * 2 + 2 * 17),
                    40, 40));
            deathBlock.setDeathBlock(true);
            deathBlock.addHitListener(blockR);
            deathBlock.addHitListener(ballR);
            deathBlock.setColor(Color.GRAY.darker().darker().darker());
            deathBlock.addToGame(this);
        }
        this.runner.run(new CountdownAnimation(2, 3, this.sprites)); // countdown before turn starts.
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.running = true;
        this.runner.run(this);
    }

    /**
     * set the Paddle Position.
     */
    private void setPaddlePosition() {
        int gameWidth = 800;
        int gameHeight = 600;
        int borderThickness = 17;
        int borderSpace = 0;
        int paddleHeight = 20;
        int paddleWidth = this.levelInformation.paddleWidth();

        this.paddle.setPoint(new Rectangle(new Point((double) (gameWidth - paddleWidth)
                / 2, gameHeight - paddleHeight - borderThickness - 2 * borderSpace), paddleWidth, paddleHeight));
    }

    /**
     * create paddle.
     */
    private void createPaddle() {
        int gameWidth = 800;
        int gameHeight = 600;
        int borderThickness = 17;
        int borderSpace = 0;
        int paddleHeight = 20;
        int paddleWidth = this.levelInformation.paddleWidth();
        this.paddle = new Paddle(new Rectangle(new Point((double) (gameWidth - paddleWidth)
                / 2, gameHeight - paddleHeight - borderThickness - 2 * borderSpace), paddleWidth, paddleHeight),
                keyboard, Color.ORANGE.darker(), gameWidth, borderThickness, borderSpace);
        paddle.setSpeed(this.levelInformation.paddleSpeed());
        paddle.addToGame(this);
    }

    /**
     * create balls.
     */
    private void createBallsOnTopOfPaddle() {
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            createBallOnTopOfPaddle(this.levelInformation.initialBallVelocities().get(i));
        }
    }

    /**
     * create ont ball.
     *
     * @param velocity the ball's velocity.
     */
    public void createBallOnTopOfPaddle(Velocity velocity) {
        Ball ball = new Ball(800 / 2,
                600 / 2 + 250, 5, Color.WHITE);
        ball.setVelocity(velocity);
        ball.addToGame(this);
        ball.setGameEnvironment(this.environment);
        this.availabeBalls.increase(1);
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (this.remainingBlocks.getValue() == 0) {
            this.score.increase(100);
            this.sprites.drawAllOn(d);
            this.sprites.notifyAllTimePassed();
            this.running = false;
        }
        if (this.availabeBalls.getValue() == 0) {
            this.lives.decrease(1);
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            PauseScreen pauseScreen = new PauseScreen(this.keyboard);
            pauseScreen.setSpriteCollection(this.sprites);
            KeyPressStoppableAnimation keyPressStoppableAnimation = new KeyPressStoppableAnimation(keyboard,
                    "space", pauseScreen);
            this.runner.run(keyPressStoppableAnimation);
            //this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        }
        //System.out.println("game level 298: " + this.availabeBalls.getValue());
    }

    /**
     * add score1 to score.
     *
     * @param score1 the score1.
     */
    public void addToScore(int score1) {
        this.score.increase(score1);
    }

    /**
     * returns the score.
     *
     * @return the score.
     */
    public Counter getScore() {
        return score;
    }
}