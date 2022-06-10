package com.hai.advanced.a1ex2_a2ex1_a3ex2.repository;

import com.hai.advanced.a1ex2_a2ex1_a3ex2.entity.*;
import com.hai.advanced.a1ex2_a2ex1_a3ex2.utils.HibernateUtils;

import java.util.List;

public class AccountRepository {
    private final HibernateUtils hibernateUtils;

    public AccountRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public boolean createAccount(String email, String username, String fullName) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            session.persist(new Account(email,username,fullName));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createAccount(Account account) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            session.persist(account);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Account> getAllAccounts() {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var accounts = session.createSelectionQuery("FROM Account", Account.class)
                    .getResultList();
            session.getTransaction().commit();
            return accounts;
        }
    }

    public Account getAccountById(int accountID) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var account = session.get(Account.class, accountID);
            session.getTransaction().commit();
            return account;
        }
    }

    public Account getAccountByUsername(String username) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var AccountByNameQuery = session.createSelectionQuery("FROM Account WHERE username=:paramUsername", Account.class);
            AccountByNameQuery.setParameter("paramUsername", username);
            var Account = AccountByNameQuery.getSingleResult();
            session.getTransaction().commit();
            return Account;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public boolean updateAccount(Account Account) {
//        try (var session = hibernateUtils.getSession()) {
//            session.beginTransaction();
//            session.merge(Account);
//            session.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }


//    public boolean updateAccount(int AccountID, String newAccountName) {
//        try (var session = hibernateUtils.getSession()) {
//            session.beginTransaction();
//            var newAccount = getAccountById(AccountID);
//            newAccount.setAccountName(newAccountName);
//            session.merge(newAccount);
//            session.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean deleteAccount(Account Account) {
//        try (var session = hibernateUtils.getSession()) {
//            session.beginTransaction();
//            session.remove(Account);
//            session.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean deleteAccount(int AccountID) {
//        try (var session = hibernateUtils.getSession()) {
//            session.beginTransaction();
//            session.remove(getAccountById(AccountID));
//            session.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean isAccountExistsById(int AccountID) {
//        try (var session = hibernateUtils.getSession()) {
//            return getAccountById(AccountID) != null;
//        }
//    }
//
//    public boolean isAccountExistsByName(String AccountName) {
//        try (var session = hibernateUtils.getSession()) {
//            return getAccountByName(AccountName) != null;
//        }
//    }
}
