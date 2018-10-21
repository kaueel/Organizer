package Models;

import javax.persistence.*;

@Entity
public class DocumentVariableInDocumentTemplates {
    private DocumentVariable documentVariableByDocumentVariableId;
    private DocumentTemplates documentTemplatesByDocumentTemplatesId;
    private Integer this_id;


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


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getThis_id() {
        return this_id;
    }

    public void setThis_id(Integer this_id) {
        this.this_id = this_id;
    }
}
