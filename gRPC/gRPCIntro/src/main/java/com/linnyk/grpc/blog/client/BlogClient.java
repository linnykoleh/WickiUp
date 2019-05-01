package com.linnyk.grpc.blog.client;

import com.proto.blog.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class BlogClient {

    public static void main(String[] args) {
        System.out.println("Hello BlogClient");

        new BlogClient().run();
    }

    private void run() {
        // Create channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        System.out.println("Creating stub");

        // Synchronous client
        BlogServiceGrpc.BlogServiceBlockingStub blogService = BlogServiceGrpc.newBlockingStub(channel);

        System.out.println("Client creates blog");
        Blog blog = Blog.newBuilder()
                .setAuthorId("Oleh")
                .setTitle("New blog")
                .setContent("Hello world from new blog!!!")
                .build();
        CreateBlogRequest blogCreateRequest = CreateBlogRequest.newBuilder()
                .setBlog(blog)
                .build();

        CreateBlogResponse blogCreateResponse = blogService.createBlog(blogCreateRequest);
        Blog createdBlog = blogCreateResponse.getBlog();
        System.out.println("Response for create blog from server is \n" + createdBlog);

        try {
            System.out.println("Client reads blog");
            ReadBlogRequest readBlogRequest = ReadBlogRequest.newBuilder()
                    .setBlogId(createdBlog.getId())
                    .build();
            ReadBlogResponse blogResponse = blogService.readBlog(readBlogRequest);
            System.out.println("Response for get blog from server is \n" + blogResponse);
        } catch (Exception e) {
            //o.grpc.StatusRuntimeException: NOT_FOUND: Blog with id not found
            e.printStackTrace();
        }

        channel.shutdown();
    }

}
