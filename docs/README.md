# Quality assurance

## Definition of Ready

Definition of Ready (DoR) is a list of criteria that a user story must meet prior to being accepted into the upcoming iteration.

* The user story is well defined.
* Testers have defined its user story acceptance criteria.
* All dependencies are known.
* Proper sizing or re-sizing has been done if required.
* The development team has approved the user story.
* Finally, the delivery team has a good idea of how the demo of the user story would be.

## Definition of Done

Definition of Done (DoD) is a list of criteria which must be met before a product increment, often a user story, is considered "done".

### 1. Good code

* Code does not contain any (Eclipse) warnings or errors.
* Code has unittest coverage on all non-trivial testable code.
* Code review has been performed:
  * Code has been pushed to a feature branch, not directly to the main branch;
  * At least one member has been requested to review a pull request;
  * Code has been documented where necessary;
  * Code does not contain any TODOs (instead they should be turned into new Jira issues);
  * Code follows the [coding-](./qa/coding.md), [logging-](./qa/logging.md) and [exception handling](./qa/exception-handling.md) guidelines.
* Code does not introduce any new [SonarCloud issues][1].

### 2. Thoroughly tested

* Code is tested locally and can be demoed in the an implementing project.


### 3. Well documented
* Consider documenting relevant new features and changes in configuration at dotwebstack.org.
* Any new element to the elmo vocabulary is added to the vocabulary, shapes and documentation pages.

### 4. Properly discussed

* Name of the feature branch starts with `[{$ISSUE_NUMBER}]`.
* All requirements in the user story are met, or deviations are documented as new issues and approved by the Product Owner:
  * Requirements validation is performed by tester as part of DoD check.
* Code is merged with master and feature branch has been removed.
* Preparations for the demo have been performed.

[1]: https://sonarcloud.io/organizations/dotwebstack/projects
