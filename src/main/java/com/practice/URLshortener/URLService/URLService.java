package com.practice.URLshortener.URLService;

import com.practice.URLshortener.URLDao.URLDao;
import com.practice.URLshortener.beans.URLBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class URLService {
    @Autowired
    private URLDao urlDao;
    @Autowired
    private Optional<URLBean> urlBean;
    public int saveURL(URLBean urlBean) {
        URLBean obj=null;

        if (urlDao.findByUrl(urlBean.getUrl()) == null) {

            obj = urlDao.save(urlBean);
        }
        else{
            obj=urlDao.findByUrl(urlBean.getUrl());
        }

        return obj.getId();
    }

    public String getShortenedURL(int id) {
        urlBean=urlDao.findById(id);
        return urlBean.isPresent()?urlBean.get().getUrl():null;
    }
}
