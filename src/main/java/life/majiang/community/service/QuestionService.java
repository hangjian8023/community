package life.majiang.community.service;

import life.majiang.community.dto.PaginationDto;
import life.majiang.community.dto.QuestionDto;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donghj
 * @version 1.0
 * @date 2020/4/28 0:03
 */
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDto findAll(Integer page, Integer size) {
        Integer offset = (page - 1) * size;
        System.out.println();
        List<Question> questions = questionMapper.findAll(offset, size);
        List<QuestionDto> questionDtos = new ArrayList<>();
        PaginationDto paginationDto = new PaginationDto();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question, questionDto);
            questionDto.setUser(user);
            questionDtos.add(questionDto);
        }
        paginationDto.setQuestionDtos(questionDtos);
        // 分页
        Integer totalCount = questionMapper.count();
        paginationDto.setPagination(totalCount, page, size);
        return paginationDto;
    }
}
