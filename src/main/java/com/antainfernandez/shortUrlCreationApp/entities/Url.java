package com.antainfernandez.shortUrlCreationApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "url")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String originalUrl;

    public Url() {

    }

    public Url(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url = (Url) o;
        return id == url.id &&
                Objects.equals(originalUrl, url.originalUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originalUrl);
    }

    @Override
    public String toString() {
        return "Url{" + "id=" + this.id + ", originalUrl='" + this.originalUrl + '\'' + '}';
    }
}