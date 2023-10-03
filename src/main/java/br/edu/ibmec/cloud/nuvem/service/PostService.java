package br.edu.ibmec.cloud.nuvem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import br.edu.ibmec.cloud.nuvem.model.Post;
import br.edu.ibmec.cloud.nuvem.repository.PostRepository;
import jakarta.el.ELException;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post create(Post post){
        return this.postRepository.save(post);
    }

    public Optional<Post> getById(long id){
        return this.postRepository.findById(id);
    }

    public List<Post> getAll(){
        return this.postRepository.findAll();
    }

    public void saveOrUpdate(Post item){
        this.postRepository.save(item);
    }

    public Post update(long id, Post newData) throws ELException {
        Optional<Post> opPost = this.postRepository.findById(id);

        if(opPost.isPresent() == false){
            throw new ELException("não encontrei o post a ser atualizado");        
        }

        Post post = opPost.get();
        post.setTitle(newData.getTitle());
        post.setText(newData.getText());
        post.setAuthor(newData.getAuthor());
        post.setDtPublicacao(newData.getDtPublicacao());

        this.postRepository.save(post);

        return post;
    }

    public void delete(long id) throws ELException{
        Optional<Post> opPost = this.postRepository.findById(id);

        if(opPost.isPresent() == false){
            throw new ELException("não encontrei o post a ser atualizado");        
        }

        this.postRepository.delete(opPost.get());
    }

}
