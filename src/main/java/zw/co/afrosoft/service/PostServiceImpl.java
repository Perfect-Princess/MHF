package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.model.Post;
import zw.co.afrosoft.repository.PostRepo;
import zw.co.afrosoft.security.dto.PostRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public ResponseEntity createPost(PostRequest request) {
        Post post = new Post();
        post.setBody(request.getBody());
        post.setTitle(request.getTitle());
        post.setDatePosted(LocalDateTime.now());
//        post.setCreationDate(LocalDate.from(LocalDateTime.now()));
        return ResponseEntity.ok().body(postRepo.save(post));
    }
    @Override
    public ResponseEntity findAll() {
        List<Post> posts =  postRepo.findAll();
        return ResponseEntity.ok().body(posts);
    }

    @Override
    public ResponseEntity delete(Long id) {
        Optional<Post> post = postRepo.findById(id);
        if(post.isPresent())
        { postRepo.delete(post.get());
        return ResponseEntity.ok().body("Deleted post successfully");}

        return ResponseEntity.ok().body("Post not available");
    }
}
