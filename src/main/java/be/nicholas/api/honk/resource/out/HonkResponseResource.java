package be.nicholas.api.honk.resource.out;

public class HonkResponseResource {
    private HonkCommandResponseResource honkAndFlashRequest;

    public HonkCommandResponseResource getHonkAndFlashRequest() {
        return honkAndFlashRequest;
    }

    public void setHonkAndFlashRequest(HonkCommandResponseResource honkAndFlashRequest) {
        this.honkAndFlashRequest = honkAndFlashRequest;
    }
}
