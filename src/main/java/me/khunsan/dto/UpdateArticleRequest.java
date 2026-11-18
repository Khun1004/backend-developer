package me.khunsan.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UpdateArticleRequest {
    private String title;
    private String content;

//    public UpdateArticleRequest (String title, String content) {
//        this.title = title;
//        this.content = content;
//    }

//    public String getTitle() {return this.title};
//    public String getContent() {return this.content}
}
