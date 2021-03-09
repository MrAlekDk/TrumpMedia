package com.example.demo.models;

public class Post {

    public String title;
    public String content;
    public String date;
    public boolean publicPost;




   public Post(String title, String content, String date, String publicOrPrivate){
        this.title=title;
        this.content=content;
        this.date= date;

        if(publicOrPrivate.equals("public")||publicOrPrivate.equals("null")){
            this.publicPost=true;
        }
        else{
            this.publicPost=false;
        }

    }



    @Override
    public String toString(){
        return "Title: " +this.title + "Content "+ this.content;
    }


}
