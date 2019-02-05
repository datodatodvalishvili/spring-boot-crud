package com.baeldung.crud;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.baeldung.crud.entities.LoanApplication;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.baeldung.crud.controllers.LoanApplicationController;
import com.baeldung.crud.repositories.LoanApplicationRepository;

public class LoanApplicationControllerUnitTest {

    private static LoanApplicationController loanApplicationController;
    private static LoanApplicationRepository mockedLoanApplicationRepository;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;

    @BeforeClass
    public static void setUpUserControllerInstance() {
        mockedLoanApplicationRepository = mock(LoanApplicationRepository.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        loanApplicationController = new LoanApplicationController(mockedLoanApplicationRepository);
    }

    @Test
    public void whenCalledshowSignUpForm_thenCorrect() {
        LoanApplication loanApplication = new LoanApplication("John", "john@domain.com");

        assertThat(loanApplicationController.showSignUpForm(loanApplication)).isEqualTo("add-loanApplication");
    }
    
    @Test
    public void whenCalledaddUserAndValidUser_thenCorrect() {
        LoanApplication loanApplication = new LoanApplication("John", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(loanApplicationController.addUser(loanApplication, mockedBindingResult, mockedModel)).isEqualTo("index");
    }

    @Test
    public void whenCalledaddUserAndInValidUser_thenCorrect() {
        LoanApplication loanApplication = new LoanApplication("John", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(loanApplicationController.addUser(loanApplication, mockedBindingResult, mockedModel)).isEqualTo("add-loanApplication");
    }



    
    @Test(expected = IllegalArgumentException.class)
    public void whenCalleddeleteUser_thenIllegalArgumentException() {
        assertThat(loanApplicationController.deleteUser(1l, mockedModel)).isEqualTo("index");
    }
}
