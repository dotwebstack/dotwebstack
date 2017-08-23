# Logging guidelines

## SLF4J

All projects use the Simple Logging Facade for Java (SLF4J) as a facade or abstraction for the various logging frameworks.

If you would like to add logging to a Java class, add the following logger to your class:

```java
private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(MyClass.class);
```

For example:

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class HelloWorld {

  private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

  void sayHello() {
    LOG.info("Hello world!");
  }

}
```

Please note that:

* The `Logger` is static: it will be shared among instances of the parent class. Only one instance of the `Logger` is created per class
* The `Logger` is final: you cannot assign another `Logger` to the `LOG` variable
* The name of the Logger is `LOG` (not `log`, `LOGGER` or `logger`). The name is uppercase, so that it is clear `LOG` is a constant
* The `Logger` is retrieved by supplying the class. This way if the name if the parent class changes, the name of the logger automatically changes too.

## Log levels

SLF4J supports the following log levels:

| Level | Description
|:--|:--|:--
| fatal | Not used.
| error | An error has occurred which must be looked into by the dev team. The application cannot recover from the error.
| warn  | Something went wrong, but the application can recover from the situation. Even so, the dev team will look into the warnings on a regular basis.
| info  | |
| debug | Use for debugging purposes only.
| trace | Not used.

Debug statements should only be logged in development or test environments. Error, warn and info statements are logged everywhere (including production environment).

If an error or warning was caused by an exception, always log the exception with:

```
Logger#error(String message, Throwable t);
Logger#warn(String message, Throwable t);
```

If you do not like to provide your own message, use the Exception message:

```java
void sayHello() {
  try {
    // Try something dangerous
  } catch (MyException e) {
    LOG.error(e.getMessage(), e);
  }
}
```

Catch and log exceptions causing an error at the root level of your application only, because your code will not be able to recover from the error (that is why it is called an error :-) ).

Please think carefully which LOG level you use. For example, you do not want to flood the logging with info statements generated in a loop with more than 10 iterations. If people do not read your logging anymore, you are probably logging too much.

## Log pattern

By default, Logback outputs the following log pattern:

```
\[date-time] \[log-level] \[process-id] --- \[thread-name] \[logger-name] : \[log-message]
```

For example:

```
2017-02-27 08:57:33.962  INFO 6 --- [nio-8282-exec-6] n.p.d.etl.launcher.JobLauncherService  : Job created
2017-02-27 08:57:37.148  INFO 6 --- [cTaskExecutor-1] n.p.d.e.t.d.DocTransformationProcessor : Ingesting 3 documents into index
2017-02-27 08:57:37.495  INFO 6 --- [cTaskExecutor-1] n.p.data.etl.api.client.CallbackClient : Invoking callback on 'http://172.17.0.1:8283/v1'
```

## Log statements

* Start each statement with a capital letter (unless you log a method name);
* Log statements should not be delimited with any punctuation character;
* If logging a statement at the start of a method, then use the method name in the statement. For example:
```java
void sayHello(String message) {
  LOG.info("sayHello() message = '{}'", message);
}
```

If you cannot use the method name, it is probably a bad name;
* As in the preceding example, if logging parameters, then place them between single quotes (`'`);
* As in the example above, precede the parameter value by the parameter name separated by the equals sign `=`;
* If logging an object parameter, be aware of the length of the toString() of the object (!). You do not want to flood the logging with major print outs of your objects;
* If you log some sort of process or transaction, then also log some key which uniquely identifies the process.
* If you log the start of a process, do not forget the log the end of the process:

```java
LOG.info("Job 123 started");

// [ ... ]

LOG.info("Job 123 ended");
```

This way people reading your logs know all statements between "Job X started" and "Job X ended" belong to the job process;
* Last but bot least, use common sense. Log statements which add value only (especially on the info level!).

## Placeholders

The use of string concatenation (or `String.format(...)`) in log statements should be avoided. If the log level is not high enough, the string concatenation or formatting will be needlessly performed.

```java
void sayHello(String message) {
  LOG.debug("sayHello() message = '" + message + "'");
}
```

In the previous example, if the log level is INFO, the string concatenation will be performed even though the message will not be written to the log. This is not what we want, so placeholders should be used whenever possible:

```java
void foo(float bar) {
  LOG.debug("foo() bar = '{}'", message);
}
```

The underlying framework will only perform the placeholder-replacement if the message will actually be written to the log.

### is\[loglevel\]Enabled()

If you cannot use the placeholders (i.e. because of a
complex formatting function) make sure that you call the `LOG.is[Loglevel]Enabled()` method before formatting the message to check if the message will be written to the log:

```java
void logDouble(double value) {
  if (LOG.isDebugEnabled()) {
    LOG.debug(String.format("logDouble() value = %1$.3f", value));
  }
}
```

Try to avoid this whenever possible though.

## Configuration

Never hard code your logging configuration, always use a configuration (file) external to your application to configure the logging framework. This way you can change the configuration without having to change (and deploy) your application.

## Links

* [SLF4J](https://www.slf4j.org/)
