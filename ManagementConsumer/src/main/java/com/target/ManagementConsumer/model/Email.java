package com.target.ManagementConsumer.model;

public class Email {

    private Long emailId;
    private String emailFrom;
    private String emailPassword;
    private String emialTo;

    public Email() {
    }

    public Email(Long emailId, String emailFrom, String emailPassword, String emialTo) {
        this.emailId = emailId;
        this.emailFrom = emailFrom;
        this.emailPassword = emailPassword;
        this.emialTo = emialTo;
    }

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    public String getEmialTo() {
        return emialTo;
    }

    public void setEmialTo(String emialTo) {
        this.emialTo = emialTo;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId=" + emailId +
                ", emailFrom='" + emailFrom + '\'' +
                ", emailPassword='" + emailPassword + '\'' +
                ", emialTo='" + emialTo + '\'' +
                '}';
    }
}
