package com.kodilla.rps.strategy;

import com.kodilla.rps.shapes.Shape;
import java.util.Random;

public class Strategy {

    private int userRoundScore;
    private int computerRoundScore;
    private int userWinsNumber;
    private int computerWinsNumber;
    private static int scoreToWinRound = 3;
    private Shape computerShape;
    private static Random random = new Random();

    public int encounter(Shape userShape) {
        if (move(userShape).equals(userShape)) {
            return addScore(userRoundScore);

        } else if (move(userShape).equals(computerShape)) {
            return addScore(computerRoundScore);

        } else {
            return 0;
        }
    }

    private int addScore(int score) {
        score += 1;
        checkWins(score);
        return score;
    }

    private Shape move(Shape userShape) {
        computerShape = Shape.get(random.nextInt(3));
        return compare(userShape, computerShape);
    }

    private Shape compare(Shape userShape, Shape computerShape) {
        if (userShape.equals(computerShape)) {
            return null;
        }

        switch (userShape) {
            case ROCK: {
                if (computerShape.equals(Shape.PAPER)) {
                    return computerShape;
                }
                return userShape;
            }
            case PAPER: {
                if (computerShape.equals(Shape.SCISSORS)) {
                    return computerShape;
                }
                return userShape;
            }
            case SCISSORS: {
                if (computerShape.equals(Shape.ROCK)) {
                    return computerShape;
                }
                return userShape;
            }
            default: {
                throw new IllegalArgumentException("User shape is not correct.");
            }
        }
    }

    private void checkWins(int score) {
        if (score == scoreToWinRound) {
            addWin(score);
            resetRoundScore();
        }
    }

    private int addWin(int score) {
        if (score == userRoundScore) {
            return userWinsNumber += 1;
        }
        return computerWinsNumber += 1;
    }

    private void resetRoundScore() {
        userRoundScore = 0;
        computerRoundScore = 0;
    }
}
