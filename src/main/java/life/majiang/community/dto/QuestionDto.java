package life.majiang.community.dto;

import life.majiang.community.model.User;
import lombok.Data;

/**
 * @author donghj
 * @version 1.0
 * @date 2020/4/28 0:02
 */
@Data
public class QuestionDto {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private User user;
}
