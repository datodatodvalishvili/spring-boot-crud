package com.baeldung.crud;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.baeldung.crud.entities.LoanApplication;

public class LoanApplicationUnitTest {
    
    @Test
    public void whenCalledGetName_thenCorrect() {
        LoanApplication loanApplication = new LoanApplication("Julie", "julie@domain.com");
        
        assertThat(loanApplication.getFirstName()).isEqualTo("Julie");
    }
    
    @Test
    public void whenCalledGetEmail_thenCorrect() {
        LoanApplication loanApplication = new LoanApplication("Julie", "julie@domain.com");
        
        assertThat(loanApplication.getLastName()).isEqualTo("julie@domain.com");
    }
    
    @Test
    public void whenCalledSetName_thenCorrect() {
        LoanApplication loanApplication = new LoanApplication("Julie", "julie@domain.com");
        
        loanApplication.setFirstName("John");
        
        assertThat(loanApplication.getFirstName()).isEqualTo("John");
    }
    
    @Test
    public void whenCalledSetEmail_thenCorrect() {
        LoanApplication loanApplication = new LoanApplication("Julie", "julie@domain.com");
        
        loanApplication.setLastName("john@domain.com");
        
        assertThat(loanApplication.getLastName()).isEqualTo("john@domain.com");
    }
    
    @Test
    public void whenCalledtoString_thenCorrect() {
        LoanApplication loanApplication = new LoanApplication("Julie", "julie@domain.com");
        assertThat(loanApplication.toString()).isEqualTo("LoanApplication{id=0, name=Julie, email=julie@domain.com}");
    }
}
