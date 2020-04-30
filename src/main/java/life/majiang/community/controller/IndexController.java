package life.majiang.community.controller;

import life.majiang.community.dto.PaginationDto;
import life.majiang.community.dto.QuestionDto;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author donghj
 * @version 1.0
 * @date 2020/4/25 23:23
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    /**
     * 持久化存储cookie
     * 从HttpServletRequest中获取cookie，遍历cookie从中取出token，通过token在user表中查找对应的user，将user存储到session中
     * @param request request请求
     * @return 页面
     */
    @GetMapping({"/index", "/"})
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        // 查找所有question信息，并且保存至questionDtos
        PaginationDto paginationDto = questionService.findAll(page, size);
        model.addAttribute("paginationDto", paginationDto);
        return "index";
    }
}
