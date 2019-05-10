package com.linnyk.consul;

import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.HelloReply;
import com.proto.greet.HelloRequest;
import io.grpc.stub.StreamObserver;

public class ConsulHelloGRPCServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    private String serviceId;

    public ConsulHelloGRPCServiceImpl(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("Hello service " + serviceId);

        responseObserver.onNext(HelloReply.newBuilder().setMessage("Hello from service " + serviceId).build());
        responseObserver.onCompleted();
    }
}
