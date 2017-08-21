# IntelliJ IDE

This document describes how the IntelliJ IDE can be setup.

## Checkstyle

* Import the [Checkstyle template](intellij-java-google-style.xml) for Java;
* Add JSON, XML and YAML to that profile.

  Open IDEA and go to __file > settings__ (Ctrl + Alt + S) and then __Editor | Code Style | \<language\>__

  ```yaml
  JSON:
    Tab: 2
    Indent: 2
    Continuation: 4
    Spaces after: ',' , ':'
    Max blank lines: 0
    Right margin: 100
    Wrap on typing: your discretion
    Keep line breaks: true
    Arrays: always wrap
    Objects: always wrap
      align: Do not align

  XML:
    Tab: 2
    Indent: 2
    Continuation: 4
    Right margin: 100
    Keep:
      line breaks: true
      line breaks in text: true
      blank lines: 2
    Wrap attributes if long: true
    Wrap text: true
    Allign attributes: true
    Keep white spaces: true
    Spaces:
      around '=' in attribute: false
      after tag name: false
      in empty tag: false

  YAML:
    Indent: 2
    Right margin: 100
  ```
