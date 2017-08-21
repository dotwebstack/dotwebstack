# Quality assurance

## Definition of Ready

Definition of Ready (DoR) is a list of criteria that a user story must meet prior to being accepted into the upcoming iteration.

* The user story is well defined;
* Testers have defined its user story acceptance criteria;
* All dependencies are known;
* Proper sizing or re-sizing has been done if required;
* The development team has approved the user story;
* Finally, the delivery team has a good idea of how the demo of the user story would be.

## Definition of Done

Definition of Done (DoD) is a list of criteria which must be met before a product increment "often a user story" is considered "done".

* Code does not contain any (Eclipse) warnings or errors;
* Code is sufficiently covered with tests;
* Code is sufficiently documented;
* Code follows the [coding-](coding.md), [logging-](logging.md) and [exception handling](exception-handling.md) guidelines;
* Code does not introduce any new [SonarCloud issues][1];
* Code does not contain any TODOs (they must be administered as new Jira issues);
* Code is merged with master and feature branch has been removed.

[1]: https://sonarcloud.io/organizations/dotwebstack/projects
