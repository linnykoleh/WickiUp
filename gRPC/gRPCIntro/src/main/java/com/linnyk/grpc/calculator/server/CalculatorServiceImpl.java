package com.linnyk.grpc.calculator.server;

import com.proto.calculator.*;
import io.grpc.Status;
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

    @Override
    public void primeNumberDecomposition(PrimeNumberDecompositionRequest request, StreamObserver<PrimeNumberDecompositionResponse> responseObserver) {
        long number = request.getNumber();
        int divisor = 2;

        while (number > 1) {
            if (number % divisor == 0) {
                number = number / divisor;
                responseObserver.onNext(PrimeNumberDecompositionResponse.newBuilder()
                        .setPrimeFactor(divisor)
                        .build());
            } else {
                divisor++;
            }
        }
        responseObserver.onCompleted();
    }

    /**
     * Error handling example
     */
    @Override
    public void squareRoot(SquareRootRequest request, StreamObserver<SquareRootResponse> responseObserver) {
        System.out.println("Request for squareRoot is: " + request);
        int number = request.getNumber();

        if (number > 0) {
            double sqrt = Math.sqrt(number);
            SquareRootResponse squareRootResponse = SquareRootResponse.newBuilder()
                    .setRootedNumber(sqrt)
                    .build();
            responseObserver.onNext(squareRootResponse);
        } else {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("The number is being sent is not positive")
                    .augmentDescription("Number sent: " + number)
                    .asRuntimeException()
            );
        }
        responseObserver.onCompleted();
    }
}
