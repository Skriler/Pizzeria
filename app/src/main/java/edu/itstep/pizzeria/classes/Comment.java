package edu.itstep.pizzeria.classes;

public class Comment {
    private String commentatorName;
    private int rating;
    private String review;

    public Comment() { }

    public Comment(String commentatorName, int rating, String review) {
        this.commentatorName = commentatorName;
        this.rating = rating;
        this.review = review;
    }

    public String getCommentatorName() {
        return commentatorName;
    }

    public void setCommentatorName(String commentatorName) {
        this.commentatorName = commentatorName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
