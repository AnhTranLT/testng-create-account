/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.baby.createaccount.core;

/**
 *
 * @author ADMIN
 */
public interface AccountDAO {
    boolean accountExists(String username);
    void addAccount(Account account);
}