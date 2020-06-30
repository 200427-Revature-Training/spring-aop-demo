# AOP

AOP stands for Aspect Oriented Programming. Aspect Oriented Programming is designed to
address problems known as "cross cutting concerns".

## What is a concern?

A responsibility for our application to manage. Normally we try structure responsibility
via the single responsibility principle which tells us that any function or class should
limit the scope of its activity to one core thing.

## Cross Cutting Concerns

A cross cutting concern is any concern which needs to be addressed in many locations or
across multiple layers of the application. Some example of cross cutting concerns could be
logging, session management, and authorization. Logging could be described as a cross 
cutting concern, as logging information about application state is a process that will
happen in many different locations of the application - so how would it be possible to 
centralize this behavior? Sessions need to setup and accessible for a broad number of 
operations triggered by HTTP requests - because this needs to happen at many layers, it 
can result in repetitive code that is easy to forget. Authorization falls into the same
category. Many HTTP handlers may require specific authorization to limit access to users
with specific roles.  As this needs to happen at many handlers, this is a cross cutting 
concern.

## AOP as a Solution

Aspect oriented programming is a method of programming that can weave code into the
existing structure or architecture of an application.  Instead of code executing 
procedurally, we can inject extra code which is configured to target special locations
in the application that meet some predicate definition. With AOP we target method execution
to inject code without having to modify or indicate in the target method any information
related to the injection of code.  This means the responsibility of the function is
diluted by the injected behavior and at a maintenance level it can be easy to change
application wide behavior while only affecting a single class (Aspect).

## What is an Aspect?

An Aspect is the modularization of a cross-cutting concern. Effectively this means an 
aspect is AOP managed class that centralizes the logic that is meant to be applied 
throughout the application. Instead of repeating code in many locations, with an Aspect
we can place the logic in a single location which targets many locations for injection.

### Other AOP Terminology
https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/aop.html

Join point - A location in application execution where Aspect logic (Advice) can be 
applied. In Spring AOP this is always a method execution.

Advice - The action taken by an aspect at some join point.

Point cut - A predicate expression which will be compared to join points for code injection.

Target object - Any object being advised.


### Types of Advice

@Before - Execute advise before target function is invoked
@After - Execute advise after target function returns or ends exceptionally
@AfterReturning - Execute advise after target function successfully returns
@AfterThrowing - Execute advise after target function ends exceptionally
@Around - Wraps target function execution in advise, advise can choose to call or not
			call target function.
			
Note: When using @Before and @After ensure that you import the correct annotations! 
Annotations with the same name are also used by JUnit. Importing the JUnit annotations 
instead of the AOP annotations will prevent AOP from working!


## AOP Configuration Steps

1. Enable AOP by adding the @EnableAspectJAutoProxy annotation in a configuration class,
	for example the class that uses @SpringBootApplication.
	
2. Create Aspect class or classes.

3. Annotate Aspect with @Aspect and @Component.

4. Create advise (function or functions to be injected)

5. Annotate advise with a advise type and pointcut.