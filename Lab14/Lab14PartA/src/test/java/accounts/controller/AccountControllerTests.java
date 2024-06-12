package accounts.controller;

import accounts.service.AccountResponse;
import accounts.service.AccountService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTests {
    @Autowired
    MockMvc mock;

    @MockBean
    AccountService accountService;

    @Test
    public void testGetAccountByAccountNumber() throws  Exception {
        String accountNumber = "1";
        Mockito.when(accountService.getAccount(accountNumber)).thenReturn(
                new AccountResponse(accountNumber, 100.0, "Account Holder 1")
        );

        mock.perform(MockMvcRequestBuilders.get("/account/"+accountNumber))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value(accountNumber))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountHolder").value("Account Holder 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(100.0));
    }

    @Test
    public void testCreateAccount() throws Exception {
        String accountNumber = "123";
        String amount = "100.0";
        String accountHolder = "Author 1";

        Mockito.doNothing().when(accountService).createAccount(accountNumber, Double.parseDouble(amount), accountHolder);

        mock.perform(MockMvcRequestBuilders.get("/createaccount/" + accountNumber + "/" + amount + "/" + accountHolder))
                .andExpect(status().isOk());
    }
}
