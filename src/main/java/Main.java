import model.Post;
import persistence.PostDaoJPAH2;
import service.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Post");

        Service service = new Service(new PostDaoJPAH2(emf));

        var posteurId = service.addUser("Posteur1");
        var commenteurId = service.addUser("Commentateur");
        var postId = service.addPost(posteurId, "Mon premier post");
        service.addComment(commenteurId, postId, "Mon commentaire 1");

        final Post post = service.getPost(postId);
        System.out.println(post);
    }
}
