# CSD
This is a digital software for the computer science department in a university.

By doing this project I learned alot about OOP concepts which include **abstraction**, **encapsualtion**, **inheritance**, **polymorphism**, association, aggregation and composition. The bolded concepts are the 4 main principles of OOP and they are reliant on the other 3 concepts. NOT ALL CONCEPTS AND PRINCIPLES WERE USED IN ORDER TO COMPLETE THE PROJECT BUT ARE A NECESSARY PART OF UNDERSTANDNING OOP. 

Inheritance - child classes inherit features from parent classes.

Polymorphism - compile time(static) involves method overloading, and runtime(dynamic) involves method overridding; we override the methods with the same signature aka child class methods so that their methods differ in functionality from the parent and we overload methods with the same name but different parameters so that objects of a class can perform a single version of each method but not all. 

Abstraction - is the process of hiding certain details and revealing only specific information to the user thus reducing complexity and seperating the internal from the external of the object; for example I only need the beans and know what buttons to press to make coffee not all the internal processes of the coffee machine. An abstract class is a class without a constructor (since we don't want to make instances of the class) and it can only be inheritaed from a subclass. An abstract method is a method without a body which must be defined by the subclass (they can only be found in abstract classes).

Encapsulation - is the process of bundling of data, along with the methods that operate on that data, into a single unit. It allows the restriction of direct access to components within an object thus hiding the internals. Encapsualtion can be used by adding things like using the private or protectetd access modifiers, using getters and setters, making immutable classes and creating new individual objects within a list if its one of the parameters of the object. These techniques allow information to be hidden so that people using the programs don't access it. 

Association - any logical relationship between classes such as passengers and an airline.

Aggregation - the formation of a particular class as a result of a class being aggregated/built for example books are formed as a result of a library being built; the contained classes(books) are not strongly dependent on the container(library) because the books still exist regardless if the library does. 

Composition - the same idea as aggregation in terms of the creation of contained classes as a result of the container being build; in this case the contained classes will be destroyed if the container is destroyed, for example if a house is destroyed then all the basic compoennts such as the windows are destroyed too. 

