# 🗿 Design Patterns
Design patterns repository

## Creational Desing Patterns

### Singleton Pattern

A **singleton** is a class that is instantiated only once. 
Typically this is acomplished by creating static filed that represents that class.
Static method exist in the class to obtain instance of class. Typically we call this method getInstance() 
Singleton typically has private constructor to prevent this class being instantiated via constructor. 

#### [Singleton Simple](src/main/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonSimple.java) 

This is very simple implementation of singleton. 
As can be seen in [SingletonSimpleTest](src/test/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonSimpleTest.java) 
it not safe against reflection. 
When we use reflection constructor.setAccesible(true);  it is possible to create two instances of this class. 

#### [Singleton Reflection Safe](src/main/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonReflectionSafe.java)

To protect singleton from reflection we can include check in constructor. 
This will prevent instantiation of class when there is already another instance.
Test in [SingletonReflectionSafe](src/test/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonReflectionSafeTest.java)
shows then constructor will throw exception in this case. 
Reflection will wrap all the exception in InvocationTargetException, so this is exception I test in tests. 

