package onlc;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData extends TestBase {


    Faker faker = new Faker(new Locale("ru"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String mobile = String.valueOf(faker.number().numberBetween(1000000000, 2147483647));
    String address = faker.address().streetAddress();
    String year = String.valueOf(faker.number().numberBetween(1900, 2100));

    public static String mail = "tester1.test@mail.test";
    public static String day = "17";
    public static String month = "May";
    public static String imgPath = "src/test/resources/img/";
    public static String imgName = "cat.jpg";

}