package com.springboot.starter.services.implement;

public class Employee {

    private final String firstName;    //required

    private final String lastName;    //required

    private final int age;    //required


    public static class EmployeeBuilder {

        private final String firstName;    //required

        private final String lastName;    //required

        private final int age;    //required

        private final int personalId; // required


        public EmployeeBuilder(String firstName, String lastName, int age, int personalId) {

            this.firstName = firstName;

            this.lastName = lastName;

            this.age = age;

            this.personalId = personalId;
        }

        private Employee build() {

            // call the private constructor in the outer class

            return new Employee(this);

        }

    }

    private Employee(EmployeeBuilder builder) {

        this.firstName = builder.firstName;

        this.lastName = builder.lastName;

        this.age = builder.age;
        this.ss();

    }

    public String getFirstName() {

        return firstName;

    }

    public String getLastName() {

        return lastName;

    }

    public int getAge() {

        return age;

    }


    public void ss(){
        System.out.println("==================================xx"+ this.toString());
    }

    @Override
    public String toString(){
        String a="Employee: "+ getFirstName() + getLastName() + getAge();
        return  a;
    }


    public static void main(String[] args) {
        Employee employee = new Employee.EmployeeBuilder("Cristiano", "Ronaldo", 33, 7).build();
    }

}


