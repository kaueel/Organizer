package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DocumentVariable {
    private Integer id;
    private String name;
    private String objectPath;
    private Integer maxLength;
    private String valuesOptions;

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
    @Column(name = "ObjectPath", nullable = true, length = 200)
    public String getObjectPath() {
        return objectPath;
    }

    public void setObjectPath(String objectPath) {
        this.objectPath = objectPath;
    }

    @Basic
    @Column(name = "maxLength", nullable = true)
    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    @Basic
    @Column(name = "ValuesOptions", nullable = true, length = 10000)
    public String getValuesOptions() {
        return valuesOptions;
    }

    public void setValuesOptions(String valuesOptions) {
        this.valuesOptions = valuesOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentVariable that = (DocumentVariable) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(objectPath, that.objectPath) &&
                Objects.equals(maxLength, that.maxLength) &&
                Objects.equals(valuesOptions, that.valuesOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, objectPath, maxLength, valuesOptions);
    }
}
