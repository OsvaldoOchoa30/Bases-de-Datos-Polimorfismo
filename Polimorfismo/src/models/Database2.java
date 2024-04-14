package models;

import java.util.ArrayList;

public class Database2 implements Database {
    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        students.add(student);
        System.out.println("Registro guardado en la base de datos 2");
    }

    @Override
    public void update(Student student) {
        // Implementación de la actualización en la base de datos 2
        System.out.println("Registro actualizado en la base de datos 2");
    }

    public void mostrar2(){
        for (Student student : students ){
            System.out.println(student);
        }
    }
}