package com.jungs.springbootstart.controller;

import com.jungs.springbootstart.dao.Posts;
import com.jungs.springbootstart.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostsService postsService;

    @GetMapping("/{id}")
    public String save_post(@PathVariable("id") String id){
        postsService.savePostTest(id);
        return "save suecces";
    }

    @GetMapping("/list")
    public @ResponseBody List<Posts> get_post_list(){
        return postsService.getPostList();
    }
}
