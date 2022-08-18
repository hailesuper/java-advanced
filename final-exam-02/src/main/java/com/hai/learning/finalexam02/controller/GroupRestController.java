package com.hai.learning.finalexam02.controller;

import com.hai.learning.finalexam02.dto.GroupDto;
import com.hai.learning.finalexam02.entity.Group;
import com.hai.learning.finalexam02.form.CreateGroupForm;
import com.hai.learning.finalexam02.form.UpdateGroupNameForm;
import com.hai.learning.finalexam02.form.filter.GroupFilterForm;
import com.hai.learning.finalexam02.repository.IGroupRepository;
import com.hai.learning.finalexam02.service.IGroupService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/groups")
@CrossOrigin("*")
@Validated
public class GroupRestController {
    @Autowired
    private IGroupService groupService;

    @Autowired
    private IGroupRepository groupRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Page<GroupDto>> getAllGroups(
            Pageable pageable,
            @RequestParam(required = false) String search,
            GroupFilterForm groupFilterForm
    ) {
        Page<Group> groupPage = groupService.getAllGroups(pageable, search, groupFilterForm);

        List<GroupDto> groupFormList = modelMapper.map(
                groupPage.getContent(),
                new TypeToken<List<GroupDto>>(){}.getType()
        );

        Page<GroupDto> groupDTOPage = new PageImpl<>(groupFormList, pageable, groupPage.getTotalElements());
//        List<Group> groups = groupService.getAllGroups();
//        List<GroupDto> groupDtos = modelMapper.map(groups, new TypeToken<List<GroupDto>>() {}.getType());
        return new ResponseEntity<>(groupDTOPage, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GroupDto> getGroupById(@PathVariable int id) {
        var group = groupService.getGroupById(id);
        var groupDto = modelMapper.map(group, GroupDto.class);
        return new ResponseEntity<>(groupDto, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<GroupDto> getGroupByName(@PathVariable String name) {
        var group = groupService.findByName(name);
        if (group == null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            var groupDto = modelMapper.map(group, GroupDto.class);
            return new ResponseEntity<>(groupDto, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<String> createGroup(@RequestBody @Valid CreateGroupForm createGroupForm) {
        groupService.createGroup(createGroupForm);
        return new ResponseEntity<>(createGroupForm.getName() + "has been created!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGroupName(@PathVariable int id, @RequestBody @Valid UpdateGroupNameForm updateGroupNameForm) {
        groupService.updateGroupName(id, updateGroupNameForm);
        return new ResponseEntity<>("Group ID = " + id + " has been updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroup(@PathVariable int id) {
        var tempGroup = groupService.getGroupById(id);
        groupService.deleteGroup(id);
        return new ResponseEntity<>("Group ID = " + id + " has been deleted", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteGroups(@RequestParam(name = "ids") List<Integer> ids) {
        groupService.deleteGroups(ids);
        return new ResponseEntity<>("Group IDs = " + ids + " has been deleted", HttpStatus.OK);
    }

}
