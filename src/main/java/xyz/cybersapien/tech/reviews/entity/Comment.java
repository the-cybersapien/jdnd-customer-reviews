package xyz.cybersapien.tech.reviews.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 255, min = 10)
    @NotNull(message = "Title can't be blank for a comment")
    private String title;

    @Size(max = 5000, min = 1)
    @NotNull(message = "Text can't be blank for a comment")
    private String commentText;

    @ManyToOne
    private Review review;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", commentText='" + commentText + '\'' +
                ", review=" + review +
                '}';
    }
}
