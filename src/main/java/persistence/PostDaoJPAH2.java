package persistence;

import model.Post;
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
        save(userName);
        PostUser user = getUser(userName);
        return user.getId();
    }

    private PostUser getUser(String userName) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final PostUser user = em.find(PostUser.class, userName);
        em.getTransaction().commit();
        em.close();
        return user;
    }

    public long addPost(long posteurId, String postComment) {
        save(postComment);
        return posteurId;
    }

    public void addComment(long commenteurId, long postId, String commentaire) {
        save(commentaire);
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
