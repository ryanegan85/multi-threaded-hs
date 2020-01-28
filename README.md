Ryan Egan
Design Patterns Assignment 4

HOW TO COMPILE
While in the multiThreadedHS/src directory, run "ant all" to compile the program.

HOW TO CLEAN
While in the multiThreadedHS/src directory, run "ant clean" to remove the BUILD
directory, which includes .class files and the jar file.

HOW TO RUN
Before running, ensure that the input files are in the first "multiThreadedHS" directory, the same directory
that src and this README are located.
While in the multiThreadedHS/src directory, run "ant run -Dargs=<N> <N input files> <output file> <debugValue>"
to run the program. N must be between 1 and 3, and the number of input files must match this. DebugValue should be
either 0 or 1. For example, 

ant run -Dargs="3 input1.txt input2.txt input3.txt output.txt 1"

will read from the 3 input files and output to output.txt.
A debug value of 0 will not run the logger, while a value of 1 will.

CHOICES OF DATA STRUCTURE
For storing the numbers in both the ThreadWorkers and Results classes, I used an ArrayList of integers. This
allowed me to ensure that the program would not have to constantly expand the size of the object to deal
with a large number of inputs. However, when sorting the numbers with merge sort, this ArrayList is changed
to an array of ints to make the sorting faster, then turn it back to an ArrayList after the sorting is complete.
This is the only large data structure used in the program, other than Strings and ints to store miscellaneous values.

REFERENCE FOR MERGE SORT
https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm
