package me.khunsan.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.khunsan.domain.Article;
import me.khunsan.dto.AddArticleRequest;
import me.khunsan.dto.UpdateArticleRequest;
import me.khunsan.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

//    @Autowired
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest dto) {
        return blogRepository.save(dto.toEntity());
    }

    public List<Article> getAll() {
        return blogRepository.findAll();
    }

    public Article getById(Long id) {
        return blogRepository.findById(id).get();
    }

    public void deleteArticel(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        article.update(request.getTitle(), request.getContent());
        return article;
    }

//    public Article updateArticle(Long id, UpdateArticleRequest request) {
//        Article article = blogRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("그런 블로그 글은 존재하지 않음["+id+"]"));
//        article.update(request.getTitle(), request.getContent());
//        blogRepository.save(article);
//        return article;
//    }

}
