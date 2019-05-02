package com.linnyk.grpc.blog.server;

import com.proto.blog.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.Objects;

public class BlogServiceImpl extends BlogServiceGrpc.BlogServiceImplBase {

    private final DBStubImpl dbStub = new DBStubImpl();

    @Override
    public void createBlog(CreateBlogRequest request, StreamObserver<CreateBlogResponse> responseObserver) {
        System.out.println("Creating blog request");

        Blog blogRequest = request.getBlog();
        Blog blogFromDB = dbStub.create(blogRequest);
        System.out.println("Inserted blog with id: " + blogFromDB.getId());

        CreateBlogResponse newBlog = CreateBlogResponse.newBuilder()
                .setBlog(blogFromDB)
                .build();

        responseObserver.onNext(newBlog);
        responseObserver.onCompleted();
    }

    @Override
    public void readBlog(ReadBlogRequest request, StreamObserver<ReadBlogResponse> responseObserver) {
        System.out.println("Reading blog request");

        String blogId = request.getBlogId();
        Blog blog = dbStub.read(blogId);

        if (Objects.isNull(blog)) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("Blog with id not found").asException());
        } else {
            responseObserver.onNext(ReadBlogResponse.newBuilder()
                    .setBlog(blog)
                    .build());
            responseObserver.onCompleted();
        }

    }

    @Override
    public void updateBlog(UpdateBlogRequest request, StreamObserver<UpdateBlogResponse> responseObserver) {
        System.out.println("Updating blog request");

        Blog blogRequestUpdate = request.getBlog();
        Blog blog = dbStub.read(blogRequestUpdate.getId());

        if (Objects.isNull(blog)) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("Blog with id not found").asException());
        } else {
            blog = Blog.newBuilder(blogRequestUpdate)
                    .build();
            dbStub.update(blog);
            System.out.println("Deleted blog with id: " + blog.getId());

            responseObserver.onNext(UpdateBlogResponse.newBuilder()
                    .setBlog(blog)
                    .build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteBlog(DeleteBlogRequest request, StreamObserver<DeleteBlogResponse> responseObserver) {
        System.out.println("Deleting blog request");

        String blogId = request.getBlogId();

        try {
            Blog removedBlog = dbStub.remove(blogId);
            System.out.println("Deleted blog with id: " + blogId);

            responseObserver.onNext(DeleteBlogResponse.newBuilder()
                    .setBlogId(removedBlog.getId())
                    .build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("Blog with id not found").asException());
        }

    }

    @Override
    public void listBlog(ListBlogRequest request, StreamObserver<ListBlogResponse> responseObserver) {
        System.out.println("Get all blogs request");

        dbStub.getAllBlogs().forEach(blog -> {
            responseObserver.onNext(ListBlogResponse.newBuilder()
                    .setBlog(blog)
                    .build());
        });

        responseObserver.onCompleted();
    }
}
