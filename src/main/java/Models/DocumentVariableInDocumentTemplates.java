package Models;

import javax.persistence.*;

@Entity
public class DocumentVariableInDocumentTemplates {
    private DocumentVariable documentVariableByDocumentVariableId;
    private DocumentTemplates documentTemplatesByDocumentTemplatesId;

    @ManyToOne
    @JoinColumn(name = "DocumentVariableID", referencedColumnName = "ID", nullable = false)
    public DocumentVariable getDocumentVariableByDocumentVariableId() {
        return documentVariableByDocumentVariableId;
    }

    public void setDocumentVariableByDocumentVariableId(DocumentVariable documentVariableByDocumentVariableId) {
        this.documentVariableByDocumentVariableId = documentVariableByDocumentVariableId;
    }

    @ManyToOne
    @JoinColumn(name = "DocumentTemplatesID", referencedColumnName = "ID", nullable = false)
    public DocumentTemplates getDocumentTemplatesByDocumentTemplatesId() {
        return documentTemplatesByDocumentTemplatesId;
    }

    public void setDocumentTemplatesByDocumentTemplatesId(DocumentTemplates documentTemplatesByDocumentTemplatesId) {
        this.documentTemplatesByDocumentTemplatesId = documentTemplatesByDocumentTemplatesId;
    }

    private String this_id;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public String getThis_id() {
        return this_id;
    }

    public void setThis_id(String this_id) {
        this.this_id = this_id;
    }
}
