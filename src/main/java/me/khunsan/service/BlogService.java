package me.khunsan.service;

import lombok.RequiredArgsConstructor;
import me.khunsan.domain.Article;
import me.khunsan.dto.AddArticleRequest;
import me.khunsan.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {

//    @Autowired
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest dto) {
        return blogRepository.save(dto.toEntity());
    }
}
