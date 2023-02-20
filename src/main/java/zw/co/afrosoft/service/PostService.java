package zw.co.afrosoft.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.security.dto.PostRequest;

public interface PostService {

    ResponseEntity createPost(PostRequest request);
    ResponseEntity findAll();

    ResponseEntity delete(Long id);
}
