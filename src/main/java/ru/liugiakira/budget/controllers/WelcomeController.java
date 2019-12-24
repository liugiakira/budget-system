package ru.liugiakira.budget.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author k.yakovleva
 */
@Controller
public class WelcomeController {
    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Добро пожаловать в приложение для анализа расходов/доходов пользователя!";
    }
}
