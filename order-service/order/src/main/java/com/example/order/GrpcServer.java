// package com.example.order;

// import com.example.order.Grpc.GrpcOrderService;
// import io.grpc.Server;
// import io.grpc.ServerBuilder;
// import jakarta.annotation.PostConstruct;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;



// @Component
// public class GrpcServer {

//     @Autowired
//     private GrpcOrderService grpcOrderService;

//     @PostConstruct
//     public void startServer() throws Exception {
//         Server server = ServerBuilder.forPort(8083)
//             .addService(grpcOrderService)
//             .build()
//             .start();

//         System.out.println("gRPC Server started on port 8083");
//         server.awaitTermination();
//     }
// }
