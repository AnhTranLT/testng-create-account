/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baby.createaccount.core;


/**
 *
 * @author ADMIN
 */



public class AccountManager {
    private final AccountDAO accountDAO;

    public AccountManager(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public boolean createAccount(String username, String password) {
        if (isValidAccountInfo(username, password) && !accountDAO.accountExists(username)) {
            Account account = new Account(username, password);
            accountDAO.addAccount(account);
            System.out.println("Account with username '" + username + "' created successfully.");
            return true;
        } else {
            System.out.println("Failed to create account with username '" + username + "'.");
            return false;
        }
    }

    private boolean isValidAccountInfo(String username, String password) {
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }
}
