package com.codegirl;

import com.codegirl.model.Person;
import com.codegirl.model.Post;
import com.codegirl.model.PostDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by Şeyma Yılmaz on 2.8.2017.
 */
public class HibernateTest {
    public static void main(String[] args) {

        Configuration configuration=new Configuration();
        configuration.configure();


        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();


        session.beginTransaction();

        Post post = new Post();
        post.setTitle("Doğum günü kutlaması");
        post.setContent("içerik");

        PostDetails postDetails = new PostDetails();
        postDetails.setCreatedBy("Şeyma");
        postDetails.setDate(new Date());
        postDetails.setLocation("Kocaeli");

        /* */
        post.setPostDetails(postDetails);
        //postDetails.setPost(post);

        session.save(post);
        session.save(postDetails);

        Post post1 = session.find(Post.class, 1L);


        Person person1 = new Person();
        person1.setName("Şeyma");
        person1.setAge(23);
        person1.setGender(Gender.FEMALE);

        session.save(person1);

        session.getTransaction().commit();
        session.close();
    }
}
