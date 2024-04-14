package models;

import java.util.ArrayList;

// Clase similar a Database1 pero para otra base de datos
public class Database3 implements Database {
    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        students.add(student);
        System.out.println("Registro guardado en la base de datos 3");
    }

    @Override
    public void update(Student student) {
        // Implementación de la actualización en la base de datos 3
        System.out.println("Registro actualizado en la base de datos 3");
    }

    public void mostrar3(){
        for (Student student : students ){
            System.out.println(student);
        }
    }
}
