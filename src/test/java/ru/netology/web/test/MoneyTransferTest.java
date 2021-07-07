package ru.netology.web.test;


import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;



import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoneyTransferTest {


    @Test
    void shouldTransferZeroFromFirstCard() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
        val moneyTransferPage = dashboardPage.secondBill();
        int amount = 0;
        moneyTransferPage.transferMoney(amount, DataHelper.getCardFirst());
        val balanceFirstBillAfterTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillAfterTransfer = dashboardPage.getSecondCardBalance();
        assertEquals((balanceFirstBillBeforeTransfer - amount), balanceFirstBillAfterTransfer);
        assertEquals((balanceSecondBillBeforeTransfer + amount), balanceSecondBillAfterTransfer);
    }
    @Test
    void shouldTransferZeroFromSecondCard() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
        val moneyTransferPage = dashboardPage.secondBill();
        int amount = 0;
        moneyTransferPage.transferMoney(amount, DataHelper.getCardFirst());
        val balanceFirstBillAfterTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillAfterTransfer = dashboardPage.getSecondCardBalance();
        assertEquals((balanceFirstBillBeforeTransfer - amount), balanceFirstBillAfterTransfer);
        assertEquals((balanceSecondBillBeforeTransfer + amount), balanceSecondBillAfterTransfer);
    }
    @Test
    void shouldTransferAverageAmountFromFirstCard() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
        val moneyTransferPage = dashboardPage.secondBill();
        int amount = 5000;
        moneyTransferPage.transferMoney(amount, DataHelper.getCardFirst());
        val balanceFirstBillAfterTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillAfterTransfer = dashboardPage.getSecondCardBalance();
        assertEquals((balanceFirstBillBeforeTransfer - amount), balanceFirstBillAfterTransfer);
        assertEquals((balanceSecondBillBeforeTransfer + amount), balanceSecondBillAfterTransfer);
    }

    @Test
    void shouldTransferAverageAmountFromSecondCard() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
        val moneyTransferPage = dashboardPage.firstBill();
        int amount = 5000;
        moneyTransferPage.transferMoney(amount, DataHelper.getCardSecond());
        val balanceFirstBillAfterTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillAfterTransfer = dashboardPage.getSecondCardBalance();
        assertEquals((balanceFirstBillBeforeTransfer + amount), balanceFirstBillAfterTransfer);
        assertEquals((balanceSecondBillBeforeTransfer - amount), balanceSecondBillAfterTransfer);
    }
    @Test
    void shouldTransferAllFromFirstCard() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
        val moneyTransferPage = dashboardPage.firstBill();
        int amount = 20000;
        moneyTransferPage.transferMoney(amount, DataHelper.getCardSecond());
        val balanceFirstBillAfterTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillAfterTransfer = dashboardPage.getSecondCardBalance();
        assertEquals((balanceFirstBillBeforeTransfer + amount), balanceFirstBillAfterTransfer);
        assertEquals((balanceSecondBillBeforeTransfer - amount), balanceSecondBillAfterTransfer);
    }
    @Test
    void shouldTransferAllFromSecondCard() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
        val moneyTransferPage = dashboardPage.firstBill();
        int amount = 20000;
        moneyTransferPage.transferMoney(amount, DataHelper.getCardSecond());
        val balanceFirstBillAfterTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillAfterTransfer = dashboardPage.getSecondCardBalance();
        assertEquals((balanceFirstBillBeforeTransfer + amount), balanceFirstBillAfterTransfer);
        assertEquals((balanceSecondBillBeforeTransfer - amount), balanceSecondBillAfterTransfer);
    }

    @Test
    void shouldTransferMoreThanAllMoneyFromFirstCard() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
        val moneyTransferPage = dashboardPage.firstBill();
        int amount = 500000;
        moneyTransferPage.transferMoney(amount, DataHelper.getCardSecond());
        moneyTransferPage.errorMassage();


    }
    @Test
    void shouldTransferMoreThanAllMoneyFromSecondCard() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
        val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
        val moneyTransferPage = dashboardPage.firstBill();
        int amount = 0;
        moneyTransferPage.transferMoney(amount, DataHelper.getCardSecond());
        moneyTransferPage.errorMassage();


    }
}