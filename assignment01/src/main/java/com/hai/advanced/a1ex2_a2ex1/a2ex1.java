package com.hai.advanced.a1ex2_a2ex1;

import com.hai.advanced.a1ex2_a2ex1.entity.Position;
import com.hai.advanced.a1ex2_a2ex1.repository.PositionRepository;

import java.util.Scanner;

public class a2ex1 {
    public static void main(String[] args) {
        var positionRepository = new PositionRepository();

        while (true) {
            System.out.println("Bắt đầu ");
            printInstruction();
            var scanner = new Scanner(System.in);
            var select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> positionRepository.createPosition(Position.PositionType.SCRUM_MASTER);
                case 2 -> System.out.println(positionRepository.getAllPositions());
                case 3 -> System.out.println(positionRepository.getPositionById(2));
                case 4 -> System.out.println(positionRepository.getPositionByPositionName("Scrum Master"));
            }
            System.out.print("Continue? (Y/N) ");
            if (scanner.nextLine().strip().equalsIgnoreCase("n")) break;
        }

    }

    private static void printInstruction() {
        System.out.println("" +
                "1. createPosition\n" +
                "2. getAllPositions\n" +
                "3. getPositionByID\n" +
                "4. getPositionByPositionName\n" +
                "Lựa chọn: ");
    }
}
