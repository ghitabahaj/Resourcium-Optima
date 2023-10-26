package com.youcode.resourcium.Service;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.repository.DepartementRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepartementServiceTest {
    @Test
    public void empty_description() {

        DepartementRepository departementRepository = mock(DepartementRepository.class);
        DepartementService departementService = new DepartementService(departementRepository);
        Departement department = new Departement("Department", "");


        assertThrows(IllegalArgumentException.class, () -> {
            departementService.saveDepartement(department);
        });
    }

    @Test
    public void test_return_saved_department() {

        DepartementRepository departementRepository = mock(DepartementRepository.class);
        DepartementService departementService = new DepartementService(departementRepository);
        Departement department = new Departement("Department", "description");


        when(departementRepository.save(department)).thenReturn(department);

        Departement result = departementService.saveDepartement(department);


        assertNotNull(result);


        assertEquals(department.getName(), result.getName());
        assertEquals(department.getDescription(), result.getDescription());
    }

    @Test
    public void test_updateValidDepartmentObject() {

        Departement department = new Departement(1L, "Department 1", "Description 1");


        DepartementRepository departmentRepository = mock(DepartementRepository.class);


        DepartementService departementService = new DepartementService(departmentRepository);


        departementService.updateDepartement(department);


        verify(departmentRepository).update(department);
    }



    @Test
    public void test_updateDepartmentWithEmptyName() {

        Departement department = new Departement(1L, "", "Description 1");


        DepartementRepository departmentRepository = mock(DepartementRepository.class);


        DepartementService departementService = new DepartementService(departmentRepository);


        assertThrows(IllegalArgumentException.class, () -> departementService.updateDepartement(department));
    }


    @Test
    public void test_deleteDepartment_validId() {

        Long id = 1L;
        DepartementRepository departementRepository = mock(DepartementRepository.class);

        DepartementService departementService = new DepartementService(departementRepository);
        Departement department = new Departement("Department", "Description");
        department.setId(id);
        when(departementService.getDepartementById(id)).thenReturn(department);

        doNothing().when(departementRepository).delete(id);


        departementService.deleteDepartement(id);


        assertNull(departementService.getDepartementById(id));

    }

    }