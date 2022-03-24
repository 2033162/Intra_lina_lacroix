package persistence;

import model.Post;

public interface PostDao {
    <T> void save(T t);

    long addUser(String userName);

    long addPost(long posteurId, String post);

    void addComment(long commenteurId, long postId, String commentaire);

    Post getPost(long postId);
}
