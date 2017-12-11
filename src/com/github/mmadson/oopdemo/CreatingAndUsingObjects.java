package com.github.mmadson.oopdemo;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class CreatingAndUsingObjects {

    static void demo() throws Exception {








        // Q: What is Object Oriented Programming?

        // An approach to designing software which models your application's data
        // and the operations you can perform on that data using Objects.










        // Q: What is an Object?











        // Strings are objects

        // They represent a sequence of characters
        String aStringObject = new String("I'm a string and full of character!");

        // You can do some cool things with them
        aStringObject.indexOf('f'); // returns 17
        aStringObject.contains("string"); // returns true

        String stringObjectFromStringLiteral = "perhaps this is more familiar?";
        stringObjectFromStringLiteral.indexOf('f'); // returns 21








        // Integers are objects

        // They represent a signed whole number between -2^31 to 2^31-1
        Integer fortyTwo = new Integer(42);
        Integer fortyTwoFromIntegerLiteral = 42;

        // You can do some cool things with them
        fortyTwo.compareTo(fortyTwoFromIntegerLiteral); // returns 0, meaning equal












        // Lists are objects

        // They represent an ordered collection of other object instances
        List<String> shoppingList = List.of("spam",
            "spam",
            "spam",
            "baked beans",
            "more spam"
        );

        // You can do some cool things with them
        shoppingList.size();
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
        uriToBookmarkName.getOrDefault(new URI("https://www.google.com"), "The Borg");
        uriToBookmarkName.containsValue("Cat Videos");









        // So an Object is a data type, which has an internal representation
        // and a set of operations related to its internal representation.











        // Why is it useful to think of our data and functions using Objects?











        // Consider the alternative. Instead of using a String object to model
        // a sequence of characters, let's work with an array of characters and
        // see how we might structure our code.

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
        // was done in the days of C and Assembly.








        // But there are 2 problems with this approach.
        // 1) How do we know where to find the indexOf function in a large codebase?
        // 2) What if we came up with a faster indexOf method but it relied on the
        // String being represented as a LinkedList of characters instead of
        // a character array? Without using Objects we would need to
        // do something like the following:

        int sad = fasterIndexOf(convertToLinkdList(rawString), 'g');








        // Now let's revisit our object oriented approach:

        String muchBetter = "not, ugh!";
        muchBetter.indexOf('g'); // could be slow in String v1, and fast in v2

        // The object oriented String class alleviates both of our problems.
        // 1) It's easy to find the indexOf function, because it's a member of the
        // String class, aka a method.
        // 2) If a faster indexOf algorithm is discovered, our code doesn't need to
        // change. The internal representation for a String can be modified without
        // us knowing and the faster indexOf can be implemented without us having to
        // change our call to indexOf.








        // The capability of hiding an internal represention is called Encapsulation
        // and the capability of the indexOf method using either a slow implementation
        // or a fast implementation depending on the particular instance of String
        // created is called polymorphism. Together, encapsulation and polymorphism
        // make up the primary benefits of Object Oriented design.









    }









    private static int fasterIndexOf(final LinkedList<Character> characters, final char g) {
        // for demo purposes only
        return -1;
    }








    private static LinkedList<Character> convertToLinkdList(final char[] rawString) {
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
