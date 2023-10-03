package br.edu.ibmec.cloud.nuvem.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDateTime dtComment; 
    
    @Column(nullable = false)
    @NotBlank(message = "texto obrigatório para o comentário")
    private String text;

    @Column(nullable = false)
    @NotBlank(message = "usuário obrigatório")
    private String author;

    @ManyToOne
    @JsonIgnore
    private Post post;

    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDtComment() {
        return dtComment;
    }
    public void setDtComment(LocalDateTime dtComment) {
        this.dtComment = dtComment;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
