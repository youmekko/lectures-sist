package com.test;

import java.util.List;

public interface StudentDAO {

   public void create(String name, Integer age, Integer marks, Integer year);
   public List<StudentMarks> listStudents();
   
}