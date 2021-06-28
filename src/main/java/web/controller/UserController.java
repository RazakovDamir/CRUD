package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String Hello() {
        return "index";
    }

    @GetMapping(value = "/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users" , userService.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/create")
    public String addUserForm(@ModelAttribute("user") User user) {
        return "create";
    }

    @PostMapping(value = "/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping(value = "/update/{id}")
    public String updateUser(@ModelAttribute("user") User user, Model model) {
        userService.update(user);
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/users";
    }

    //DeleteMapping вызывает  ошибку 405
    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}