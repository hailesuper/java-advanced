package com.hai.advanced.a1ex2_a2ex1.repository;

import com.hai.advanced.a1ex2_a2ex1.entity.Position;
import com.hai.advanced.a1ex2_a2ex1.utils.HibernateUtils;

import java.util.List;

public class PositionRepository {
    private final HibernateUtils hibernateUtils;

    public PositionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public boolean createPosition(Position.PositionType positionName) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            session.persist(new Position(positionName));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Position> getAllPositions() {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var positions = session.createSelectionQuery(
                    "FROM Position", Position.class)
                    .getResultList();
            session.getTransaction().commit();
            return positions;
        }
    }

    public Position getPositionById(int positionID) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var position = session.get(Position.class, positionID);
            session.getTransaction().commit();
            return position;
        }
    }

    public Position getPositionByPositionName(String positionName) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var PositionByNameQuery = session.createSelectionQuery("FROM Position WHERE positionName=:paramPositionName", Position.class);
            PositionByNameQuery.setParameter("paramPositionName", positionName);
            var Position = PositionByNameQuery.getSingleResult();
            session.getTransaction().commit();
            return Position;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
