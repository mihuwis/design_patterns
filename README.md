# 🗿 Design Patterns

#### TOC
- [Creational Design Patterns]
- [Singleton](https://github.com/mihuwis/design_patterns#singleton-simple)
- [Factory](https://github.com/mihuwis/design_patterns#factory)
- [Structural Design Patterns]
- [Behavioral Design Patterns]


### 📮 About
Design patterns repository. 
- Repo with some basic implementation of common design patterns. 
Three main categories of design patterns are included here:
- creational 
- structural 
- behavioral 


### 🕹 Project Motivation
Design patterns are one of most common job interview topics. This repo was created to practice and gather info about them in one place.
- If you found any bug or you thing something important (pattern or implementation) is missing, please feel free to send me pull request.  

## ✔️ [Creational Design Patterns](src/main/java/com/progresspoint/patterns/creational_patterns)

### Singleton Pattern

A **singleton** is a class that is instantiated only once. 
Typically this is accomplished by creating static filed that represents that class.
Static method exist in the class to obtain instance of class. Typically we call this method **getInstance()**. 
Singleton typically has private constructor, to prevent this class being instantiated via constructor. 

#### [Singleton Simple](src/main/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonSimple.java) 

This is very simple implementation of singleton. 
- -> private static field of this class. 
- -> private constructor 
- -> public static method to getInstance() 
* All that you need to have singleton. 
❓ But wait! A singleton with parameters is not really a good idea. (!!) ❓
This implementation with parameters was just for exercise purposes.  
- 🕵️‍ **Reflection** 🕵️‍
As can be seen in [SingletonSimpleTest](src/test/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonSimpleTest.java) 
it is not safe against reflection. 
When we use reflection constructor.setAccesible(true); 🐜 Than it is possible to create two instances of this class. 

#### [Singleton Reflection Safe](src/main/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonReflectionSafe.java)

To protect singleton from reflection we can include check in constructor. 
This will prevent instantiation of class when there is already another instance.
Test in [SingletonReflectionSafe](src/test/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonReflectionSafeTest.java)
shows then constructor will throw exception in this case. 
Reflection will wrap all the exception in InvocationTargetException, so this is exception I test in tests. 
🐜 Im not sure about testing against this exception thou. Is this good practise. If someone got any better idea please help me here.

#### [Singleton Thread Safe](src/main/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonThreadSafe.java)

To make singleton thread safe we can use different strategies and methods. 
- One is called **double-checked locking optimization**. 
- In getInstance() we use two checks. 
In case we have some threads passing by first condition they will be que up and only one instance will be created. 
Please check [Test](src/test/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonReflectionSafeTest.java)
When we run this test we can see that all 100 tests pass. 
Try to get rid of inner condition in singleton class. 
Only about 95% tests will pass in this case, as some threads managed 
to get through condition check and then more instances were created.

Key word volatile is used to read variable from main memory not from cache. 

🐜 I had change access to public for instance field just for this test purpose. 
Field SingletonThreadSafe instance should be of course private. 

As synchronization can affects performance we can use: 

#### [Static Holder Singleton](src/main/java/com/progresspoint/patterns/creational_patterns/singleton/SingletonStaticHolder.java) 
This is really cool. When class Singleton is loaded by JVM class will go through initialization. 
As there no static variables in class initialization will completes trivially. 
Inner class Holder will be not initialized until execution of get instance method. 
Since the class initialization phase is guaranteed by Java Language Specification to be sequential, no further synchronization is needed! 


### Factory Pattern

A factory pattern is a creational design pattern. It can be used for encapsulate creation code. 
In this way we can hide instantiation logic when creating objects. 

#### [Factory](https://github.com/mihuwis/design_patterns/blob/master/src/main/java/com/progresspoint/patterns/creational_patterns/factory/CurrencyFactory.java)
Method getInstance() or in our case getCurrency() will return constructor of required class. 
We can control which class will be instantiated by method argument. 

#### [Factory with map and Functional interface](src/main/java/com/progresspoint/patterns/creational_patterns/factory/CurrencyFunctionalFactory.java)

Different approach, where functional possibilities of Java 8 were used. 
In map string representation of class is stored as key, as value we have Supplier interface of given class.

#### [Factory kit]()

This is approach I found on one of MIT repositories. It sports factory of immutable content with separated builder class
and factory interfaces. It also use enum type.
- Factory kit (which contains Interfaces -> Currency, CurrencyBuilder, CurrencyFactoryKit) can be used when 
a class can't anticipate the class of object it must create. 
Also we can explicitly define types of objects that factory can build. 


## ✔️ [Structural Design Patterns](src/main/java/com/progresspoint/patterns/structural_patterns)

### Proxy Pattern
Proxy is yet another pattern to control use of resources. It can be definied as a surrogate. 
**Proxy protects and control access to the object**
__

![proxy pattern](https://github.com/mihuwis/design_patterns/blob/master/src/main/resources/img/proxy_pattern.png?raw=true)

So the CLIENT knows about SUBJECTS and can request from him. But PROXY and REAL SUBJECT implements subject interface 
and CLIENT can be forced to go through PROXY before reaching REAL SUBJECT. 
This can be due to security reasons or performance (when real subject is very big and complicated class and we don't want 
to instantiate it without good reason)

![proxy sequence](https://github.com/mihuwis/design_patterns/blob/master/src/main/resources/img/proxy_seq.png?raw=true)

As it can be seen above, PROXY provides barrier between real subject and client.

#### [Real Subject](src/main/java/com/progresspoint/patterns/structural_patterns/proxy/RealSubject.java)
As we can see creation of real subject is time consuming. Proxy will help us control in process of instantiation of this class.

[Please check this Main class](src/main/java/com/progresspoint/patterns/Main.java)

Results should be ass follow: 
1. Creating proxy at Mon Jul 15 12:20:01 CEST 2019 __
2. SomeOtherThing here! Im working Is Mon Jul 15 12:20:01 CEST 2019 
3. RealSubject says hello at Mon Jul 15 12:20:06 CEST 2019 ___

Please notice that creating proxy and calling some other methods occurred at 12:20:01 but real subject was created 5 sec later. 
However this not affected execution of our application until Real Subject was actually needed. 
We can see here that Proxy pattern avoid creating slow and time consuming instances until they are needed. 

#### When use proxy? 
- The object being represented is external to the system and communication is expensive
- Object needs to be created on demand
- Access control for original object is required 
- Added functionality is required when object is accessed 
## _______________________
### Legend: 
+ 🐜 - this little bug (well ant, to be honest) means there are some problems or issues - so pay attention tho the code. 
+ ❓ - this red question mark means that I had used some strange implementation. 
As I personally learn from my mistakes I decided to leave this with comments. 
Please pay close attention to the code to not replicate bad practices. 
## _______________________
### Bibliography: 
1. [Initialization-on-demand holder idiom](https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom)
2. [Storm IT, Singleton. (in polish)](https://stormit.pl/singleton/)
3. [Design patterns - avajava](http://www.avajava.com/tutorials/categories/design-patterns)
4. [Factory pattern](https://dzone.com/articles/factory-pattern-using-lambda-expression-in-java-8)
5. [Proxy pattern](https://dzone.com/articles/design-patterns-proxy)
6. [Design patterns repo](https://github.com/iluwatar/java-design-patterns)
7. [Refactoring guru](https://refactoring.guru/)

