package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String postData;
    private Date dateTime;

    @OneToMany(mappedBy = "postComment")
    private List<PostComment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "postUser")
    @ToString.Exclude
    private PostUser postUser;

    public Post(String postData, PostUser user, Date dateTime, List<PostComment> comments) {
        this.postData = postData;
        this.postUser = user;
        this.dateTime = dateTime;
        this.comments = comments;
    }

    public Post(long id, String comment) {
    }

    public PostUser getPostUser() {
        return postUser;
    }

    public String getPostData() {
        return postData;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public List<PostComment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postData='" + postData + '\'' +
                ", user=" + postUser +
                ", dateTime=" + dateTime +
                ", comments=" + comments +
                '}';
    }
}
