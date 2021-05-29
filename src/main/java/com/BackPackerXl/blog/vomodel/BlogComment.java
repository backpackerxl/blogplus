package com.BackPackerXl.blog.vomodel;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/15/015
 * Time: 11:32
 **/
public class BlogComment {
    private String title;

    private String total;

    public BlogComment(String title, String total) {
        this.title = title;
        this.total = total;
    }

    public BlogComment() {
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BlogComment{" +
                "title='" + title + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
