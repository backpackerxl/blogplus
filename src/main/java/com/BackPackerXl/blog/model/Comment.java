package com.BackPackerXl.blog.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/5/005
 * Time: 13:28
 **/

@Entity
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avater;
    @Temporal(TemporalType.TIMESTAMP)
    private Date cretateTime;
    @ManyToOne
    private Blog blog;
    @OneToMany
    private List<Comment> replyComment = new ArrayList<>();
    @ManyToOne
    private Comment parentComment;

    private boolean adminComent;

    public boolean isAdminComent() {
        return adminComent;
    }

    public void setAdminComent(boolean adminComent) {
        this.adminComent = adminComent;
    }

    public List<Comment> getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(List<Comment> replyComment) {
        this.replyComment = replyComment;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Comment() {
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public Date getCretateTime() {
        return cretateTime;
    }

    public void setCretateTime(Date cretateTime) {
        this.cretateTime = cretateTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avater='" + avater + '\'' +
                ", cretateTime=" + cretateTime +
                ", blog=" + blog +
                ", replyComment=" + replyComment +
                ", parentComment=" + parentComment +
                ", adminComent=" + adminComent +
                '}';
    }
}
