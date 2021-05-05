package ru.netology.web.page;



import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {

    private SelenideElement codeField = $(withText("Пополнение карты"));
    private SelenideElement amount = $$(".input__control[type=text]").first();
    private SelenideElement fromCard = $(".input__control[type=tel]");
    private SelenideElement addButton = $(withText("Пополнить"));
    private SelenideElement abordButton = $(withText("Отмена"));

    public TransferPage() {
        codeField.shouldBe(visible);
    }

    public DashboardPage addToFirstCard(Integer transfer) {
        amount.setValue(transfer.toString());
        fromCard.setValue(DataHelper.getNumberOfSecondCard());
        addButton.click();
        return new DashboardPage();
    }

    public DashboardPage addToSecondCard(Integer transfer) {
        amount.setValue(transfer.toString());
        fromCard.setValue(DataHelper.getNumberOfFirstCard());
        addButton.click();
        return new DashboardPage();
    }

    public DashboardPage abordToSecondCard(Integer transfer) {
        amount.setValue(transfer.toString());
        fromCard.setValue(DataHelper.getNumberOfFirstCard());
        abordButton.click();
        return new DashboardPage();
    }

    public DashboardPage abordToFirstCard(Integer transfer) {
        amount.setValue(transfer.toString());
        fromCard.setValue(DataHelper.getNumberOfSecondCard());
        abordButton.click();
        return new DashboardPage();
    }

}
