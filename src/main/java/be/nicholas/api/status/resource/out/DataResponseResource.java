package be.nicholas.api.status.resource.out;

import java.util.List;

public class DataResponseResource {
    private String id;
    private List<FieldResponseResource> field;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<FieldResponseResource> getField() {
        return field;
    }

    public void setField(List<FieldResponseResource> field) {
        this.field = field;
    }
}
