package me.khunsan.service;

import lombok.RequiredArgsConstructor;
import me.khunsan.domain.Article;
import me.khunsan.dto.AddArticleRequest;
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
}
