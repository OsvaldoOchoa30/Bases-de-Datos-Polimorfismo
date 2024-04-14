import models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrance = new Scanner(System.in);

        // Creamos instancias de las bases de datos y las almacenamos en variables de tipo Database
        Database1 db1 = new Database1();
        Database2 db2 = new Database2();
        Database3 db3 = new Database3();

        boolean flag = true;
        do {
        System.out.println("Elige una opcion: ");
        String eleccion = entrance.next();
        entrance.nextLine();
Student  myStudent = new Student();
            switch (eleccion) {

                case "1":
                    System.out.println("Agregar Estudiante.");
                    // Creamos un nuevo estudiante
                    System.out.print("Ingresa el nombre del Estudiante: ");
                    myStudent.setName(entrance.nextLine());
                    System.out.print("Ingresa la edad del Estudiante: ");
                    myStudent.setAge(entrance.nextInt());
                    System.out.println("Ingresa ID:");
                    myStudent.setId(entrance.nextInt());



                    // Guardamos el estudiante en todas las bases de datos
                    guardarEnTodasLasBasesDeDatos(myStudent, db1);
                    guardarEnTodasLasBasesDeDatos(myStudent, db2);
                    guardarEnTodasLasBasesDeDatos(myStudent, db3);
                    break;

                case "2":
                System.out.println("Modificar.");
                db1.mostrar1();
                System.out.println("Ingrese el ID del estudiante a modificar:");
                int estudianteModificar = entrance.nextInt(); // Leer el ID del estudiante
                entrance.nextLine(); // Consumir el salto de línea pendiente

// Buscar el estudiante que se desea modificar en la base de datos
                Student studentAModificar = null;
                for (Student student : db1.getStudentsList()) {
                    if (student.getId() == estudianteModificar) {
                        studentAModificar = student;
                        break;
                    }
                }

// Si se encontró el estudiante, solicitar y establecer los nuevos datos
                if (studentAModificar != null) {
                    System.out.print("Nuevo nombre del estudiante: ");
                    String nuevoNombre = entrance.nextLine();
                    studentAModificar.setName(nuevoNombre);

                    System.out.print("Nueva edad del estudiante: ");
                    int nuevaEdad = entrance.nextInt();
                    studentAModificar.setAge(nuevaEdad);

                    // Llamar al método update en db1 pasando el estudiante modificado
                    db1.update(studentAModificar);
                    System.out.println("Estudiante actualizado en la base de datos 1");
                } else {
                    System.out.println("El estudiante con el ID ingresado no se encontró.");
                }
                break;




                case "3":
                    System.out.println("Base de Datos 1: ");
                    db1.mostrar1();
                    break;
                case "4":
                    System.out.println("Base de Datos 2: ");
                    db2.mostrar2();
                    break;
                case"5":
                    System.out.println("Base de Datos 3: ");
                    db3.mostrar3();
                    break;


                default:
                    flag = false;

            }
        } while (flag) ;

        // Actualizamos el estudiante en todas las bases de datos
        /*actualizarEnTodasLasBasesDeDatos(student, db1);
        actualizarEnTodasLasBasesDeDatos(student, db2);
        actualizarEnTodasLasBasesDeDatos(student, db3);*/
    }


    // Método para guardar un estudiante en una base de datos
    static void guardarEnTodasLasBasesDeDatos(Student student, Database database) {
        database.save(student);
    }

    // Método para actualizar un estudiante en una base de datos
    static void actualizarEnTodasLasBasesDeDatos(Student student, Database database) {
        database.update(student);
    }
}