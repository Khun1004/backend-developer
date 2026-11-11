package me.khunsan.dto;

import lombok.Getter;
import me.khunsan.domain.Article;

@Getter
public class ArticleResponse extends Article {

    private String title;
    private String content;

    public ArticleResponse(Article entity) {
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }

}
