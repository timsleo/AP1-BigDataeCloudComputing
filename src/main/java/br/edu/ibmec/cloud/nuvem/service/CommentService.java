package br.edu.ibmec.cloud.nuvem.service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ibmec.cloud.nuvem.model.Comment;
import br.edu.ibmec.cloud.nuvem.model.Post;
import br.edu.ibmec.cloud.nuvem.repository.CommentRepository;
import jakarta.el.ELException;


@Service
public class CommentService {

    @Autowired
    CommentRepository repository;

    @Autowired
    PostService postService;

    public List<br.edu.ibmec.cloud.nuvem.model.Comment> findAll() {
        return this.repository.findAll();
    }

    public Optional<Comment> findById(long id) {
        return this.repository.findById(id);
    }

    public Comment update(long id, Comment newData) throws Exception {
        Optional<Comment> opComment = this.repository.findById(id);

        if(opComment.isPresent() == false){
            throw new Exception("comentário não encontrado");
        }

        Comment comment = opComment.get();

        comment.setAuthor(newData.getAuthor());
        comment.setText(newData.getText());
        comment.setDtComment(newData.getDtComment());

        this.repository.save(comment);

        return comment;

    }

    public Comment save(long idPost, Comment item) throws Exception {
        Optional<Post> opPost = this.postService.getById(idPost);
        
        if(opPost.isPresent() == false)
            throw new Exception("post não encontrado");


            Post post = opPost.get();
            item.setPost(post);
            this.repository.save(item);

        return item;
    }

    public void delete(long id) throws ELException{
        Optional<Comment> opPost = this.repository.findById(id);

        if(opPost.isPresent() == false){
            throw new ELException("não encontrei o post a ser atualizado");        
        }

        this.repository.delete(opPost.get());
    }


}
