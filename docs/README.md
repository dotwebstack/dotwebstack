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

Definition of Done (DoD) is a list of criteria which must be met before a product increment "often a user story" is considered "done".

####1. Good code
* Code does not contain any (Eclipse) warnings or errors.
* Code is has 100% unittest coverage for testable code.
* Code review has been performed:
  * Code is well documented;
  * Code does not contain any TODOs (they must be administered as new Jira issues);
  * Code follows the [coding-](coding.md), [logging-](logging.md) and [exception handling](exception-handling.md) guidelines.
* Code does not introduce any new [SonarCloud issues][1].
####2. Throughly tested
* Code is tested locally and can be demo-ed in the sandbox project.
* Sandbox project contains configuration for any new feature (added to regression test).
* Configuration of sandbox project conforms to the [shapes graph](../vocabulary/elmo-shacl.ttl) for the [elmo vocabulary](../vocabulary/elmo2.ttl). See also the [elmo documentation page](../vocabulary/README.md).
* Sandbox project regression test has been performed.
####3. Well documented
* Any new feature and configuration is documented at dotwebstack.org.
* Any new element to the elmo vocabulary is added to the vocabulary, shapes and documentation pages.

####4. Properly discussed
* Name of the feature branch starts with `[{$ISSUE_NUMMER}]`.
* All requirements in the user story are met, or deviations are documented as new issues and approved by the Product Owner:
  * Requirements validation is performed by tester as part of DoD check.
* Code is merged with master and feature branch has been removed.
* Preparations for the demo have been performed and a link to the particular demo or presentation is added to the issue.  

[1]: https://sonarcloud.io/organizations/dotwebstack/projects
