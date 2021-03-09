package com.example.demo.controllers;

import com.example.demo.services.PostManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrumpMediaController {
    private PostManager postManager = new PostManager();
    private String currentPage;


    @GetMapping(value = "/")
    public String renderMain(Model model) {
        currentPage="home";
        model.addAttribute("currentPage", currentPage);
        String userType= "premium";

        Boolean isUserLoggedIn = true;
        model.addAttribute("loggedIn", isUserLoggedIn);
        model.addAttribute("userType", userType);
        return "index.html";
    }

    @GetMapping(value="/about")
    public String renderAbout(Model model){
        currentPage="About";
        model.addAttribute("currentPage", currentPage);

        return "about.html";
    }

    @GetMapping(value="/dashboard")
    public String renderDashboard(Model model){
        currentPage="Dashboard";
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("posts", postManager.getPublicPosts());
        return "dashboard.html";
    }

    @PostMapping(value = "/submit")
    public String createPost(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("date") String date, @RequestParam("public-or-private") String status) {
            postManager.createPost(title, content, date, status);
        return "redirect:/dashboard";
    }

}
