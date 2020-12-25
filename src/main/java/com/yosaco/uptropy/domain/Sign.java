package com.yosaco.uptropy.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Sign")
public class Sign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String signature;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Account user;
    @NonNull
    @OneToOne(mappedBy = "signature")
    private Certificate certificate;
    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @NonNull
    private String address;

    public Sign() {
    }

    public Sign(@NonNull String signature, @NonNull Account user, @NonNull Certificate certificate, @NonNull Date timestamp, @NonNull String address) {
        this.signature = signature;
        this.user = user;
        this.certificate = certificate;
        this.timestamp = timestamp;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getSignature() {
        return signature;
    }

    public void setSignature(@NonNull String signature) {
        this.signature = signature;
    }

    @NonNull
    public Account getUser() {
        return user;
    }

    public void setUser(@NonNull Account user) {
        this.user = user;
    }

    @NonNull
    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(@NonNull Certificate certificate) {
        this.certificate = certificate;
    }

    @NonNull
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NonNull Date timestamp) {
        this.timestamp = timestamp;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }
}
