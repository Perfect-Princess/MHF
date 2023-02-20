package zw.co.afrosoft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.security.dto.PostRequest;
import zw.co.afrosoft.service.PostService;

@CrossOrigin
@RestController

@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/createPost")
    ResponseEntity createPost(@RequestBody PostRequest postRequest){
        return postService.createPost(postRequest);
    }

    @GetMapping("/findAll")
    ResponseEntity findAll(){
        return postService.findAll();
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity delete(@PathVariable Long id){
        return postService.delete(id);
    }
}
