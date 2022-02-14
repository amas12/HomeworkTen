package onlc;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationTests extends TestBase {

    @Test
    void fillFormTest() {



        step("Открываем страницу", () -> {
            open("/automation-practice-form");
        });
        step("Название", () -> {
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        });
        step("Ввести имя", () -> {
            $("#firstName").setValue("Alex");
        });
        step("Ввести фамилию", () -> {
            $("#lastName").setValue("Egorov");
        });
        step("Ввести email", () -> {
            $("#userEmail").setValue("alex@egorov.com");
        });
        step("Выбрать пол", () -> {
            $("#genterWrapper").$(byText("Other")).click();
        });
        step("Ввести номер телефона", () -> {
            $("#userNumber").setValue("1231231230");

        });
        step("Ввести дату рождение", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("2008");
            $("[aria-label$='July 30th, 2008']").click();
            $("#subjectsInput").setValue("Math").pressEnter();
        });
        step("Выбрать хобби", () -> {
            $("#hobbiesWrapper").$(byText("Sports")).click();
        });
        step("Ввести адрес", () -> {
            $("#currentAddress").setValue("Some address 1");

        });
        step("Выбрать штат", () -> {
            $("#state").scrollTo().click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
        });
        step("Выбрать город", () -> {
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Noida")).click();

        });
        step("Отправить форму", () -> {
            $("#submit").click();

        });
        step("Проверка формы ", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").$(byText("Student Name"))
                    .parent().shouldHave(text("Alex Egorov"));

        });
        step("Проверка на коректность введенной формы", () -> {
            $(".table-responsive").$(byText("Student Name"))
                    .parent().shouldHave(text("Alex Egorov"));
        });

    }
}
