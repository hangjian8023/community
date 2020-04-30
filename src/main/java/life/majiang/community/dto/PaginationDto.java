package life.majiang.community.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaginationDto {
    private List<QuestionDto> questionDtos;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;

    private Integer page;
    private List<Integer> pages;

    public void setPagination(Integer totalCount, Integer page, Integer size) {
        int totalPage = (int)Math.ceil((double) totalCount / size);
        // 是否展示上一页
        if (page == 1)
            showFirstPage = false;
        else
            showFirstPage = true;
        // 是否展示下一页
        if (page == totalPage)
            showEndPage = false;
        else
            showEndPage = true;
    }
}
