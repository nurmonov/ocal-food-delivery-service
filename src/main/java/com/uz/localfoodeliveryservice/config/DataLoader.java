package com.uz.localfoodeliveryservice.config;


import com.uz.localfoodeliveryservice.entity.*;
import com.uz.localfoodeliveryservice.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) {

        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setName("User " + i);
            user.setEmail("user" + i + "@example.com");
            user.setPassword("password" + i);
            user.setAddress("Address " + i);
            user.setPhone("9989011122" + i);
            users.add(user);
        }
        userRepository.saveAll(users);

        List<Restaurant> restaurants = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Restaurant restaurant = new Restaurant();
            restaurant.setName("Restaurant " + i);
            restaurant.setAddress("Tashkent, Street " + i);
            restaurant.setPhone("9989377777" + i);
            restaurant.setLogoUrl("http://example.com/logo" + i + ".png");
            restaurant.setOwner(users.get(i - 1));
            restaurants.add(restaurant);
        }
        restaurantRepository.saveAll(restaurants);

        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setDescription("Description for product " + i);
            product.setPrice(1000 * i);
            product.setImageUrl("http://example.com/product" + i + ".jpg");
            product.setRestaurant(restaurants.get(i - 1));
            products.add(product);
        }
        productRepository.saveAll(products);

        List<Order> orders = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Order order = new Order();
            order.setUser(users.get(i - 1));
            order.setRestaurant(restaurants.get(i - 1));
            order.setTotalPrice(0);
          //  order.setStatus("PENDING");
           // order.setCreatedAt(LocalDateTime.now());
            orders.add(order);
        }
        orderRepository.saveAll(orders);

        List<OrderItem> orderItems = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            OrderItem item = new OrderItem();
            item.setOrder(orders.get(i - 1));
            item.setProduct(products.get(i - 1));
            item.setQuantity(i);
            item.setPrice(products.get(i - 1).getPrice());

            OrderItemPK id = new OrderItemPK();
            id.setOrderId(orders.get(i - 1).getId());
            id.setProductId(products.get(i - 1).getId());
            item.setId(id); // SHART

            orderItems.add(item);
        }


        orderItemRepository.saveAll(orderItems);
        orderRepository.saveAll(orders);
    }
}
