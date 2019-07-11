# 🗿 Design Patterns
Design patterns repository

## Creational Desing Patterns

### Singleton Pattern

A **singleton** is a class that is instantiated only once. 
Typically this is acomplished by creating static filed that represents that class.
Static method exist in the class to obtain instance of class. Typically we call this method getInstance() 
Singleton typically has private constructor to prevent this class being instantiated via constructor. 

#### Singleton Simple 

This is very simple implementation of singleton. As can be seen in [SingletonSimpleTest](../blob/master/src/test/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonSimpleTest.java) 
it not safe against reflection. 
When we use reflection constructor.setAccesible(true);  it is possible to create two instances of this class. 
