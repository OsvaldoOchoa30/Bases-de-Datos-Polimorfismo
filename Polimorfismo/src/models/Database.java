package models;

// Interfaz que define los métodos save y update
public interface Database {
    void save(Student student);
    void update(Student student);
}