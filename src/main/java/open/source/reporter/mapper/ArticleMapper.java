package open.source.reporter.mapper;

import open.source.reporter.dto.ArticleDto;
import open.source.reporter.dto.ArticleUpdateDto;
import open.source.reporter.persistence.entity.Article;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ArticleMapper {

    ArticleDto toArticleDto(Article source);

    Article toArticle(ArticleDto source);

    void toArticle(ArticleUpdateDto source, @MappingTarget Article target);
}
