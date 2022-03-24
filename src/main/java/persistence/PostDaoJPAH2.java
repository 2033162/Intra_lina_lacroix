package persistence;

import model.Post;
import model.PostComment;
import model.PostUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PostDaoJPAH2 implements PostDao {
    EntityManagerFactory emf;

    public PostDaoJPAH2(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public <T> void save(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

    public long addUser(String userName) {
        PostUser user = new PostUser(userName);
        save(user);
        return user.getId();
    }

    public long addPost(long posteurId, String postComment) {
        Post post = new Post(posteurId, postComment);
        save(post);
        return posteurId;
    }

    public void addComment(long commenteurId, long postId, String commentaire) {
        PostComment postComment = new PostComment(commentaire);
        save(postComment);
    }

    public Post getPost(long postId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Post post = em.find(Post.class, postId);
        em.getTransaction().commit();
        em.close();
        return post;
    }
}
