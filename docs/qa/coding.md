# Coding guidelines

## General

1. Use [Google's coding standards](https://google.github.io/styleguide/javaguide.html).

1. Check every required method parameter with Lombok's `@NonNull` annotation (fail fast - fail hard);

1. Use String#format where possible. For example, replace:

    ```
    throw new Exception("An exception occurred. First input parameter = '" + param0
        + "', second input parameter = '" + param1 + "', third input parameter = '" + param2
        + "'. Result = '" + result + "'");
    ```

    ...by:

    ```
    throw new Exception(String.format(
        "An exception occurred. First input parameter = '%s', second input parameter = '%d', third input parameter = '%t'. Result = '%s'",
        param0, param1, param2, result));
    ```

    By using String#format your code will be more readable. Second, the formatting of Objects is done for you by String#format. For the formatter options, see:

    https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
