# Question 2 
If I remember correctly, ObjectOutputStream is supposed to ignore 
transient and static variables. We verified that the transient values 
weren't written out to the file in our demonstration, but I couldn't 
get the static variable to behave properly. Figure out what the correct 
behavior is supposed to be for static variables, and then write a 
demonstration program that shows that behavior.

### The answer to this to the correct behavior for all Serialization classes is
### Instance Variables: 
These variables are serialized, so during deserialization we will get back the serialized state.
### Static Variables: 
These variables are not serialized, 
So during deserialization static variable value will loaded from the class.Therefore the current value will be loaded.
### Transient Variables:
Transient variables are not serialized, so during deserialization those variables will be initialized with corresponding default values.
### Super class variables:
If super class also implemented Serializable interface then those variables will be serialized, otherwise it won't serialize the super class variables. While deserializing, JVM will run the default constructor in super class and populate the default values. 
Same thing will happen for all superclasses. 
