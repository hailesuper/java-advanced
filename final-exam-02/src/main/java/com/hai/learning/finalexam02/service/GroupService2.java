package com.hai.learning.finalexam02.service;

import com.hai.learning.finalexam02.entity.Group;
import com.hai.learning.finalexam02.form.CreateGroupForm;
import com.hai.learning.finalexam02.form.UpdateGroupNameForm;
import com.hai.learning.finalexam02.form.filter.GroupFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class GroupService2 implements IGroupService{
    @Override
    public Page<Group> getAllGroups(Pageable pageable, String search, GroupFilterForm groupFilterForm) {
        return null;
    }

    @Override
    public Group getGroupById(int id) {
        return null;
    }

    @Override
    public Group findByName(String name) {
        return null;
    }

    @Override
    public void createGroup(CreateGroupForm createGroupForm) {

    }

    @Override
    public void updateGroupName(int id, UpdateGroupNameForm updateGroupNameForm) {

    }

    @Override
    public void deleteGroup(int id) {

    }

    @Override
    public void deleteGroups(List<Integer> ids) {

    }
}
