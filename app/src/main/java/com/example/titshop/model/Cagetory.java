package com.example.titshop.model;

import java.io.Serializable;

public class Cagetory implements Serializable {
    String idtype;
    String nametype;
    String linkimg;
    String description;
    public Cagetory() {
    }

    public Cagetory(String idtype, String nametype, String linkimg, String description) {
        this.idtype = idtype;
        this.nametype = nametype;
        this.linkimg = linkimg;
        this.description = description;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype;
    }

    public String getNametype() {
        return nametype;
    }

    public void setNametype(String nametype) {
        this.nametype = nametype;
    }

    public String getLinkimg() {
        return linkimg;
    }

    public void setLinkimg(String linkimg) {
        this.linkimg = linkimg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
