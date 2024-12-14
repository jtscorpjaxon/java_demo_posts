package uz.mohirdev.mohirdev.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import uz.mohirdev.mohirdev.entity.PostData;
import uz.mohirdev.mohirdev.model.Post;
import uz.mohirdev.mohirdev.repository.PostDataRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostDataService {
    private final PostDataRepository postDataRepository;

    public PostDataService(PostDataRepository postDataRepository) {
        this.postDataRepository = postDataRepository;
    }

    public PostData save(PostData postData) {
        return postDataRepository.save(postData);
    }

    public List<PostData> saveAll(Post[] posts) {
        List<PostData> postDataList = new ArrayList<>();
        for (Post post : posts) {
            PostData postData = new PostData();
            postData.setPostId(post.getId());
            postData.setTitle(post.getTitle());
            postData.setBody(post.getBody());
            postData.setUserId(post.getUserId());
            postDataList.add(postData);
        }

       /* List<PostData> postDataList = posts
                .stream().map(post -> {
                    PostData postData = new PostData();
                    postData.setPostId(post.getId());
                    postData.setTitle(post.getTitle());
                    postData.setBody(post.getBody());
                    postData.setUserId(post.getUserId());
//                    save(postData);
                    return postData;
                }).collect(Collectors.toList());*/
        return postDataRepository.saveAll(postDataList);
    }

    @Transactional(readOnly = true)
    public Page<PostData> findAll(Pageable pageable) {
        return postDataRepository.findAll(pageable);
    }

}
