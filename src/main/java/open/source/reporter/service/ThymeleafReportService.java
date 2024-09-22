package open.source.reporter.service;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.IOException;
import java.io.OutputStream;

@Service
public class ThymeleafReportService {

    private final TemplateEngine templateEngine;
    private static String FONT_LOCATION = "templates/fonts/TNR.ttf";

    @Autowired
    public ThymeleafReportService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public void writePdf(String template, String dataPropertyName, Object data, OutputStream outputStream) throws DocumentException, IOException {
        var context = new Context();
        context.setVariable(dataPropertyName, data);
        String html = templateEngine.process(template, context);
        generatePdfFromHtml(html, outputStream);
    }

    private void generatePdfFromHtml(String html, OutputStream outputStream) throws DocumentException, IOException {
        var renderer = new ITextRenderer();
        renderer.getFontResolver().addFont(FONT_LOCATION, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);
    }
}