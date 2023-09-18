package by.itclass.controllers;

import by.itclass.model.entities.User;
import by.itclass.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static by.itclass.constants.AppConstants.*;

@Controller
public class UserController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = ALL_USER_URL)
    public String all(Model model) {
        List<User> users = service.getAllUsers();
        model.addAttribute(USER_LIST_ATTR, users);
        return USERS_PAGE;
    }

    @GetMapping(value = DELETE_USER_URL)
    public String delete(int id) {
        service.deleteById(id);
        return INDEX_PAGE;
    }
}
