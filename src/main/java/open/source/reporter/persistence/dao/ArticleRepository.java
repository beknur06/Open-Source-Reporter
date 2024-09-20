package open.source.reporter.persistence.dao;

import open.source.reporter.persistence.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

    Slice<Article> findAll(Pageable pageable);
}
