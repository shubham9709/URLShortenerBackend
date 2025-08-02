package com.practice.URLshortener.URLDao;

import com.practice.URLshortener.beans.URLBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLDao extends JpaRepository<URLBean,Integer> {
    URLBean findByUrl(String url);
}
