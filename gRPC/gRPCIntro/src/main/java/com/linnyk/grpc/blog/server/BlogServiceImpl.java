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
        String blogId = request.getBlogId();
        Blog blog = dbStub.get(blogId);

        if (Objects.isNull(blog)) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("Blog with id not found").asException());
        } else {
            responseObserver.onNext(ReadBlogResponse.newBuilder()
                    .setBlog(blog)
                    .build());
            responseObserver.onCompleted();
        }

    }
}
