# JavaLabs

# LAB#1

  1.1 Individual task <br>
  Develop a hierarchy of classes to represent the essence of the individual task. The basic abstract class, which represents the second essence of an individual task, should not contain data, only abstract access methods, overriding the functions toString () and equals (), as well as the implementation of functions defined by the previous task. This class must also implement a Comparable interface to naturally compare objects when sorting by one of the attributes.
  The basic abstract class, which represents the first of the essences of the individual task, must contain:
  - abstract functions for data access;
  - abstract functions for access to the sequence of elements of the type of the second abstract class;
  - abstract functions of sorting of elements of sequence on certain signs according to the individual task;
  - override the function toString () to output data about objects;
  - redefining the equals () method to check the equivalence of objects;
  - implementation of search methods on certain grounds;
  - implementation of the function of adding an object to check whether such an element is already present;
  - implementation of the method of testing the functionality of classes. 

 Search functions should return arrays of objects (or null if the search did not return results), instead of outputting those results directly.
  Derivative classes from created abstract classes must contain fields of specific types, in particular, the sequence of elements of the second entity must be represented in different derived classes in the form of an array and a list.
  Test both implementations. The test should include the performance of the task of previous laboratory work. Use the sort () methods of the Arrays and Collections classes, respectively. Use the lambda expression to determine the second sort feature.

  1.2 Hierarchy of classes <br>
  Implement classes "People", "Citizen", "Student", "Employee". Create an array of links to different objects in the hierarchy. For each object, display a string of data about it.

  1.3 Minimum function <br>
  Implement a program that allows you to find at least some function at a given interval. The algorithm for finding the minimum is to sequentially search with a certain step of the interval points and compare the values of the function at the current point with the previously found minimum.
  Implement five solutions:
  - use of abstract and derived classes;
  - description of the interface, creation of a class that uses the interface as a type of parameter of the minimum finding function, creation of separate classes that implement     the interface;
  - use of the previously described interface and anonymous classes;
  - use of lambda expressions;
  - use of links to methods.

Check the operation of the program on two different functions.

  1.4 Implementation of an array of points through a two-dimensional array and a one-dimensional array of real numbers <br>
  Implement the functionality of the abstract class AbstractArrayOfPoints, given in example 3.2, through the use of a two-dimensional array of real numbers, as well as a one-dimensional array of real numbers (each pair of numbers in the array must correspond to a point). Perform class testing.
  Note: You cannot make changes to the AbstractArrayOfPoints class other than possibly the package name

  1.5 Creating a library of generalized functions for working with arrays and lists <br>
  Implement a class with static generalized methods that implement the following functionality:
  - exchange of places of two groups of elements;
  - exchange of places of all pairs of adjacent elements (with even and odd index);
  - inserting into the array (list) another array (list) of elements in the specified place;
  - replacement of a group of elements with another array (list) of elements.
