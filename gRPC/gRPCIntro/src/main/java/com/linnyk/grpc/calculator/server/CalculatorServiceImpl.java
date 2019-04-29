package com.linnyk.grpc.calculator.server;

import com.proto.calculator.CalculatorServiceGrpc;
import com.proto.calculator.SumRequest;
import com.proto.calculator.SumResponse;
import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
        System.out.println("Request is: " + request);
        int sumResult = request.getFirstNumber() + request.getSecondNumber();
        SumResponse sumResponse = SumResponse.newBuilder().setSumResult(sumResult).build();

        responseObserver.onNext(sumResponse);
        responseObserver.onCompleted();
    }
}
