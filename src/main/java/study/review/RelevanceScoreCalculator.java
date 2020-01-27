package study.review;

import java.math.BigDecimal;

/**
 * Created by EricWang on 2019/5/17 2:29 PM.
 */
public class RelevanceScoreCalculator {

    public static void main(String[] args) {


        ReviewDimension dimension = getDimension2();

        BigDecimal score = getScore(dimension);

        System.out.println(score);

    }


    public static BigDecimal getScore(ReviewDimension dimension) {

        Double score = 0D;

        Double createdDays = dimension.getCreatedDays();

        Double imageScore = 0D;
        if (dimension.getImageCount() > 0) {
            if (createdDays < 30) {
                imageScore = 15D;
            } else if (createdDays < 60) {
                imageScore = 10D;
            } else {
                imageScore = 5D;
            }
        }

        imageScore += dimension.getImageCount() / 6 * 15;//30
        //time max=20
        score += imageScore;

        Double timeScore = 0D;
        if (dimension.getCreatedDays() < 0) {
            timeScore += 5D;
        } else if (dimension.getCreatedDays() <= 30) {
            timeScore = 15 - dimension.getCreatedDays() / 6;

        } else if (dimension.getCreatedDays() <= 365) {
            timeScore = 10 - 5 * dimension.getCreatedDays() / 365;
        } else {
            timeScore = 5 * 365 / dimension.getCreatedDays();
        }
        score += timeScore;//20

        Double upVotes = dimension.getUpVotes();
        Double downVotes = dimension.getDownVotes();

        if (upVotes < 0) {
            upVotes = 0D;
        }
        if (dimension.getDownVotes() < 0) {
            downVotes = 0D;
        }
        Double allVotes = downVotes + upVotes;
        Double voteScore = 0D;
        if (allVotes.longValue() > 1000) {
            voteScore = (upVotes.doubleValue() / allVotes) * 20;
        } else if (allVotes.longValue() > 100) {
            voteScore = upVotes.doubleValue() / (allVotes + 1) * 10;
        } else {
            voteScore = upVotes.doubleValue() / (allVotes + 1) * 5;
        }
        score += voteScore;//20
        if (dimension.isSellerReplied()) {
            score += 10;//10
        }
        if (!dimension.isExternalReview()) {
            score += 10;//10
        }

        Double contentScore = 0D;
        if (dimension.getReviewContentLength() > 10) {
            contentScore += 7.5;
        }
        contentScore += (Math.min(100, dimension.getReviewContentLength()) / 100) * 7.5;//10
        score += contentScore;
        BigDecimal result = null;
        try {
            result = BigDecimal.valueOf(score).setScale(2, BigDecimal.ROUND_HALF_UP);
        } catch (Exception ex) {
            System.out.println("error!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        return result == null ? BigDecimal.ZERO : result;
    }

    private static ReviewDimension getDimension2() {
        ReviewDimension dimension = new ReviewDimension();

        dimension.setReviewContentLength(108.0);
        dimension.setImageCount(0.0);
        dimension.setSellerReplied(false);
        dimension.setBuyerFollowed(false);
        dimension.setUpVotes(108.0);
        dimension.setDownVotes(0.0);
        dimension.setExternalReview(true);
        dimension.setRating(5);
        dimension.setCreatedDays(877.0);
        return dimension;
    }


    private static ReviewDimension getDimension1() {
        ReviewDimension dimension = new ReviewDimension();

        dimension.setReviewContentLength(6.0);
        dimension.setImageCount(0.0);
        dimension.setSellerReplied(false);
        dimension.setBuyerFollowed(false);
        dimension.setUpVotes(0.0);
        dimension.setDownVotes(1.0);
        dimension.setExternalReview(false);
        dimension.setRating(5);
        dimension.setCreatedDays(1617.0);
        return dimension;
    }


}
