package life.majiang.community.model;

import lombok.Data;

/**
 * @author donghj
 * @version 1.0
 * @date 2020/4/26 23:32
 */

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
