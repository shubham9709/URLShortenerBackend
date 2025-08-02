package com.practice.URLshortener.beans;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name="url_mapping")
public class URLBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;

    public URLBean(){}

    public URLBean(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public void setUrl(String url){
        this.url=url;
    }

    public String getUrl(){
        return this.url;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return this.id;
    }


}
