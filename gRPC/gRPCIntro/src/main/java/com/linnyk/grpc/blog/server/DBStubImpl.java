package com.linnyk.grpc.blog.server;

import com.proto.blog.Blog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DBStubImpl {

    private Map<String, Blog> blogs = new ConcurrentHashMap<>();

    private AtomicInteger idCounter = new AtomicInteger();

    public Blog create(Blog blog) {
        int blogId = idCounter.incrementAndGet();
        Blog newBlog = Blog.newBuilder()
                .setId(String.valueOf(blogId))
                .setAuthorId(blog.getAuthorId())
                .setTitle(blog.getTitle())
                .setContent(blog.getContent())
                .build();
        blogs.put(newBlog.getId(), newBlog);

        return newBlog;
    }

    public Blog get(String id) {
        return blogs.get(id);
    }
}
