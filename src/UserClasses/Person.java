/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserClasses;

/**
 *
 * @author Alexander
 */
public class Person {

    int age;
    String firstName, lastName;

    public Person(String firstName, String lastName, int age) {
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
    }

}
