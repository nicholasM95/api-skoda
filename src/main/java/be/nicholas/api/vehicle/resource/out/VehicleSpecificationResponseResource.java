package be.nicholas.api.vehicle.resource.out;

public class VehicleSpecificationResponseResource {
    private String title;
    private String brand;
    private String model;
    private String body;
    private String systemCode;
    private String systemModelId;
    private VehicleEngineResponseResource engine;
    private VehicleGearboxResponseResource gearbox;
    private String trimLevel;
    private String manufacturingDate;
    private String devicePlatform;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemModelId() {
        return systemModelId;
    }

    public void setSystemModelId(String systemModelId) {
        this.systemModelId = systemModelId;
    }

    public VehicleEngineResponseResource getEngine() {
        return engine;
    }

    public void setEngine(VehicleEngineResponseResource engine) {
        this.engine = engine;
    }

    public VehicleGearboxResponseResource getGearbox() {
        return gearbox;
    }

    public void setGearbox(VehicleGearboxResponseResource gearbox) {
        this.gearbox = gearbox;
    }

    public String getTrimLevel() {
        return trimLevel;
    }

    public void setTrimLevel(String trimLevel) {
        this.trimLevel = trimLevel;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getDevicePlatform() {
        return devicePlatform;
    }

    public void setDevicePlatform(String devicePlatform) {
        this.devicePlatform = devicePlatform;
    }
}
