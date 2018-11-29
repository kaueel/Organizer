package Controllers;

import Models.DocumentTemplates;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

public class TemplateCompile {

    private DocumentTemplates documentTemplates;
    private File outputFile;
    private TemplateHashVariables templateHashVariables = new TemplateHashVariables();

    public TemplateCompile(DocumentTemplates documentTemplates, File outputFile) {
        this.documentTemplates = documentTemplates;
        this.outputFile = outputFile;
    }

    public void compiler() throws IOException, DocumentException {
        for (String key: templateHashVariables.getKeys()) {
            documentTemplates.setDocumentText(documentTemplates.getDocumentText().replace("##"+key,templateHashVariables.getValue(key)));
        }

        int count = 2;

        File file = new File(outputFile.getPath()+"/"+documentTemplates.getName()+".pdf");

        while(file.exists())
        {
            file = new File(outputFile.getPath()+"/"+documentTemplates.getName()+" ("+count+").pdf");
            count++;
        }

        Document doc = new Document(PageSize.A4);

        OutputStream out = new FileOutputStream(file);

        PdfWriter.getInstance(doc, out);
        doc.open();
        HTMLWorker hw = new HTMLWorker(doc);
        hw.parse(new StringReader(documentTemplates.getDocumentText()));
        doc.close();
    }
}
