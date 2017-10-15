Question 1

Write a command line calculator. Implement the (), +, -, /, *, and % 
functions. Make sure your calculator works with both integers and 
doubles. Here's an example run:

javac Calculator 2 + 3
5

Separate all the arguments with a space to make your life easy.

If the user enters anything other than a number where a number belongs, 
throw a LookAtMrAlgebraOverHereException derived from the 
IlleglArgumentException. If the user enters an operation which isn't 
supported, throw a IllegalOperationException derived from the 
IllegalArgumentException. If the user forgets to enter a number, throw 
a UserIsADumbassException also derived from IllegalArgumentException. 
Make sure you deal with these exceptions gracefully. Don't pass them on 
to the JVM.

You should also catch and deal with ArithmeticException in case the 
user tries to divide by zero.

Make sure your calculator correctly deals with the order of operations. 
(Remember PEMDAS?). I think if you research how to turn the command 
line arguments into postfix notation, it'll help. But I'm not 100% 
sure.
