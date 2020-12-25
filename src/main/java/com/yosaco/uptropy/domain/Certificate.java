package com.yosaco.uptropy.domain;

import javax.persistence.*;

@Entity
@Table(name = "Certificate")
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String hashObject;
    private String address;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "signature_id", referencedColumnName = "id")
    private Sign signature;

    public Certificate() {
    }

    public Certificate(String name, String hashObject, String address, Sign signature) {
        this.name = name;
        this.hashObject = hashObject;
        this.address = address;
        this.signature = signature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashObject() {
        return hashObject;
    }

    public void setHashObject(String hashObject) {
        this.hashObject = hashObject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Sign getSignature() {
        return signature;
    }

    public void setSignature(Sign signature) {
        this.signature = signature;
    }
}
