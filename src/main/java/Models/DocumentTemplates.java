package Models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class DocumentTemplates {
    private Integer id;
    private String name;
    private String documentText;
    private Date lastUpdate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "DocumentText", nullable = false, columnDefinition="TEXT")
    public String getDocumentText() {
        return documentText;
    }

    public void setDocumentText(String documentText) {
        this.documentText = documentText;
    }

    @Basic
    @Column(name = "LastUpdate", nullable = false)
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
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
