package be.nicholas.api.honk.resource.out;

public class HonkRequestResource {
    private HonkCommandRequestResource honkAndFlashRequest;

    public HonkCommandRequestResource getHonkAndFlashRequest() {
        return honkAndFlashRequest;
    }

    public void setHonkAndFlashRequest(HonkCommandRequestResource honkAndFlashRequest) {
        this.honkAndFlashRequest = honkAndFlashRequest;
    }
}
