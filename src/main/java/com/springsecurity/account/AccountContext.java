package com.springsecurity.account;

public class AccountContext {

    private static final ThreadLocal<Account> ACCOUNT_THREAD_LOCAL = new ThreadLocal<>();

    public static Account getAccount() {
        return ACCOUNT_THREAD_LOCAL.get();
    }

    public static void setAccount(Account account) {
        ACCOUNT_THREAD_LOCAL.set(account);
    }

}
