package com.example.crosspromotionlibrary;

/**
 * Created by SalmanHameed on 1/18/2019.
 */

public class NodeModel {
    String reference_application_link;
    String reference_application_gif_link;

    public NodeModel(String applicationLink, String applicationGifLink) {
        this.reference_application_link = applicationLink;
        this.reference_application_gif_link = applicationGifLink;
    }

    public NodeModel() {

    }

    public void setReference_application_link(String reference_application_link) {
        this.reference_application_link = reference_application_link;
    }

    public void setReference_application_gif_link(String reference_application_gif_link) {
        this.reference_application_gif_link = reference_application_gif_link;
    }

    public String getReference_application_link() {
        return reference_application_link;
    }

    public String getReference_application_gif_link() {
        return reference_application_gif_link;
    }
}
