package com.linnyk.grpc.blog.client;

import com.proto.blog.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

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

        Blog createdBlog = createBlog(blogService);

        readBlog(blogService, createdBlog);
        listBlogs(blogService);
        updateBlog(blogService, createdBlog);
        deleteBlog(blogService, createdBlog);

        channel.shutdown();
    }

    private void listBlogs(BlogServiceGrpc.BlogServiceBlockingStub blogService) {
        System.out.println("Client gets list of blogs");

        Iterator<ListBlogResponse> listBlogResponseIterator = blogService.listBlog(ListBlogRequest.newBuilder().build());
        listBlogResponseIterator.forEachRemaining(System.out::println);
    }

    private void deleteBlog(BlogServiceGrpc.BlogServiceBlockingStub blogService, Blog createdBlog) {
        try {
            System.out.println("Client deletes blog");

            Blog blogForUpdate = Blog.newBuilder(createdBlog)
                    .setContent("This is updated blog content")
                    .build();

            DeleteBlogRequest deleteBlogRequest = DeleteBlogRequest.newBuilder()
                    .setBlogId(blogForUpdate.getId())
                    .build();

            DeleteBlogResponse deleteBlogResponse = blogService.deleteBlog(deleteBlogRequest);
            System.out.println("Response for delete blog from server is \n" + deleteBlogResponse);
        } catch (Exception e) {
            //o.grpc.StatusRuntimeException: NOT_FOUND: Blog with id not found
            e.printStackTrace();
        }
    }

    private void updateBlog(BlogServiceGrpc.BlogServiceBlockingStub blogService, Blog createdBlog) {
        try {
            System.out.println("Client updates blog");

            Blog blogForUpdate = Blog.newBuilder(createdBlog)
                    .setContent("This is updated blog content")
                    .build();

            UpdateBlogRequest updateBlogRequest = UpdateBlogRequest.newBuilder()
                    .setBlog(blogForUpdate)
                    .build();

            UpdateBlogResponse updateBlogResponse = blogService.updateBlog(updateBlogRequest);
            System.out.println("Response for update blog from server is \n" + updateBlogResponse);
        } catch (Exception e) {
            //o.grpc.StatusRuntimeException: NOT_FOUND: Blog with id not found
            e.printStackTrace();
        }
    }

    private Blog createBlog(BlogServiceGrpc.BlogServiceBlockingStub blogService) {
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

        return createdBlog;
    }

    private void readBlog(BlogServiceGrpc.BlogServiceBlockingStub blogService, Blog createdBlog) {
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
    }

}
