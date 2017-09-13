# Unittesting

In DotWebStack we follow a naming convention to indicate what we are testing inside the test name itself. We also follow the ("Arrange-Act-Assert" pattern) [http://wiki.c2.com/?ArrangeActAssert].

## Naming convention

**MethodName_ExpectedBehavior_StateUnderTest**: All method names in unit tests should follow this convention. This convention makes it clear what we are trying to test, without the need to dive deeply into the unittest itself. This technique has disadvantage that if method names get changed, it needs to be refactored too. The advantage is however that we can keep our units small, since we only test public method. Following is how tests in first example would read like if named using this technique:
isAdult_False_AgeLessThan18
withdrawMoney_ThrowsException_IfAccountIsInvalid
admitStudent_FailToAdmit_IfMandatoryFieldsAreMissing

## Arrange-Act-Assert

**"Arrange-Act-Assert"** ia a pattern for arranging and formatting code in UnitTest methods:
Each method should group these functional sections, separated by blank lines:
- Arrange all necessary preconditions and inputs.
- Act on the object or method under test.
- Assert that the expected results have occurred.

By adding comments to the unittests we make sure this pattern is followed and easily understood.

	```
    public void getSize_ReturnsMinus1_ForAnyGraphResult() {
		// Arrange
		JsonLdGraphMessageBodyWriter writer = new JsonLdGraphMessageBodyWriter();

		// Act
		long result =
			writer.getSize(graphQueryResult, null, null, null, MediaType.APPLICATION_XML_TYPE);

		// Assert
		assertThat(result, equalTo(-1L));		
	}
	
    ```
	
When testing for expected exceptions, we reverse the Act and Assert, and use JUnits `ExpectedException` rules, like so:

	```
    @Rule
	public ExpectedException thrown = ExpectedException.none();
	  
    public void getSize_ThrowsException_ForEmptyString() {
		// Arrange
		JsonLdGraphMessageBodyWriter writer = new JsonLdGraphMessageBodyWriter();

		// Assert
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("My expected message);

		// Act
		writer.getSize("", null, null, null, MediaType.APPLICATION_XML_TYPE);
	}
	
    ```

## Code coverage

We strife to uphold a minimal code coverage of 95% in our solutions. To so do, we let the build fail if the coverage ever drops below this threshold.

## Libraries

For unittesting we use a set of libraries.

### JUnit

We use JUnit for testing.

### Hamcrest matchers

For asserts we use hamcrest matchers for more human readable code. For example, compare the following:

	```
	// JUnit 4 for equals check
	assertEquals(expected, actual);
	
	// Hamcrest for equals check
	assertThat(actual, is(equalTo(expected)));
	```
	
You can read more in depth about at (Hamcrest.org) [https://code.google.com/archive/p/hamcrest/wikis/Tutorial.wiki]

### Mockito for mocking

We use Mockito for mocking every dependency that is injected into our class. This way we can test behaviour in a more predictable way and we can write cleaner tests.

The benefits of a mocking framework are in comparison to writing stub class of our services:

- Easier to maintain
- Less code to create a mock
- Follows DRY (you won't end up repeating mock implementations)

### Powermock for corner cases

We use Powermock for corner cases. Powermock is a powerful extension on Mockito, but should be used sparingly. We use it to mock static methods, and for mocking constructors which we cannot inject ourself. Before using a powermock implementations, ask yourself if the code you are testing has been set up properly. If you can do without powermock, that should be the preferred route.