package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Tom", "Jerry", "tom@jerry.ru");
        User user2 = new User("Ivan", "Petrov", "vanya@gmail.com");
        User user3 = new User("Ann", "Cosmos", "ann.cosmos@gamil.com");
        User user4 = new User("Ilon", "Mask", "tesla@mail.ru");

        Car car1 = new Car("Audi", 8);
        Car car2 = new Car("BMW", 5);
        Car car3 = new Car("lada", 99);
        Car car4 = new Car("Tesla", 3);

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> usersCar = userService.listUsers();

        for (User xxx : usersCar) {
            System.out.println(xxx);
        }
        User user10 = userService.getUserByCar("Audi", 8);
        System.out.println(user10);

        context.close();
    }
}
