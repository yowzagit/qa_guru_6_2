import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void setStartConfig() {
        Configuration.startMaximized = true;
    }

    @Test
    void selenideSearchTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Nicolae");
        $("#lastName").setValue("Ceusescu");
        $("#userEmail").setValue("Ceusescu18@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("7131224355");
        // Filling Date Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1918");
        $("[aria-label='Choose Wednesday, December 25th, 1918']").click();
        // Ending Date Birth
        $("#subjectsInput").setValue("Co").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/123.jpg"));
        $("#currentAddress").setValue("Romania, Scornicesti.");
        $("#react-select-3-input").setValue("Raja").pressEnter();
        $("#react-select-4-input").setValue("Jais").pressEnter();
        $("#submit").click();
        //Check data
        $(".table-responsive").shouldHave(text("Nicolae Ceusescu"), text("Ceusescu18@gmail.com"),
                text("Male"), text("7131224355"), text("25 December,1918"), text("Computer Science"),
                text("Sports, Reading"), text("123.jpg"), text("Romania, Scornicesti."),
                text("Rajasthan Jaiselmer"));

    }
}