## Question 4:  
Figure out why the following two pieces of code produce different outputs.   
MAKE SURE YOU CITE YOUR SOURCE FOR THE ANSWER TO THIS QUESTION.  

```java  
int x = 4282;  
for(int i=0;i<35;i++){  
	System.out.printf("%d\t\t%32s\n",i,Integer.toBinaryString(x>>>i);  
}  

int x = 4282;  
for(int i=0;i<35;i++){  
	System.out.printf("%d\t\t%32s\n",i,Integer.toBinaryString(x));  
	x = x >>> i;  
}  
```  
## Answer   
### Source of answer https://stackoverflow.com/questions/14817639/java-bit-operations-shift , http://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.19  
What is happening is since int is 32 bits you can only shift by a maximum of 31.   
Taken from  Section 15.19 of JLS: "The shift distance actually used is therefore always in the range 0 to 31, inclusive."  

x>>32 =                    1000010111010  
x>>0  =                    1000010111010  
x     =                    1000010111010  
