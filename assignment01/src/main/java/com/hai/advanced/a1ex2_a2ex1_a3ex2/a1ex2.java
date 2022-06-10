package com.hai.advanced.a1ex2_a2ex1_a3ex2;

import com.hai.advanced.a1ex2_a2ex1_a3ex2.repository.*;

import java.util.Scanner;

public class a1ex2 {
    public static void main(String[] args) {
        var accountRepository = new AccountRepository();

        while (true) {
            System.out.println("Bắt đầu ");
            printInstruction();
            var scanner = new Scanner(System.in);
            var select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> accountRepository.createAccount("test@test.com","testAccount","Lê Văn Hải");
                case 2 -> System.out.println(accountRepository.getAllAccounts());
                case 3 -> System.out.println(accountRepository.getAccountById(2));
                case 4 -> System.out.println(accountRepository.getAccountByUsername("testAccount"));
//                case 5 -> System.out.println(accountRepository.updateAccount(new Account(1, "newDynamic")));
//                case 6 -> System.out.println(accountRepository.updateAccount(2, "newYakiniku"));
//                case 7 -> System.out.println(accountRepository.deleteAccount(new Account(2)));
//                case 8 -> System.out.println(accountRepository.deleteAccount(2));
//                case 9 -> System.out.println(accountRepository.isAccountExistsById(1));
//                case 10 -> System.out.println(accountRepository.isAccountExistsByName("Dynamic"));
            }
            System.out.print("Continue? (Y/N) ");
            if (scanner.nextLine().strip().equalsIgnoreCase("n")) break;
        }

    }

    private static void printInstruction() {
        System.out.println("" +
                "1. createAccount\n" +
                "2. getAllAccounts\n" +
                "3. getAccountByID\n" +
                "4. getAccountByName\n" +
//                "5. updateAccount(accountObject)\n" +
//                "6. updateAccount(id, newAccountName)\n" +
//                "7. deleteAccount(accountObject)\n" +
//                "8. deleteAccount(accountID)\n" +
//                "9. isAccountExistByID\n" +
//                "10. isAccountExistByName\n" +
                "Lựa chọn: ");
    }
}
