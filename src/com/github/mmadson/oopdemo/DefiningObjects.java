package com.github.mmadson.oopdemo;

class DefiningObjects {

    static void demo() {








        // Now that we know what an Object is (an encapsulated internal
        // representation and associated operations) how do we
        // define our own Objects so that we can model our application's
        // domain?








        // Let's model an Employee
        class Employee {

            // Internal Representation for an Employee
            private String firstName;
            private String lastName;
            private Long yearlySalaryInCents;

            // The constructor is called when we create a new Employee instance
            // using the new keyword
            Employee(String firstName, String lastName, Long yearlySalaryInCents) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.yearlySalaryInCents = yearlySalaryInCents;
            }

            // These are the Operations you can perform with an Employee
            String getFormattedName() {
                return lastName+", "+firstName;
            }

            boolean makesMoreThan(Employee other) {
                return this.yearlySalaryInCents > other.yearlySalaryInCents;
            }

            boolean canAffordRentInSanDiego() {
                return false;
            }
        }






        // Let's see our first Object in action!
        Employee janeDoe = new Employee("Jane", "Doe", 70_000L * 100L);
        Employee fredFlinstone = new Employee("Fred", "Flinstone", 10_000L * 100L);

        janeDoe.makesMoreThan(fredFlinstone); // true
        janeDoe.canAffordRentInSanDiego(); // false
        fredFlinstone.canAffordRentInSanDiego(); // false

        System.out.println(janeDoe.getFormattedName()); // Doe, Jane
        System.out.println(fredFlinstone.getFormattedName()); // Flinstone, Fred







        // That was an example of encapsulation and message passing,
        // but what about the other aspect of Object Oriented Programming --
        // late binding? How do we take advantage of that?










        // One approach to leveraging late binding of function calls is to
        // utilize Polymorphism via Inheritance. Polymorphism gives us
        // late binding of function calls depending on the type
        // of the runtime object.









        // Inheritance allows us to create a new class of object that
        // inherits state and behavior from a parent class.
        class Ceo extends Employee {

            Ceo(String firstName, String lastName) {
                super(firstName, lastName, null);
            }

            @Override
            boolean makesMoreThan(Employee other) {
                return true;
            }
        }





        Ceo jeffBezos = new Ceo("Jeff", "Bezos");

        // A Ceo is still just an Employee
        Employee stillAnEmployee = jeffBezos;

        stillAnEmployee.makesMoreThan(fredFlinstone); // true
        stillAnEmployee.makesMoreThan(janeDoe); // true
        stillAnEmployee.canAffordRentInSanDiego(); // false, nobody can
        System.out.println(stillAnEmployee.getFormattedName()); // Bezos, Jeff

        // This is an example of using inheritence to polymorphically,
        // override the makesMoreThan() method of the Employee class.






        // However, inheritence isn't the only way to leverage late binding and
        // some would say inheritance should almost always be avoided.

        // So another way that you can leverage late binding is through
        // interfaces:
        class EmployeeV2 implements CanCheckIfRentIsAfforableInSd {

            private String firstName;
            private String lastName;
            private Long salary;

            EmployeeV2(String firstName, String lastName, Long salary) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.salary = salary;
            }

            @Override
            public Boolean canAffordRentInSd() {
                return false;
            }
        }

        class CeoV2 implements CanCheckIfRentIsAfforableInSd {

            private String firstName;
            private String lastName;

            CeoV2(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public Boolean canAffordRentInSd() {
                return true;
            }
        }










        EmployeeV2 employee = new EmployeeV2("Jane", "Doe", 70_000L);
        CeoV2 ceo = new CeoV2("Jeff", "Bezos");

        canAffordRent(employee); // false
        canAffordRent(ceo); // true









    }













    private static Boolean canAffordRent(CanCheckIfRentIsAfforableInSd canCheck) {
        return canCheck.canAffordRentInSd();
    }












    interface CanCheckIfRentIsAfforableInSd {
        Boolean canAffordRentInSd();
    }










}
