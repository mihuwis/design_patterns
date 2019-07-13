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

#### [Singleton Thread Safe](src/main/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonThreadSafe.java)

To make singleton thread safe we can use different strategies and methods. On is called double-checked locking optimization. 
In getInstance() we use two checks. 
In case we have some threads passing by first condition they will be que up and only one instance will be created. 
Please check [Test](src/test/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonReflectionSafeTest.java)
When we run this test we can see that all 100 tests pass. 
Try to get rid of inner condition in singleton class. 
Only about 95% tests will pass in this case, as some threads managed 
to get through condition check and then more instances were created.

Key word volatil is used to read variable from main memory not from cashe. 


