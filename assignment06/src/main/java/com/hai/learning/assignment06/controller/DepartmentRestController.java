package com.hai.learning.assignment06.controller;

import com.hai.learning.assignment06.entity.Department;
import com.hai.learning.assignment06.repository.IDepartmentRepository;
import com.hai.learning.assignment06.service.IDepartmentService;
import com.hai.learning.assignment06.utils.HibernateUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        try (var session = HibernateUtils.getInstance().getSession()) {
            session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
            Root<Department> departmentRoot = criteriaQuery.from(Department.class);
            criteriaQuery.select(departmentRoot);

            List<Department> departments = session.createQuery(criteriaQuery).getResultList();

            session.getTransaction().commit();
            return departments;
        }
//        return departmentService.getAllDepartments();
    }

//    @Override
//    public List<Department> getAllDepartments() {
//        try (var session = hibernateUtils.getSession()) {
//            session.beginTransaction();
//
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<Department> criteriaQuery = criteriaBuilder.createQuery(Department.class);
//            Root<Department> departmentRoot = criteriaQuery.from(Department.class);
//            criteriaQuery.select(departmentRoot);
//
//            List<Department> departments = session.createQuery(criteriaQuery).getResultList();
//
//            session.getTransaction().commit();
//            return departments;
//        }
//    }
//
//    @GetMapping("/departmentSearch")
//    public List<Department> getDepartmentsWithCriteria(
//            @RequestParam(defaultValue = "1") int pageNumber,
//            @RequestParam(defaultValue = "5") int pageSize,
//            @RequestParam(defaultValue = "") String departmentNameSearch,
//            @RequestParam(defaultValue = "departmentId") String sortBy,
//            @RequestParam(defaultValue = "asc") String sortType
//    ) {
//        return departmentService.getDepartmentsWithCriteria(pageNumber, pageSize, departmentNameSearch, sortBy, sortType);
//    }
//
////     Test getDepartmentById using @RequestParam
//    @GetMapping("/department/{id}")
//    public Department getDepartmentById(@PathVariable("id") int id) {
//        return departmentService.getDepartmentById(id);
//    }
//


//    @GetMapping("/departmentsNew")
//    public List<Department> getDepartmentsWithCriteria() {
//        return departmentService.getDepartmentsWithCriteria();
//    }



//    filter, paging, sort
}
