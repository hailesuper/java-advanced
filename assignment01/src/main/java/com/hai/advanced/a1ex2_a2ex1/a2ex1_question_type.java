package com.hai.advanced.a1ex2_a2ex1;

import com.hai.advanced.a1ex2_a2ex1.entity.QuestionType;
import com.hai.advanced.a1ex2_a2ex1.repository.QuestionTypeRepository;

import java.util.Scanner;

public class a2ex1_question_type {
    public static void main(String[] args) {
        var questionTypeRepository = new QuestionTypeRepository();

        while (true) {
            System.out.println("Bắt đầu ");
            printInstruction();
            var scanner = new Scanner(System.in);
            var select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> questionTypeRepository.createQuestionType(QuestionType.QuestionTypeName.MULTIPLE_CHOICE);
                case 2 -> System.out.println(questionTypeRepository.getAllQuestionTypes());
            }
            System.out.print("Continue? (Y/N) ");
            if (scanner.nextLine().strip().equalsIgnoreCase("n")) break;
        }

    }

    private static void printInstruction() {
        System.out.println("" +
                "1. createQuestionType\n" +
                "2. getAllQuestionTypes\n" +
                "Lựa chọn: ");
    }
}
