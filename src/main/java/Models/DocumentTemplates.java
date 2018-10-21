package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DocumentTemplates {
    private Integer id;
    private String name;
    private String documentText;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DocumentText", nullable = false, length = 10000)
    public String getDocumentText() {
        return documentText;
    }

    public void setDocumentText(String documentText) {
        this.documentText = documentText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentTemplates that = (DocumentTemplates) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(documentText, that.documentText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, documentText);
    }
}
