package com.example.demo.services;

import com.example.demo.models.Post;

import java.util.ArrayList;

public class PostManager {

    ArrayList<Post> publicPosts;
    ArrayList<Post> privatePosts;

    public PostManager(){
        publicPosts = new ArrayList<Post>();
        privatePosts = new ArrayList<Post>();
    }

    public void createPost(String title, String content, String date, String status){

        try{
            Post newPost = new Post(title,content,date,status);
            if(newPost.publicPost==true){
                publicPosts.add(newPost);
            }
            else{
                privatePosts.add(newPost);
            }
        }catch(NullPointerException fejl){
            System.out.println("User is null");
        }

    }

    public ArrayList<Post> getPublicPosts(){
        return this.publicPosts;
    }

}
