package com.hai.learning.finalexam02.service;

import com.hai.learning.finalexam02.entity.Group;
import com.hai.learning.finalexam02.form.CreateGroupForm;
import com.hai.learning.finalexam02.form.UpdateGroupNameForm;
import com.hai.learning.finalexam02.form.filter.GroupFilterForm;
import com.hai.learning.finalexam02.repository.IGroupRepository;
import com.hai.learning.finalexam02.repository.IUserRepository;
import com.hai.learning.finalexam02.specification.GroupSpecification;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class GroupService implements IGroupService {
    @Autowired
    IGroupRepository groupRepository;

    @Autowired
    IUserRepository userRepository;
    
    @Override
    public Page<Group> getAllGroups(Pageable pageable, String search, GroupFilterForm groupFilterForm) {
        var where = GroupSpecification.buildWhere(search, groupFilterForm);
        return groupRepository.findAll(where, pageable);
    }

    @Override
    public Group getGroupById(int id) {
        var group = groupRepository.findById(id);
        if (group.isEmpty()) {
            throw new NoSuchElementException("Group " + id + " không tồn tại!");
        }
        return group.get();
    }

    @Override
    public Group findByName(String name) {
        return groupRepository.findByName(name);
    }

    @Override
    public void createGroup(CreateGroupForm createGroupForm) {
        var newGroup = new Group(createGroupForm.getName(), createGroupForm.getTotalMember(), createGroupForm.getCreateDate());
        var newGroupCreator = userRepository.findById(createGroupForm.getCreatorId()).get();
        newGroup.setCreator(newGroupCreator);
        if (newGroup.getCreateDate() == null)
            newGroup.setCreateDate(LocalDate.now());
        groupRepository.save(newGroup);
    }

    @Override
    public void updateGroupName(int id, UpdateGroupNameForm updateGroupNameForm) {
        var oldGroup = groupRepository.findById(id).get();
        if (!StringUtils.isBlank(updateGroupNameForm.getName())) {
            oldGroup.setName(updateGroupNameForm.getName());
        }
        groupRepository.save(oldGroup);
    }

    @Override
    public void deleteGroup(int id) {
        groupRepository.deleteById(id);
    }

    @Override
    public void deleteGroups(List<Integer> ids) {
        groupRepository.deleteByIds(ids);
    }
}
