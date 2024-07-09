package com.pets.petsdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserleavesRepository leavesRepo;

    private UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    // Handler method for listing users
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<Userdtls> users = userService.getAllUsers();
        model.addAttribute("users", users);
        logger.info("Fetched Users: " + users);
        return "index";
    }

    // @RequestMapping("/delete/{id}")
    // public String deletestudent(@PathVariable(name = "id") int id) {
    // UserService.delete(id);
    // return "redirect:/";
    // }

    @GetMapping("/leaves")
    public String listLeaves(Model model) {
        List<Userleaves> leaves = userService.getAllUserLeaves();
        model.addAttribute("leaves", leaves);
        return "index";
    }

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("user", new Userdtls());
        return "loginpage.html";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Userdtls user, HttpSession session, Model model) {
        repo.save(user);
        session.setAttribute("message", "User Registered Successfully...");
        model.addAttribute("message", "User Registered Successfully...");
        return "redirect:/users";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute Userleaves leave, @RequestParam MultipartFile file, HttpSession session,
            Model model) {
        leavesRepo.save(leave);

        if (!file.isEmpty()) {
            try {
                String filename = file.getOriginalFilename();
                Path path = Paths.get("petsdemo/src/main/resources/uploads/" + filename);
                Files.write(path, file.getBytes());
                leave.setFilePath(path.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        session.setAttribute("message", "User Leave Registered Successfully...");
        model.addAttribute("message", "User Leave Registered Successfully...");
        return "redirect:/leaves";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable int id, Model model) {
        Userdtls user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edituser";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute Userdtls user, HttpSession session, Model model) {
        userService.saveUser(user);
        session.setAttribute("message", "User updated successfully.");
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}