package me.khunsan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.khunsan.domain.Article;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddArticleRequest {
    private String title;
    private String content;

//    @Getter //(밑에 부분은 Getter를 import 하면 필요 없다.)
//    public String getTitle() {return title;}
//    public String getContent() {return content;}

//    @NoArgsConstructor //(밑에 부분은 NoArgsConstructor를 import 하면 필요 없다.)
//    public AddArticleRequest (){super();}


//    @AllArgsConstructor //(밑에 부분은 AllArgsConstructor를 import 하면 필요 없다.)
//    public AddArticleRequest(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }


    public Article toEntity() {
        return Article.builder().title(title).content(content).build();
    }

}
