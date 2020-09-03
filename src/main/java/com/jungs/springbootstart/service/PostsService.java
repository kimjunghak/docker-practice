package com.jungs.springbootstart.service;

import com.jungs.springbootstart.dao.Posts;
import com.jungs.springbootstart.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    @Transactional
    public Posts getPost(Long id){
        return postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));
    }

    @Transactional
    public List<Posts> getPostList(){
        return postsRepository.findAll();
    }

    @Transactional
    public void savePost(String title, String content){
        Posts posts = new Posts();
        posts.setTitle(title);
        posts.setContent(content);
        postsRepository.save(posts);
    }

    @Transactional
    public void savePostTest(String id){
        Posts posts = new Posts();
        posts.setTitle("t"+id);
        posts.setContent("c"+id);
        postsRepository.save(posts);
    }
}
