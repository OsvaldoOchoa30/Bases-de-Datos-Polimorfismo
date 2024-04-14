package models;

import java.util.ArrayList;

public class Database1 implements Database {
    private ArrayList<Student> studentsList = new ArrayList<>();



    @Override
    public void save(Student student) {
        studentsList.add(student);
        System.out.println("Registro guardado en la base de datos 1");
    }

    @Override
    public void update(Student student) {
        for (Student buscador : studentsList){
            if (buscador.getId()==student.getId()){
                studentsList.set(studentsList.indexOf(buscador), student);
            }
        }
        System.out.println("Registro actualizado en la base de datos 1");
    }

    public void mostrar1(){
        for (Student i : studentsList ){
            System.out.println(i);
        }
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }
}