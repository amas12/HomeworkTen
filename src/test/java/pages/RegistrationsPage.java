package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPage {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            mailInput = $("#userEmail"),
            genderlChooseMale = $(byText("Male")),
            genderlChooseFemale = $(byText("Female")),
            phoneNumberInput = $("#userNumber"),
            buttonSubmit = $("#submit"),
            dateInput = $("#dateOfBirthInput"),
            monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select"),
            subjectsInput = $("#subjectsInput"),
            hobbySports = $(byText("Sports")),
            hobbyReading = $(byText("Reading")),
            hobbyMusic = $(byText("Music")),
            fileInput = $("#uploadPicture"),
            adressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateHaryana = $(byText("Haryana")),
            cityInput = $("#city"),
            cityKarnal = $(byText("Karnal")),
            resultsTable = $(".table-responsive"),
            subjectsEconomics = $(byText("Economics")),
            subjectsCivics = $(byText("Civics"));


    @Step("Открываем страницу регистрации студента на demoqa")
    public RegistrationsPage openPage() {
        open("https://demoqa.com/automation-practice-form");

        return this;
    }

    @Step("Заполняем имя {firstName}")
    public RegistrationsPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    @Step("Заполняем фамилию {lastName}")
    public RegistrationsPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    @Step("Заполняем email {mail}")
    public RegistrationsPage typeMail(String mail) {
        mailInput.setValue(mail);

        return this;
    }

    @Step("Выбираем пол мужской")
    public RegistrationsPage selectGenderMale() {
        genderlChooseMale.click();

        return this;
    }

    @Step("Выбираем пол женский")
    public RegistrationsPage selectGenderFemale() {
        genderlChooseFemale.click();

        return this;
    }

    @Step("Заполняем телефонный номер {phoneNumber}")
    public RegistrationsPage typePhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);

        return this;
    }

    @Step("Делаем видимой нижнюю часть формы - скролл до кнопки Submit")
    public RegistrationsPage scrollToSubmit() {
        buttonSubmit.scrollIntoView(true);

        return this;
    }

    @Step("Указываем дату рождения {day} {month} {year}")
    public RegistrationsPage setDate(String day, String month, String year) {
        dateInput.click();
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        $(".react-datepicker__day.react-datepicker__day--0" + day).click();

        return this;
    }

    @Step("Клик по полю выбора предметов")
    public RegistrationsPage clickSubjectsInput() {
        subjectsInput.click();

        return this;
    }

    @Step("Выбираем предмет Экономику")
    public RegistrationsPage selectSubjectEconomics() {
        subjectsInput.setValue("e");
        subjectsEconomics.click();

        return this;
    }

    @Step("Выбираем предмет Гражданское право")
    public RegistrationsPage selectSubjectCivics() {
        subjectsInput.setValue("c");
        subjectsCivics.click();

        return this;
    }

    @Step("Выбираем хобби Спорт")
    public RegistrationsPage selectHobbySports() {
        hobbySports.click();

        return this;
    }

    @Step("Выбираем хобби Рисование")
    public RegistrationsPage selectHobbyReading() {
        hobbyReading.click();

        return this;
    }

    @Step("Выбираем хобби Музыка")
    public RegistrationsPage selectHobbyMusic() {
        hobbyMusic.click();

        return this;
    }

    @Step("Загружаем файл {file}")
    public RegistrationsPage uploadFile(String file) {
        File cat = new File(file);
        fileInput.uploadFile(cat);

        return this;
    }

    @Step("Заполняем адрес {adress}")
    public RegistrationsPage typeAdress(String adress) {
        adressInput.setValue(adress);

        return this;
    }

    @Step("Выбираем город Карнал")
    public RegistrationsPage selectCityKarnal() {
        stateInput.click();
        stateHaryana.click();
        cityInput.click();
        cityKarnal.click();

        return this;
    }

    @Step("Клик по кнопке Зарегистрировать студента")
    public RegistrationsPage submitStudent() {
        buttonSubmit.click();

        return this;
    }

    @Step("Сверяем данные студента {key} - {value}")
    public RegistrationsPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

}

