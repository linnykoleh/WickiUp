package com.linnyk.consul;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.health.HealthServicesRequest;
import com.ecwid.consul.v1.health.model.HealthService;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.HelloReply;
import com.proto.greet.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.List;

public class ConsulGRPCClient {

    public static void main(String[] args) {
        ConsulClient client = new ConsulClient("localhost");

        HealthServicesRequest request = HealthServicesRequest.newBuilder()
//                .setPassing(true)
                .setQueryParams(QueryParams.DEFAULT)
                .build();
        Response<List<HealthService>> healthyServices = client.getHealthServices("myService", request);

        System.out.println(healthyServices);
        System.out.println(client);

        for (HealthService healthServer : healthyServices.getValue()) {
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress("localhost", Integer.parseInt(healthServer.getService().getMeta().get("port")))
                    .usePlaintext()
                    .build();

            GreetServiceGrpc.GreetServiceBlockingStub service = GreetServiceGrpc.newBlockingStub(channel);

            HelloReply helloReply = service.sayHello(HelloRequest.newBuilder().build());
            System.out.println("Client response: " + helloReply);
        }
    }

}
