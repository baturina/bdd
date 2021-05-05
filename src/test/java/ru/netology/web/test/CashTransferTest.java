package ru.netology.web.test;


        import lombok.val;
        import org.junit.jupiter.api.Test;
        import ru.netology.web.data.DataHelper;
        import ru.netology.web.page.DashboardPage;
        import ru.netology.web.page.Login;
        import ru.netology.web.page.TransferPage;

        import static org.junit.jupiter.api.Assertions.*;
        import static com.codeborne.selenide.Selectors.withText;
        import static com.codeborne.selenide.Selenide.*;

public class CashTransferTest {

    @Test
    void shouldTransferCashFromFirstToSecond() {
        //подключаемся к серверу
        open("http://localhost:9999");
        //логинимся
        val loginPage = new Login();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        //проверяем подключение к Dashboard и создаем переменную класса DashboardPage для тестов
        val dashboardPage = verificationPage.validVerify(verificationCode);
        //настройка параметров перевода
        val balanceFirstCard = dashboardPage.getFirstCardBalance();
        val balanceSecondCard = dashboardPage.getSecondCardBalance();
        Integer transfer = 100;
        //выбираем первую карту
        val transferPage = dashboardPage.addToFirstCard();
        //переводим средства
        transferPage.addToFirstCard(transfer);
        //проверяем результат
        val expectBalanceFirstCard = balanceFirstCard + transfer;
        val expectBalanceSecondCard = balanceSecondCard - transfer;
        assertEquals(expectBalanceFirstCard, dashboardPage.getFirstCardBalance());
        assertEquals(expectBalanceSecondCard, dashboardPage.getSecondCardBalance());
    }

    @Test
    void shouldTransferCashFromSecondToFirst() {
        //подключаемся к серверу
        open("http://localhost:9999");
        //логинимся
        val loginPage = new Login();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        //проверяем подключение к Dashboard и создаем переменную класса DashboardPage для тестов
        val dashboardPage = verificationPage.validVerify(verificationCode);
        //настройка параметров перевода
        val balanceFirstCard = dashboardPage.getFirstCardBalance();
        val balanceSecondCard = dashboardPage.getSecondCardBalance();
        Integer transfer = 100;
        //выбираем первую карту
        val transferPage = dashboardPage.addToSecondCard();
        //переводим средства
        transferPage.addToSecondCard(transfer);
        //проверяем результат
        val expectBalanceFirstCard = balanceFirstCard - transfer;
        val expectBalanceSecondCard = balanceSecondCard + transfer;
        assertEquals(expectBalanceFirstCard, dashboardPage.getFirstCardBalance());
        assertEquals(expectBalanceSecondCard, dashboardPage.getSecondCardBalance());
    }

    @Test
    void shouldAbortButtonFromFirstToSecond() {
        //подключаемся к серверу
        open("http://localhost:9999");
        //логинимся
        val loginPage = new Login();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        //проверяем подключение к Dashboard и создаем переменную класса DashboardPage для тестов
        val dashboardPage = verificationPage.validVerify(verificationCode);
        //настройка параметров перевода
        val balanceFirstCard = dashboardPage.getFirstCardBalance();
        val balanceSecondCard = dashboardPage.getSecondCardBalance();
        Integer transfer = 100;
        //выбираем первую карту
        val transferPage = dashboardPage.addToSecondCard();
        //переводим средства
        transferPage.abordToSecondCard(transfer);
        //проверяем результат
        val expectBalanceFirstCard = balanceFirstCard;
        val expectBalanceSecondCard = balanceSecondCard;
        assertEquals(expectBalanceFirstCard, dashboardPage.getFirstCardBalance());
        assertEquals(expectBalanceSecondCard, dashboardPage.getSecondCardBalance());
    }

    @Test
    void shouldAbortButtonFromSecondToFirst() {
        //подключаемся к серверу
        open("http://localhost:9999");
        //логинимся
        val loginPage = new Login();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        //проверяем подключение к Dashboard и создаем переменную класса DashboardPage для тестов
        val dashboardPage = verificationPage.validVerify(verificationCode);
        //настройка параметров перевода
        val balanceFirstCard = dashboardPage.getFirstCardBalance();
        val balanceSecondCard = dashboardPage.getSecondCardBalance();
        Integer transfer = 100;
        //выбираем первую карту
        val transferPage = dashboardPage.addToFirstCard();
        //переводим средства
        transferPage.abordToFirstCard(transfer);
        //проверяем результат
        val expectBalanceFirstCard = balanceFirstCard;
        val expectBalanceSecondCard = balanceSecondCard;
        assertEquals(expectBalanceFirstCard, dashboardPage.getFirstCardBalance());
        assertEquals(expectBalanceSecondCard, dashboardPage.getSecondCardBalance());
    }

    @Test
    void shouldNotTransferCashFromFirstToSecond() {
        //подключаемся к серверу
        open("http://localhost:9999");
        //логинимся
        val loginPage = new Login();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        //проверяем подключение к Dashboard и создаем переменную класса DashboardPage для тестов
        val dashboardPage = verificationPage.validVerify(verificationCode);
        //настройка параметров перевода
        val balanceFirstCard = dashboardPage.getFirstCardBalance();
        val balanceSecondCard = dashboardPage.getSecondCardBalance();
        Integer transfer = 11000;
        //выбираем первую карту
        val transferPage = dashboardPage.addToFirstCard();
        //переводим средства
        transferPage.addToFirstCard(transfer);
        //проверяем результат
        val expectBalanceFirstCard = balanceFirstCard;
        val expectBalanceSecondCard = balanceSecondCard;
        assertEquals(expectBalanceFirstCard, dashboardPage.getFirstCardBalance());
        assertEquals(expectBalanceSecondCard, dashboardPage.getSecondCardBalance());
    }

    @Test
    void shouldNotTransferCashFromSecondToFirst() {
        //подключаемся к серверу
        open("http://localhost:9999");
        //логинимся
        val loginPage = new Login();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        //проверяем подключение к Dashboard и создаем переменную класса DashboardPage для тестов
        val dashboardPage = verificationPage.validVerify(verificationCode);
        //настройка параметров перевода
        val balanceFirstCard = dashboardPage.getFirstCardBalance();
        val balanceSecondCard = dashboardPage.getSecondCardBalance();
        Integer transfer = 11000;
        //выбираем первую карту
        val transferPage = dashboardPage.addToSecondCard();
        //переводим средства
        transferPage.addToSecondCard(transfer);
        //проверяем результат
        val expectBalanceFirstCard = balanceFirstCard;
        val expectBalanceSecondCard = balanceSecondCard;
        assertEquals(expectBalanceFirstCard, dashboardPage.getFirstCardBalance());
        assertEquals(expectBalanceSecondCard, dashboardPage.getSecondCardBalance());
    }

}
