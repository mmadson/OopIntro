package com.github.mmadson.oopdemo;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class CreatingAndUsingObjects {

    static void demo() throws Exception {








        // Q: What is Object Oriented Programming?

        // According to Alan Kay, who coined the term:
        // OOP to me means only
        // - messaging
        // - (local retention and protection and hiding) of state-process
        // - and extreme late-binding of all things

        // According to Wikipedia:
        // Object-oriented programming (OOP) is a programming paradigm
        // based on the concept of "objects", which may contain data,
        // in the form of fields, often known as attributes;
        // and code, in the form of procedures, often known as methods.

        // To Summarize:
        // Object Oriented Programming is an approach to designing
        // software that models your application's domain using
        // encapsulated objects that communicate with one another
        // via message passing










        // Q: What is an Object (In Java)?









        // Integers are objects

        // They represent a signed whole number between -2^31 to 2^31-1
        Integer fortyTwo = new Integer(42);
        Integer fortyTwoFromIntegerLiteral = 42;


        // You can do some cool things with them
        fortyTwo.compareTo(fortyTwoFromIntegerLiteral); // returns 0, meaning equal
        fortyTwoFromIntegerLiteral.toString(); // returns "42"






        // Strings are objects

        // They represent a sequence of characters
        String aStringObject = new String("I'm a string and full of character!");

        // You can do some cool things with them
        aStringObject.indexOf('f');// returns 17
        Boolean containsCharacter = aStringObject.contains("character"); // true

        String stringObjectFromStringLiteral = "perhaps this is more familiar?";
        stringObjectFromStringLiteral.indexOf('f'); // returns 21











        // Lists are objects

        // They represent an ordered collection of other object instances
        List<String> shoppingList = List.of("spam",
            "spam",
            "spam",
            "baked beans",
            "more spam"
        );

        // You can do some cool things with them
        shoppingList.get(2); // get the String instance at index 2 of the List
        shoppingList.size(); // returns 5
        shoppingList.removeIf(s -> s.contains("spam"));








        // Maps are objects

        // They represent a collection of unique keys and the values
        // associated with those keys
        Map<URI,String> uriToBookmarkName = Map.of(
            new URI("https://www.youtube.com"), "Cat Videos",
            new URI("https://stackoverflow.com"), "Programmer's Lifeline",
            new URI("http://www.matthewmadson.com"), "Shameless Self Promotion"
        );

        // You can do some cool things with them
        uriToBookmarkName.get(new URI("http://www.matthewmadson.com"));
        // returns "Shameless Self Promotion
        uriToBookmarkName.containsValue("Cat Videos"); // returns true









        // An Object is a software component that has an encapsulated
        // internal representation and methods for interacting with it.
        // This is what Alan Kay was referring to when he said that OOP
        // involved messaging and (local retention, protection and hiding)
        // of state-process. In Java the messaging is performed using method
        // calls on the object and the local retention, protection and hiding of
        // state and process refer to the fact that the internal representation
        // for these objects and how the methods are implemented is not exposed
        // to us as users of the objects.












        // Why is it useful to think of our data and procedures using Objects?











        // Consider the alternative. Instead of using a String object to model
        // a sequence of characters, let's work with a primative (not an object)
        // array of characters and see how we might structure our code.

        char[] rawString = new char[] {'u', 'g', 'h', '!'};

        // Say we want to find the index of the character g in our raw "String".
        // We would need to iterate over the characters explicitly:
        int index = -1;
        for (int i = 0; i < rawString.length; i++) {
            if(rawString[i] == 'g') {
                index = i;
                break;
            }
        }







        // If we do this operation frequently, this gets very tiring to write.
        // We could move this operation to a standalone function to avoid
        // repetition:

        int slightlyBetter = indexOf(rawString, 'g');
        // P.S. This is typically how classical structured programming
        // was done in the days of C, Fortran and COBOL.








        // But there are 2 problems with this approach.
        // 1) How do we know where to find the indexOf function in a large
        // codebase?
        // 2) What if we came up with a faster indexOf method but it
        // relied on the String being represented as a
        // LinkedList of characters instead of a character array?
        // Without using Objects we would need to do something
        // like the following:

        final LinkedList<Character> linkedList = convertToLinkedList(rawString);
        int sad = fasterIndexOf(linkedList, 'g');








        // Now let's revisit our object oriented approach:

        String muchBetter = "not, ugh!";
        muchBetter.indexOf('g'); // could be slow in String v1, and fast in v2

        // The object oriented String class alleviates both of our problems.
        // 1) It's easy to find the indexOf function, because
        // it's a member of the String class, aka a method.
        // 2) If a faster indexOf algorithm is discovered, our code doesn't
        // need to change. The internal representation for a
        // String can be modified without us knowing and the faster
        // indexOf can be implemented without us having to change our
        // call to indexOf.








        // The capability of hiding an internal represention is called Encapsulation
        // and the capability of the indexOf method using either a slow version
        // or a fast version depending on the particular instance of a String
        // is referred to as late binding of the function call. Together,
        // encapsulation, late binding and message passing make up the primary
        // benefits of Object Oriented design, just as Alan Kay asserted.









    }









    private static int fasterIndexOf(final LinkedList<Character> characters, final char g) {
        // for demo purposes only
        return -1;
    }








    private static LinkedList<Character> convertToLinkedList(final char[] rawString) {
        // for demo purposes only
        return new LinkedList<>();
    }








    private static int indexOf(char[] rawString, char charToFind) {
        int index = -1;
        for (int i = 0; i < rawString.length; i++) {
            if(rawString[i] == charToFind) {
                index = i;
                break;
            }
        }
        return index;
    }






}