Implement the following functions for arrays and lists. Demonstrate the operation of all methods using data of different types (Integer, Double, String).

  1.6 Implementation of the Comparable interface (additional task) <br>
  Create a Circle class that implements the Comparable interface. A circle with a larger radius is considered larger. Sort the list of Circle objects.
  
  1.7 Implementation of the Comparator interface (additional task) <br>
  Create a Triangle class. Determine the triangle by the lengths of the sides. The area of the triangle in this case can be calculated by the Heron formula, where a, b and c are the lengths of the sides of the triangle. Sort the list of triangles by decreasing area. To determine the sort feature, use an object that implements the Comparator interface.
  
  # LAB#2
  
  2.1 Individual task <br>
  Design and implement classes to present the essence of previous laboratory work. The decision should be based on the previously created hierarchy of classes. You should create two derived classes from the class that represents the main entity. One class must be supplemented by the ability to read data from a properly prepared text file and write this data to another file after sorting. The second class must implement reading data from an XML document, storing data in structures that are automatically created using data binding technology, and writing data to another XML document after sorting. To avoid duplication of data in the program, you should also redefine the class that represents the second entity. Derivative classes, which represent the main entity, must implement a common interface in which the functions of reading from a file and writing to a file are declared.

  2.2 Sorting integers <br>
  Implement a program to read from a text file integers of positive values ​​(numbers are separated by spaces, should be read to the end of the file), enter these numbers into an array, sort by decreasing and increasing the sum of digits and save both results in two new text files. Implement these actions in a separate static function. To determine the sort order, create classes that implement the Comparator interface.

  2.3 Implementation of serialization and deserialization <br>
  Describe the classes Student and Academic Group (with a field - an array of students). Create objects, perform their binary serialization and deserialization, as well as serialization and deserialization in XML.

  2.4 List of files of all subdirectories <br>
  Enter the name of a specific folder from the keyboard. Display the names of all files in this folder, as well as all subdirectory files, their subdirectories, and so on. Implement output through a recursive function. If the folder does not exist, display an error message.
  
  2.5 Working with ZIP-archive (additional task) <br>
  Describe the classes Student and Academic Group (with a field - an array of students). Create objects, record data about students of the academic group in the archive. In another program, read from the archive.

  2.6 Use of SAX and DOM technologies (additional task) <br>
  Prepare an XML document with data about the students of the academic group. Use SAX technology to read data from an XML document and output data to the console. Using DOM technology to read data from the same XML-document, modify the data and write them to a new document.
  
  # LAB#3
  
  3.1 Individual task <br>
  It is necessary to implement in Java language with the help of JavaFX application of the graphical user interface in which data processing of individual tasks of previous laboratory works is carried out. The main window should contain a menu in which you need to implement the following functions:
  - creating a new data set
  - download data from an XML document for editing
  - storage of changed data in an XML-document
  - search on the features identified in the laboratory work № 5th year "Fundamentals of Programming" (specialty "Software Engineering") of the previous semester of sorting on the grounds identified in the laboratory work (1
  - get the window "About the program" with information about the program and the author.

  In the left part of the window you should place lines for entering scalar data, a display area for search results, as well as buttons that provide the main functions of the program. In the middle of the window should be a table for displaying and editing data.

  3.2 List to describe the months of the year <br>
  Create a "Moon" list. It is necessary to determine in the designer and save the number of days (for a low year). Add previous and next month retrieval methods, as well as a feature that returns the season for each month. Provide for the withdrawal of months in Ukrainian (Russian). Create a static output function for all months. Test the list in the main () function of the test class.

  3.3 User data <br>
  Present user data as an associative array (username / password) assuming that all usernames are different. Display data about users with a password length of more than 6 characters.

  3.4 Mini-calculator <br>
  Create a graphical user interface application in which one of four arithmetic operations is performed after entering numbers in two lines of type TextField (depending on the selected RadioButton button). The result is displayed in another text box.

  3.5 Dictionary (additional task) <br>
  Develop a graphical user interface program for viewing the words of a small English-Ukrainian (English-Russian) dictionary. Implement word search functions, add new words. Use Map to store data.

  3.6 Search for different words in a sentence (additional task) <br>
  Enter a sentence, create a collection (SortedSet) of different words in the sentence and display these words in alphabetical order.
 
# LAB#4

1.1 Individual task <br>
Create a graphical user interface program that is designed to graph arbitrary functions. The user must enter valid values ​​of a and b, functions f (x) and g (x) as strings that match the Java syntax. The program calculates the function h (x) according to the individual task:
 ![image](https://user-images.githubusercontent.com/72257722/110477745-35e88480-80ec-11eb-9dc2-b86d652f396b.png)


1.2 View all class fields <br>
Create a console application in which the user enters the class name and receives information about all the fields of this class (including closed and protected).

1.3 Creating a graphical user interface application to obtain prime factors of numbers <br>
Use JavaFX tools to develop a graphical user interface application in which the user enters a range of numbers (from and to), and the window displays numbers and their prime factors. Implement the ability to suspend, resume flow, as well as complete cessation and recalculation with new data.

1.4 Working with BlockingQueue <br>
Create a console program in which one thread adds integers to the BlockingQueue queue and the other calculates their arithmetic mean.

1.5 Calling a function for the selected class (additional task) <br>
Create classes with the same methods. Select a class by name and call its method.

1.6 Interpretation of mathematical expressions (additional task) <br>
Create a console application that allows you to enter mathematical expressions, calculate and display the result. The expression can consist of constants, mathematical operations and parentheses. To implement use the tools of the javax.script package.

1.7 Calculation of π in a separate execution flow (additional task) <br>
Implement the program to calculate π up to a given ε as the sum of the sequence: <br>
![image](https://user-images.githubusercontent.com/72257722/110477793-4567cd80-80ec-11eb-9581-17ae227ff8f0.png) <br>
Calculations should be performed in a separate execution flow. When performing the calculation, allow the user to enter a query about the number of calculated elements of the amount.
