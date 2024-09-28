// package com.example.order.Grpc;



// import com.example.order.model.Order;
// import com.example.order.service.OrderService;
// import com.example.order.Grpc.OrderProto.*;
// import com.example.order.Grpc.OrderServiceGrpc.OrderServiceImplBase;
// import io.grpc.stub.StreamObserver;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.stream.Collectors;

// @Service
// public class GrpcOrderService extends OrderServiceImplBase {

//     @Autowired
//     private OrderService orderService;

//     @Override
//     public void getAllOrders(Empty request, StreamObserver<OrderList> responseObserver) {
//         List<Order> orders = orderService.getAllOrders();
//         List<OrderProto.Order> grpcOrders = orders.stream()
//             .map(this::convertToGrpcOrder)
//             .collect(Collectors.toList());

//         OrderList orderList = OrderList.newBuilder()
//             .addAllOrders(grpcOrders)
//             .build();
//         responseObserver.onNext(orderList);
//         responseObserver.onCompleted();
//     }

//     @Override
//     public void getOrderById(OrderIdRequest request, StreamObserver<OrderProto.Order> responseObserver) {
//         Order order = orderService.getOrderById(request.getId());
//         OrderProto.Order grpcOrder = convertToGrpcOrder(order);
//         responseObserver.onNext(grpcOrder);
//         responseObserver.onCompleted();
//     }

//     @Override
//     public void createOrder(OrderProto.Order request, StreamObserver<OrderProto.Order> responseObserver) {
//         Order order = new Order(request.getProductName(), request.getQuantity(), request.getPrice());
//         Order createdOrder = orderService.createOrder(order);
//         OrderProto.Order grpcOrder = convertToGrpcOrder(createdOrder);
//         responseObserver.onNext(grpcOrder);
//         responseObserver.onCompleted();
//     }

//     @Override
//     public void deleteOrder(OrderIdRequest request, StreamObserver<Empty> responseObserver) {
//         orderService.deleteOrder(request.getId());
//         responseObserver.onNext(Empty.newBuilder().build());
//         responseObserver.onCompleted();
//     }

//     private OrderProto.Order convertToGrpcOrder(Order order) {
//         return OrderProto.Order.newBuilder()
//             .setId(order.getId())
//             .setProductName(order.getProductName())
//             .setQuantity(order.getQuantity())
//             .setPrice(order.getPrice())
//             .build();
//     }
// }
