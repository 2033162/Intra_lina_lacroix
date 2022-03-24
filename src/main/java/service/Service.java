package service;

import model.Post;
import persistence.PostDaoJPAH2;

public class Service {
    private PostDaoJPAH2 dao;

    public Service(PostDaoJPAH2 dao) {
        this.dao = dao;
    }

    public long addUser(String userName) {
        return dao.addUser(userName);
    }

    public long addPost(long posteurId, String post) {
        return dao.addPost(posteurId, post);
    }

    public void addComment(long commenteurId, long postId, String commentaire) {
        dao.addComment(commenteurId, postId, commentaire);
    }

    public Post getPost(long postId) {
        return dao.getPost(postId);
    }
}
