package edu.itstep.pizzeria.services;

import java.util.ArrayList;

import edu.itstep.pizzeria.classes.Comment;

public class CommentService {
    private static final String FIRST_COMMENTATOR_NAME = "Lex";
    private static final String SECOND_COMMENTATOR_NAME = "Sahara";
    private static final String THIRD_COMMENTATOR_NAME = "Cole";
    private static final String FOURTH_COMMENTATOR_NAME = "Lilian";
    private static final String FIFTH_COMMENTATOR_NAME = "Finn";
    private static final String SIXTH_COMMENTATOR_NAME = "Ewan";

    private static final int FIRST_COMMENT_RATING = 8;
    private static final int SECOND_COMMENT_RATING = 6;
    private static final int THIRD_COMMENT_RATING = 9;
    private static final int FOURTH_COMMENT_RATING = 10;
    private static final int FIFTH_COMMENT_RATING = 7;
    private static final int SIXTH_COMMENT_RATING = 5;

    private static final String FIRST_COMMENT_REVIEW = "Lorem ipsum dolor sit amet, ut habeo nostro per.";
    private static final String SECOND_COMMENT_REVIEW = "Aeque zril libris id usu. Error nonumy constituam his ad, ex dicit tractatos est. ";
    private static final String THIRD_COMMENT_REVIEW = "Est ne malis vocibus copiosae, dicam graece argumentum no quo.";
    private static final String FOURTH_COMMENT_REVIEW = "Est euismod erroribus efficiantur ut. Ei eam aeterno appareat, vim harum legendos moderatius ut.";
    private static final String FIFTH_COMMENT_REVIEW = "Aliquam senserit pri ne, id zril doctus equidem has.";
    private static final String SIXTH_COMMENT_REVIEW = "Legendos indoctum corrumpit has eu, mutat complectitur pri an.";

    public static ArrayList<Comment> getComments() {
        ArrayList<Comment> comments = new ArrayList<>();

        comments.add(new Comment(FIRST_COMMENTATOR_NAME, FIRST_COMMENT_RATING, FIRST_COMMENT_REVIEW));
        comments.add(new Comment(SECOND_COMMENTATOR_NAME, SECOND_COMMENT_RATING, SECOND_COMMENT_REVIEW));
        comments.add(new Comment(THIRD_COMMENTATOR_NAME, THIRD_COMMENT_RATING, THIRD_COMMENT_REVIEW));
        comments.add(new Comment(FOURTH_COMMENTATOR_NAME, FOURTH_COMMENT_RATING, FOURTH_COMMENT_REVIEW));
        comments.add(new Comment(FIFTH_COMMENTATOR_NAME, FIFTH_COMMENT_RATING, FIFTH_COMMENT_REVIEW));
        comments.add(new Comment(SIXTH_COMMENTATOR_NAME, SIXTH_COMMENT_RATING, SIXTH_COMMENT_REVIEW));
        comments.add(new Comment(FIRST_COMMENTATOR_NAME, FIRST_COMMENT_RATING, FIRST_COMMENT_REVIEW));
        comments.add(new Comment(SECOND_COMMENTATOR_NAME, SECOND_COMMENT_RATING, SECOND_COMMENT_REVIEW));
        comments.add(new Comment(THIRD_COMMENTATOR_NAME, THIRD_COMMENT_RATING, THIRD_COMMENT_REVIEW));
        comments.add(new Comment(FOURTH_COMMENTATOR_NAME, FOURTH_COMMENT_RATING, FOURTH_COMMENT_REVIEW));
        comments.add(new Comment(FIFTH_COMMENTATOR_NAME, FIFTH_COMMENT_RATING, FIFTH_COMMENT_REVIEW));
        comments.add(new Comment(SIXTH_COMMENTATOR_NAME, SIXTH_COMMENT_RATING, SIXTH_COMMENT_REVIEW));

        return comments;
    }
}
