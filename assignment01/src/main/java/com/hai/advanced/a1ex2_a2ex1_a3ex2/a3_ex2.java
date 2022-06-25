package com.hai.advanced.a1ex2_a2ex1_a3ex2;

import com.hai.advanced.a1ex2_a2ex1_a3ex2.repository.*;

import java.util.Scanner;

public class a3_ex2 {
    public static void main(String[] args) {
        var accountRepository = new AccountRepository();
        var positionRepository = new PositionRepository();
        var departmentRepository = new DepartmentRepository();

        while (true) {
            System.out.println("Bắt đầu ");
            printInstruction();
            var scanner = new Scanner(System.in);
            var select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> {
                    var tempAccount = accountRepository.getAccountById(1);
                    var tempGroupsCreatedByAccount1 = tempAccount.getCompanyGroupsByCreator();
                    System.out.println(tempGroupsCreatedByAccount1);
                }
                case 2 -> {
                    var tempAccount = accountRepository.getAccountById(11);
                    System.out.println(tempAccount);
                }
                case 3 -> {
                    var tempDepartment = departmentRepository.getDepartmentById(5);
                    System.out.println(tempDepartment.getAccounts());
                }
                case 4 -> {
                    var tempPosition = positionRepository.getPositionById(4);
                    System.out.println(tempPosition.getAccounts());
                }
                case 5 -> {
                    departmentRepository.deleteDepartmentById(1);
                    System.out.println(departmentRepository.getDepartmentById(1).getAccounts());
                }
                case 6 -> {
                    System.out.println(accountRepository.getAccountById(1).getCompanyGroups());
                }

            }
            System.out.print("Continue? (Y/N) ");
            if (scanner.nextLine().strip().equalsIgnoreCase("n")) break;
        }
    }

    private static void printInstruction() {
        System.out.println("" +
                "1. Check group created by an account\n" +
                "2. Get an account information\n" +
                "3. Get accounts from a department\n" +
                "4. Get accounts of a position\n" +
                "5. Delete department cascade\n" +
                "6. Get groups that account belongs to\n" +
                "Lựa chọn: ");
    }
}
