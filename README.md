# java_concurrency : Problems
1. Creating and joining threads

1.a. Write a short program that prints "Hello world" from a thread.

1.b. Now modify the program to print "Hello world" five times, once from each
     of five different threads.

1.c. Now modify the printed string to include the thread number; ensure that
     all threads have a unique thread number.


2. Simple synchronisation

2.a. Write a short program in which two threads both increment a shared
     integer repeatedly, without proper synchronisation, 1,000,000 times,
     printing the result at the end of the program.

2.b. Now modify the program to use synchronized to ensure that increments
     on the shared variable are atomic.
