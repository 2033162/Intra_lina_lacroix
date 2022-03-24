package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "post")
    @ToString.Exclude
    private PostComment postComment;

    @OneToOne
    private PostUser commentateur;

    public PostComment(PostUser commentateur, String comment) {
        this.commentateur = commentateur;
        this.comment = comment;
    }

    public PostComment(String postComment) {
    }

    public PostUser getCommentateur() {
        return commentateur;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", commentateur=" + commentateur +
                ", comment='" + comment + '\'' +
                '}';
    }
}
