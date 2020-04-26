package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author donghj
 * @version 1.0
 * @date 2020/4/26 0:48
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.client.uri}")
    private String clientUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(clientUri);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        // 获取GitHub的accessToken
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user);
        if (user != null) {
            // 登录成功写cookie和session
            request.getSession().setAttribute("user", user);
        } else {
            // 登录失败，重新登录
        }
        return "redirect:index";
    }
}
