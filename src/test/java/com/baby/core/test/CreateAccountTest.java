/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baby.core.test;

import com.baby.createaccount.core.Account;
import com.baby.createaccount.core.AccountDAO;
import com.baby.createaccount.core.AccountManager;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author ADMIN
 */
public class CreateAccountTest {
    private final AccountDAO accountDAOMock = Mockito.mock(AccountDAO.class);
    private final AccountManager accountManager = new AccountManager(accountDAOMock);

    @Test
    public void testCreateAccount_ValidInfo_Success() {
        String username = "testuser";
        String password = "testpassword";
        Mockito.when(accountDAOMock.accountExists(username)).thenReturn(false);

        boolean result = accountManager.createAccount(username, password);

        Assert.assertTrue(result);
        Mockito.verify(accountDAOMock, Mockito.times(1)).addAccount(Mockito.any(Account.class));
    }

    @Test
    public void testCreateAccount_ExistingAccount_Failure() {
        String existingUsername = "existinguser";
        String password = "testpassword";
        Mockito.when(accountDAOMock.accountExists(existingUsername)).thenReturn(true);

        boolean result = accountManager.createAccount(existingUsername, password);

        Assert.assertFalse(result);
        Mockito.verify(accountDAOMock, Mockito.never()).addAccount(Mockito.any(Account.class));
    }

    @Test
    public void testCreateAccount_InvalidInfo_Failure() {
        String username = "";
        String password = "testpassword";

        boolean result = accountManager.createAccount(username, password);

        Assert.assertFalse(result);
        Mockito.verify(accountDAOMock, Mockito.never()).addAccount(Mockito.any(Account.class));
    }
}
