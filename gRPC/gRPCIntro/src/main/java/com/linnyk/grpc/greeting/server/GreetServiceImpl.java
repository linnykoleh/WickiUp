package com.linnyk.grpc.greeting.server;

import com.proto.greet.*;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        System.out.println("Request is: " + request.getGreeting());
        String firstName = request.getGreeting().getFirstName();

        String result = "Hello " + firstName;

        // create the response
        GreetResponse greetResponse = GreetResponse.newBuilder()
                .setResult(result)
                .build();

        //send the response
        responseObserver.onNext(greetResponse);

        // complete the RPC call
        responseObserver.onCompleted();
    }

    @Override
    public void greetManyTimes(GreetManyRequest request, StreamObserver<GreetManyTimesResponse> responseObserver) {
        super.greetManyTimes(request, responseObserver);
    }
}
