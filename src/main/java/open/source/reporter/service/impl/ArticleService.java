package open.source.reporter.service.impl;

import open.source.reporter.dto.ArticleDto;
import open.source.reporter.dto.ArticleUpdateDto;
import open.source.reporter.error.exception.ArticleNotFoundException;
import open.source.reporter.mapper.ArticleMapper;
import open.source.reporter.persistence.dao.ArticleRepository;
import open.source.reporter.persistence.entity.Article;
import open.source.reporter.service.IArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Transactional
    @Override
    public ArticleDto create(ArticleDto articleDto) {
        Article entity = articleMapper.toArticle(articleDto);
        Article savedEntity = articleRepository.save(entity);
        return articleMapper.toArticleDto(savedEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public ArticleDto read(Long id) {
        return articleRepository.findById(id)
            .map(articleMapper::toArticleDto)
            .orElseThrow(() -> new ArticleNotFoundException(id));
    }

    @Transactional
    @Override
    public ArticleDto update(Long id, ArticleUpdateDto articleUpdateDto) {
        return articleRepository.findById(id)
            .map(article -> {
                articleMapper.toArticle(articleUpdateDto, article);
                Article savedArticle = articleRepository.save(article);
                return articleMapper.toArticleDto(savedArticle);
            }).orElseThrow(() -> new ArticleNotFoundException(id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(id);
        } else throw new ArticleNotFoundException(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Slice<ArticleDto> getAll(Pageable pageable) {
        Slice<Article> pagedResult = articleRepository.findAll(pageable);
        return pagedResult.map(articleMapper::toArticleDto);
    }
}
