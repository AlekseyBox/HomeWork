package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentsPracticeWorkTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillForm() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Box");
        $("#userEmail").setValue("AlexBox@mail.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__month-select").selectOption("July");
        $(byText("22")).click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("test.jpg");
        $("#currentAddress").setValue("Saratov");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name Alex Box"), text("Student Email AlexBox@mail.ru"),
                text("Gender Male"), text("Mobile 0123456789"), text("Date of Birth 22 July,1991"),
                text("Subjects Hindi"), text("Hobbies Sports"),
                text("Address Saratov"), text("State and City NCR Delhi"));
    }
}
