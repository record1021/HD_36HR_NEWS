package com.hyd.hd_36hr_news.utils.entity;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/14 0014.
 */
public class CategoryBean implements Serializable {
    private String mTitle;
    private String  mHref;
    private String  mType;

    public CategoryBean(String mTitle, String mHrey, String mType) {
        this.mTitle = mTitle;
        this.mHref = mHref;
        this.mType = mType;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmHrey(String mHrey) {
        this.mHref = mHref;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }


    public String getmTitle() {
        return mTitle;
    }

    public String getmHref() {
        return mHref;
    }

    public String getmType() {
        return mType;
    }

    @Override
    public String toString() {
        return "CategoryBean{" +
                "mTitle='" + mTitle + '\'' +
                ", mHref='" + mHref + '\'' +
                ", mType='" + mType + '\'' +
                '}';
    }

    /**
     * 获取侧滑菜单 新闻分类数据
     * @param document
     * @return
     */
    public static List<CategoryBean> getCategoryBeanData(Document document) {
       List<CategoryBean> categoriesBeans = new ArrayList<CategoryBean>();
        Elements elements = document.select("div.categories").first().select("a");
        for(Element element:elements){
            String typeString = element.attr("data-type");
            String herfString = element.attr("href");
            String textString = element.text();
            categoriesBeans.add(new CategoryBean(textString,typeString,herfString));
        }
        return categoriesBeans;
    }


}
