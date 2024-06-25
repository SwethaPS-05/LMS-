
package com.pets.petsdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class TestController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserleavesRepository leavesRepo;

    private UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    //handler method
    @GetMapping("/users")
    public String listUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "index";

    }

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("user", new Userdtls());
        return "loginpage.html";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Userdtls user, HttpSession session,
            Model model) {
        // System.out.println(user);

        repo.save(user);
        session.setAttribute("message", "User Registered Successfully...");
        model.addAttribute("message", "User Registered Successfully...");

        return "redirect:http://localhost:8080/test";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute Userleaves leave, @RequestParam("file") MultipartFile file,
            HttpSession session, Model model) {
        System.out.println(leave);
        leavesRepo.save(leave);

        if (!file.isEmpty()) {
            try {
                String filename = file.getOriginalFilename();

                Path path = Paths.get("petsdemo\\src\\main\\resources\\uploads\\" + filename);

                Files.write(path, file.getBytes());

                leave.setFilePath(path.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        session.setAttribute("message", "User Leave Registered Successfully...");
        model.addAttribute("message", "User Leave Registered Successfully...");
        return "redirect:http://localhost:8080/test";
    }

    

}
