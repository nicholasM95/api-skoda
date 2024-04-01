package be.nicholas.api.host.resource.out;

public class BaseUriResponseResource {
    private String systemId;
    private String content;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
