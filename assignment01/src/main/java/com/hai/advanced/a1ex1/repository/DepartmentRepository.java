package com.hai.advanced.a1ex1.repository;

import com.hai.advanced.a1ex1.entity.Group;
import com.hai.advanced.a1ex1.utils.HibernateUtils;

import java.util.List;

public class DepartmentRepository {
    private final HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public boolean createGroup(String groupName) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            session.persist(new Group(groupName));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Group> getAllGroups() {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var groups = session.createSelectionQuery("FROM Group", Group.class)
                    .getResultList();
            session.getTransaction().commit();
            return groups;
        }
    }

    public Group getGroupById(int groupID) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var group = session.get(Group.class, groupID);
            session.getTransaction().commit();
            return group;
        }
    }

    public Group getGroupByName(String groupName) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var groupByNameQuery = session.createSelectionQuery("FROM Group WHERE groupName=:paramGroupName", Group.class);
            groupByNameQuery.setParameter("paramGroupName", groupName);
            var group = groupByNameQuery.getSingleResult();
            session.getTransaction().commit();
            return group;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateGroup(Group group) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            var groupID = group.getId();
            session.merge(group);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateGroup(int groupID, String newGroupName) {
        try (var session = hibernateUtils.getSession()) { // try with resource Java 8
            session.beginTransaction(); // start transaction
            var newGroup = getGroupById(groupID);
            newGroup.setGroupName(newGroupName);
            session.merge(newGroup);
            session.getTransaction().commit(); // commit transaction
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteGroup(Group group) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            session.remove(group);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteGroup(int groupID) {
        try (var session = hibernateUtils.getSession()) {
            session.beginTransaction();
            session.remove(getGroupById(groupID));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isGroupExistsById(int groupID) {
        try (var session = hibernateUtils.getSession()) {
            return getGroupById(groupID) != null;
        }
    }

    public boolean isGroupExistsByName(String groupName) {
        try (var session = hibernateUtils.getSession()) {
            return getGroupByName(groupName) != null;
        }
    }
}
