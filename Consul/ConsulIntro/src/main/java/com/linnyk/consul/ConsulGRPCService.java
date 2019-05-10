package com.linnyk.consul;

import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.NotRegisteredException;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.agent.Registration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;
import java.util.Collections;

public class ConsulGRPCService {

    public static void main(String[] args) throws InterruptedException, IOException, NotRegisteredException {
        String serviceId = args[0];

        registerServiceWithConsul(serviceId);
        startGRPCServer(serviceId);
    }

    private static void registerServiceWithConsul(String serviceId) throws NotRegisteredException {
        Consul client = Consul.builder().build(); // connect on localhost

        AgentClient agentClient = client.agentClient();

        Registration service = ImmutableRegistration.builder()
                .id(serviceId)
                .name("myService")
                .port(Integer.parseInt("808" + serviceId))
                .check(Registration.RegCheck.ttl(3L)) // registers with a TTL of 3 seconds
                .tags(Collections.singletonList("tag1"))
                .meta(Collections.singletonMap("port", "5005" + serviceId))
                .build();

        agentClient.register(service);
        agentClient.pass(serviceId);
    }

    private static void startGRPCServer(String serviceId) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(Integer.parseInt("5005" + serviceId))
                .addService(new ConsulHelloGRPCServiceImpl(serviceId))
                .addService(ProtoReflectionService.newInstance())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutdown request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        }));

        System.out.println("Server " + serviceId + " is started");

        server.awaitTermination();
    }

}
