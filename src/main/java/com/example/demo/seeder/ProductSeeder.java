package com.example.demo.seeder;

import com.example.demo.entity.Product;
import com.example.demo.responsitory.ProductRepository;
import com.example.demo.util.NumberUtil;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;
    private  static  final int NUMBER_OF_PRODUCT = 100;
    public static ArrayList<Product> products;
    public void generate(){
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("pink");
        colors.add("white");
        colors.add("black");
        colors.add("yellow");
        colors.add("blue");
        colors.add("green");
        ArrayList<String> sizes = new ArrayList<>();
        sizes.add("s");
        sizes.add("M");
        sizes.add("L");
        sizes.add("XL");
        sizes.add("XXL");
        ArrayList<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("FeMale");
        genders.add("Other");
        Random random = new Random();
        Faker faker = new Faker();
        products = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PRODUCT; i++) {
            Product obj = Product.builder()
                    .name(faker.name().name())
                    .description(faker.name().title())
                    .gender(genders.get(NumberUtil.numberRandom(0, genders.size() - 1)))
                    .color(colors.get(NumberUtil.numberRandom(0, colors.size() -1 )))
                    .size(sizes.get(NumberUtil.numberRandom(0, sizes.size() -1 )))
                    .price((double) NumberUtil.numberRandom(1000, 10000))
                    .status(NumberUtil.numberRandom(0,1))
                    .createdAt(LocalDateTime.now().minusDays(NumberUtil.numberRandom(1,30)))
                    .build();
            products.add(obj);
        }
        productRepository.saveAll(products);
    }
    @Override
    public void run(String... args) throws Exception {
        generate();
    }
}
