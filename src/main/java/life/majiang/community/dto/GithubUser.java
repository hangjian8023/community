package life.majiang.community.dto;

import lombok.Data;

/**
 * @author donghj
 * @version 1.0
 * @date 2020/4/26 1:20
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
