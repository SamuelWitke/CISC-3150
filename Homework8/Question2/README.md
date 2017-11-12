Also, figure out why the program stopped running when we used 
Thread.sleep(), and we right clicked/marked the DOS window. 


## Answer 
I couldn't replicate error in Linux environment which makes me believe that this problem is only related to windows, reading up on problem found the error not unique to java but all programs, such that " cmd suspends executed task if you mark sth in command line" here's link to read up,
https://stackoverflow.com/questions/24571981/python-program-stops-in-command-line

### Additionally 
I wanted to see if a thread can be executed before 
```java 
public static void main(String args[]) 
```
what I found is that it can be done with semaphores and blockers but the reason 
```java 
public static void main(String args[]) 
``` 
is called before any threads is due to the thread start up process taking time. 
If you run my example program you will find, that even through the 
```java 
static { ... }
and 
A(long start) { ... }
``` 
is called before main the start process for
```java 
public static void main(String args[]) 
``` 
happens before the thread method 
```java 
void run { ... 
``` 
can be called. 
<pre>
In A Constructor time= 0.234919 ms
In Static Block time= 7.572286847911E7ms to start
In main thread 33.385052 ms
In run thread 33.427396 ms
In main end 33.781501 ms
</pre>
