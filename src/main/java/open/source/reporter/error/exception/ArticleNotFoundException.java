package open.source.reporter.error.exception;

public class ArticleNotFoundException extends NotFoundException {

    public ArticleNotFoundException(Long id) {
        super("an article", id);
    }
}
