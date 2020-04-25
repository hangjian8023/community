package life.majiang.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author donghj
 * @version 1.0
 * @date 2020/4/25 23:23
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(@RequestParam(name = "name", defaultValue = "hello") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/")
    public String index1(@RequestParam(name = "name", defaultValue = "hello") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}
