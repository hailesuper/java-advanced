package com.hai.advanced.ex1;

import com.hai.advanced.ex1.entity.Group;
import com.hai.advanced.ex1.repository.DepartmentRepository;

import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {
        var departmentRepository = new DepartmentRepository();

        while (true) {
            System.out.println("Bắt đầu ");
            printInstruction();
            var scanner = new Scanner(System.in);
            var select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> departmentRepository.createGroup("Yakiniku大好き");
                case 2 -> System.out.println(departmentRepository.getAllGroups());
                case 3 -> System.out.println(departmentRepository.getGroupById(2));
                case 4 -> System.out.println(departmentRepository.getGroupByName("Dynamic"));
                case 5 -> System.out.println(departmentRepository.updateGroup(new Group(1, "newDynamic")));
                case 6 -> System.out.println(departmentRepository.updateGroup(2, "newYakiniku"));
                case 7 -> System.out.println(departmentRepository.deleteGroup(new Group(2)));
                case 8 -> System.out.println(departmentRepository.deleteGroup(2));
                case 9 -> System.out.println(departmentRepository.isGroupExistsById(1));
                case 10 -> System.out.println(departmentRepository.isGroupExistsByName("Dynamic"));
            }
            System.out.print("Continue? (Y/N) ");
            if (scanner.nextLine().strip().equalsIgnoreCase("n")) break;
        }

    }

    private static void printInstruction() {
        System.out.println("" +
                "1. createGroup\n" +
                "2. getAllGroups\n" +
                "3. getGroupByID\n" +
                "4. getGroupByName\n" +
                "5. updateGroup(groupObject)\n" +
                "6. updateGroup(id, newGroupName)\n" +
                "7. deleteGroup(groupObject)\n" +
                "8. deleteGroup(groupID)\n" +
                "9. isGroupExistByID\n" +
                "10. isGroupExistByName\n" +
                "Lựa chọn: ");
    }
}
