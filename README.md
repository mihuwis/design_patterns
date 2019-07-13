# 🗿 Design Patterns
Design patterns repository

## Creational Desing Patterns

### Singleton Pattern

A **singleton** is a class that is instantiated only once. 
Typically this is accomplished by creating static filed that represents that class.
Static method exist in the class to obtain instance of class. Typically we call this method getInstance() 
Singleton typically has private constructor to prevent this class being instantiated via constructor. 

#### [Singleton Simple](src/main/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonSimple.java) 

This is very simple implementation of singleton. And a singleton with parameters is not a singleton(!!) 
This implementation with parameters was just for exercise purposes.  
**Reflection**
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

Key word volatile is used to read variable from main memory not from cache. 

As synchronization can affects performance we can use: 

#### [Static Holder Singleton](src/main/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonStaticHolder.java) 
This is realy cool. When class Singleton is loaded by JVM class will go through initialization. 
As there no static variables in class initializatin will completes trivially. 
Inner class Holder will be not initialized until execution of get instance method. 
Since the class initialization phase is guaranted by Java Language Specification to be sequential, no further synchronization is needed! 








Bibliography: 
[Initialization-on-demand holder idiom](https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom)
[Storm IT, Singleton. (in polish)](https://stormit.pl/singleton/)

