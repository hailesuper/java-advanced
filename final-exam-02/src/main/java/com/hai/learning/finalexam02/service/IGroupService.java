package com.hai.learning.finalexam02.service;

import com.hai.learning.finalexam02.entity.Group;
import com.hai.learning.finalexam02.form.CreateGroupForm;
import com.hai.learning.finalexam02.form.UpdateGroupNameForm;
import com.hai.learning.finalexam02.form.filter.GroupFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGroupService {
    Page<Group> getAllGroups(Pageable pageable, String search, GroupFilterForm groupFilterForm);

    Group getGroupById(int id);

    Group findByName(String name);

    void createGroup(CreateGroupForm createGroupForm);

    void updateGroupName(int id, UpdateGroupNameForm updateGroupNameForm);

    void deleteGroup(int id);

    void deleteGroups(List<Integer> ids);
}
