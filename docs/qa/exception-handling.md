# Exception handling guidelines

## Rules

* Use exceptions for exceptional conditions only, they should never be used for ordinary control flow;
* A well-designed API must not force its clients to use exceptions for ordinary control flow;
* Use checked exceptions for recoverable conditions;
* Use runtime exceptions for programming errors;
* Avoid unnecessary use of checked exceptions;
* Favor the use of standard exceptions;
* Throw exceptions appropriate to the abstraction: higher layers should catch lower-level exceptions and, in their place, throw exceptions that can be explained in terms of the higher-level abstraction;
* Never ignore exceptions.

## References

* Effective Java (2nd Edition) by Joshua Bloch
