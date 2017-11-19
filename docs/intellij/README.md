# IntelliJ IDE

This document describes how the IntelliJ IDE can be setup.

## Code Style

1. Navigate to Preferences > Editor -> Code Style.

1. Import the [Google style template](intellij-java-google-style.xml) for IntelliJ.

1. Overwrite JSON, XML and YAML configurations in the profile.

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
    Allign attributes: false
    Keep white spaces: false
    Spaces:
      around '=' in attribute: false
      after tag name: false
      in empty tag: false

  YAML:
    Indent: 2
    Right margin: 100
  ```

## Eclipse Code Formatter

1. Install Eclipse Code Formatter plugin from Preferences > Plugins.

1. Navigate to Preferences > Other Settings > Eclipse Code Formatter.

1. Select "Use the Eclipse code formatter".

1. Select "New profile" and rename the new profile to "GoogleStyle".

1. Under "Eclipse Java Formatter config file", import `eclipse-java-google-style.xml`.

1. Select "Optimize imports" and import `eclipse-java-google-style.importorder`.

1. Formatting can now be easily done with `Ctrl-Alt-L`.

## Checkstyle

1. Install Checkstyle plugin from Preferences > Plugins.

1. Navigate to Preferences > Other Settings > Checkstyle.

1. Import and activate the `checkstyle.xml` from the project root folder. Select the corresponding Checkstyle version.

## SonarLint

1. Install Sonarlint plugin from Preferences > Plugins.

1. Navigate to Preferences > Other Settings > SonarLint General Settings.

1. Add the SonarQube server (SonarCloud). Select the `dotwebstack` organization.

1. Navigate to Preferences > Other Settings > SonarLint Project Settings.

1. Bind the previously created SonarQube server and select the right project.
