package com.github.mmadson.oopdemo;

import java.util.List;

class DefiningObjects {

    static void demo() {








        // Now that we know what an Object is (a data type with an
        // internal representation and associated operations) how do we
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

            // These are the Operations you can do with an employee
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









        // What was that about Polymorphism?
        class Ceo extends Employee {

            Ceo(final String firstName, final String lastName) {
                super(firstName, lastName, null);
            }

            @Override
            boolean makesMoreThan(final Employee other) {
                return true;
            }
        }




        Ceo jeffBezos = new Ceo("Jeff", "Bezos");

        // A Ceo is still just an Employee
        Employee jeffBezosIsStillAnEmployee = jeffBezos;

        jeffBezos.canAffordRentInSanDiego(); // false, nobody can afford rent in SD
        jeffBezos.makesMoreThan(fredFlinstone); // true
        jeffBezos.makesMoreThan(janeDoe); // true
        System.out.println(jeffBezos.getFormattedName()); // Bezos, Jeff


        // This is an example of using inheritence to polymorphically,
        // override the makesMoreThan() method of the Employee class.






        // However, inheritence isn't the only way to enable polymorphism
        // You can also use interfaces:

        class MyString implements CanLookupIndexOfCharacter {

            private String s;

            MyString(String s) {
                 this.s = s;
            }

            @Override
            public int indexOf(char c) {
                return s.indexOf(c);
            }
        }

        class MyFasterString implements CanLookupIndexOfCharacter {

            private String s;

            MyFasterString(String s) {
                this.s = s;
            }

            @Override
            public int indexOf(char c) {
                // do something clever to lookup the index of c
                // really fast
                return 0;
            }
        }

        class MyListOfCharacters implements CanLookupIndexOfCharacter {

            private List<Character> listOfCharacters;

            MyListOfCharacters(List<Character> listOfCharacters) {
                this.listOfCharacters = listOfCharacters;
            }

            @Override
            public int indexOf(char c) {
                return listOfCharacters.indexOf(c);
            }
        }


        class IndexPrinter {

            private final CanLookupIndexOfCharacter hasIndexedChars;
            private final char charIndexToPrint;

            // The IndexPrinter only cares that whatever you pass it
            // has an indexOf method, it doesn't care what the actual
            // type is.
            IndexPrinter(CanLookupIndexOfCharacter hasIndexedChars,
                char charIndexToPrint) {
                this.hasIndexedChars = hasIndexedChars;
                this.charIndexToPrint = charIndexToPrint;
            }

            void print() {
                // When called, the indexOf method will polymorphically resolve
                // to either MyString, MyFasterString or MyListOfCharacters
                System.out.println(hasIndexedChars.indexOf(charIndexToPrint));
            }
        }


        new IndexPrinter(new MyString("foo"), 'f').print();
        new IndexPrinter(new MyListOfCharacters(List.of('f', 'o', 'o')), 'f').print();
        new IndexPrinter(new MyFasterString("foo"), 'f').print();
    }







    interface CanLookupIndexOfCharacter {
        int indexOf(char c);
    }










}
