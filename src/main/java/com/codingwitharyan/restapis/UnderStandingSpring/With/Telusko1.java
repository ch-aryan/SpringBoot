package com.codingwitharyan.restapis.UnderStandingSpring.With;

import com.codingwitharyan.restapis.UnderStandingSpring.WithoutSpring.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.Target;

@Component
public class Telusko1 {

    Courses courses;
    public Telusko1(){
        System.out.println("TElusko zero para constructor.");
    }
    @Autowired

    public Telusko1(@Qualifier("dsa1")  Courses courses){
        this.courses = courses;
    }
    public boolean courseEnroll(int amount){
        if(amount >= 1000){
            courses.getCourse();
            System.out.println("course  done successly");
            return true;

        }else{
            System.out.println("sorry invalid course or amount ");
            return false;
        }
    }
}
/*
Aryan, this is actually a very good exercise. Most beginners jump directly into Spring Boot annotations without first understanding **what pain Spring is solving**. You did the right thing by writing the "Without Spring" version first and then trying the "With Spring" version.

Let me explain your code like an architect would.

# Step 1: Without Spring

You created:

```java
Courses
```

interface.

Then:

```java
Java implements Courses
DSA implements Courses
```

Then:

```java
Telusko
```

depends on:

```java
Courses
```

through constructor injection.

Example:

```java
Telusko obj = new Telusko(new Java());
```

This is actually already following a good design principle:

### Dependency Inversion Principle (DIP)

Instead of:

```java
Java java = new Java();
```

inside Telusko,

you wrote:

```java
Courses courses;
```

which means:

> "I don't care whether it is Java course or DSA course. Give me any Course."

This is good OOP.

---

# Pain Point #1 Spring Solves

Imagine your project has:

```java
100 Services
50 Repositories
20 Controllers
```

Without Spring:

```java
UserRepository repo = new UserRepository();

UserService service =
       new UserService(repo);

UserController controller =
       new UserController(service);
```

You create everything manually.

For a big project:

```java
new A(
    new B(
        new C(
            new D(
                new E()
            )
        )
    )
);
```

becomes a nightmare.

---

Spring says:

> "Don't create objects. I'll create them."

This concept is called:

# IOC (Inversion of Control)

Normally:

```java
new Java()
```

You control object creation.

With Spring:

```java
@Component
class Java1
```

Spring creates it.

You no longer control object creation.

Spring controls it.

Hence:

**Inversion Of Control.**

---

# Pain Point #2 Dependency Wiring

Without Spring:

```java
Telusko obj = new Telusko(new Java());
```

You manually inject dependency.

With Spring:

```java
@Autowired
Courses courses;
```

inside Telusko1.

Now Spring looks into its container:

> "Who implements Courses?"

and injects the implementation automatically.

This is called:

# Dependency Injection (DI)

Think:

### IOC

Who creates object?

Spring.

### DI

Who supplies dependencies?

Spring.

---

# Problem In Your Spring Version

I noticed this:

```java
SpringApplication.run(
    RestapisApplication.class,
    args
);

Telusko1 obj = new Telusko1();
```



This defeats the purpose of Spring.

Why?

Because:

```java
new Telusko1()
```

is NOT managed by Spring.

Spring doesn't know about this object.

Therefore:

```java
@Autowired
Courses courses;
```

won't work properly.

---

Instead do:

```java
ApplicationContext context =
       SpringApplication.run(
          RestapisApplication.class,
          args
       );

Telusko1 obj =
       context.getBean(Telusko1.class);

obj.courseEnroll(1000);
```

Now Spring creates Telusko1.

Now dependency injection works.

---

# Another Problem

You wrote:

```java
@Component
public class DSA1 implements Courses
```



But:

```java
Java1
```

has:

```java
@Primary
```

only.

It does NOT have:

```java
@Component
```

So Spring won't create a bean for Java1.

It should be:

```java
@Component
@Primary
public class Java1 implements Courses
```

Otherwise Spring cannot discover it.

---

# Another Small Mistake

You created:

```java
Courses1
```

interface.

But later:

```java
DSA1 implements Courses
```

and

```java
Java1 implements Courses
```

use the old interface.

So:

```java
Courses1
```

is currently unused.

You can remove it.

---

# What @Component Really Means

When Spring starts:

```java
@SpringBootApplication
```



Spring scans packages.

Whenever it finds:

```java
@Component
```

it says:

> "I will create one object of this class and keep it inside my container."

Example:

```java
@Component
public class Telusko1
```

means:

```java
Telusko1 obj = new Telusko1();
```

is secretly done by Spring.

---

# What is the Spring Container?

Think of it as a huge HashMap.

Conceptually:

```java
Map<String,Object> beans;
```

Spring stores:

```java
"telusko1" -> Telusko1 object

"dsa1" -> DSA1 object

"java1" -> Java1 object
```

When you write:

```java
@Autowired
Courses courses;
```

Spring searches the container.

Finds matching bean.

Injects it.

---

# Why @Primary Exists

Suppose:

```java
Java1 implements Courses
DSA1 implements Courses
```

Both exist.

Now Spring gets confused:

```java
@Autowired
Courses courses;
```

Which one?

Java1 ?

DSA1 ?

So:

```java
@Primary
```

means:

> "Use this bean by default."

---

# The Biggest Lesson From Your Example

Without Spring:

```java
Telusko obj =
      new Telusko(new Java());
```

You manage:

* Object creation
* Dependency creation
* Dependency wiring

all manually.

With Spring:

```java
@Component
@Autowired
```

Spring manages:

* Object creation
* Dependency creation
* Dependency wiring

for you.

That is the core reason Spring exists.

Everything else in Spring Boot (MVC, Security, JPA, REST APIs, etc.) is built on top of this fundamental idea:

> "Let the framework manage objects and their dependencies so developers can focus on business logic."

And honestly, after understanding IOC, Dependency Injection, `@Component`, `@Autowired`, `@Primary`, and the Spring Container at this level, you've already understood the most important 20% of Spring that explains 80% of what happens later in Spring Boot.

 */