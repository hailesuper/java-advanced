package com.hai.advanced.a1ex2_a2ex1_a3ex2.repository;

import com.hai.advanced.a1ex2_a2ex1_a3ex2.entity.QuestionType;
import com.hai.advanced.a1ex2_a2ex1_a3ex2.utils.HibernateUtils;

import java.util.List;

public class QuestionTypeRepository {
    private final HibernateUtils hibernateUtils;

    public QuestionTypeRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public boolean createQuestionType(QuestionType.QuestionTypeName questionTypeName) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            session.persist(new QuestionType(questionTypeName));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<QuestionType> getAllQuestionTypes() {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var questionTypes = session.createSelectionQuery(
                    "FROM QuestionType", QuestionType.class)
                    .getResultList();
            session.getTransaction().commit();
            return questionTypes;
        }
    }
}
