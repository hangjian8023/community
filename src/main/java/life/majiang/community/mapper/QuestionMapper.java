package life.majiang.community.mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author donghj
 * @version 1.0
 * @date 2020/4/26 23:30
 */
@Mapper
public interface QuestionMapper {

    @Insert("Insert into question(title, description, gmt_create, gmt_modified, creator, tag) " +
            "values(#{title}, #{description}, #{gmtCreate}, #{gmtModified}, #{creator}, #{tag})")
    void insertQuestion(Question question);

    @Select("select * from user where token=#{token}")
    Question findByQuestion(@Param("token") String token);

    @Select("select * from question")
    List<Question> findAll();
}
