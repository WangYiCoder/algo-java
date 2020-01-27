package study.review;

import lombok.Data;

@Data
public class ReviewDimension {
    private Double reviewContentLength = 0D;
    private Double imageCount = 0D;
    private boolean sellerReplied;
    private boolean buyerFollowed;
    private Double upVotes = 0D;
    private Double downVotes = 0D;
    private boolean isExternalReview;
    private Integer rating = 0;
    private Double createdDays = 0D;
    private Double createdSeconds = 0D;
    private Double createdMonthes = 0D;

}
