# Integration testing

In DotWebStack we try to do as much happy flow testing inside an integration test sandbox. See the (integration-test module)[https://github.com/dotwebstack/dotwebstack-framework/tree/master/integration-test] inside the core project.

Through connecting all the different pieces we can simulate how the actual project will behave and we can ensure that we can deliver the features of the DotWebStack framework as a whole.

As of now, we test both the OpenAPI and LinkedDataAPI through simple requests only. 

## DBEERPEDIA

To have a solid test set, we provide the DBEERPEDIA dataset. This set describes detailed data about different beers around the world.


## Stub triple store

In order to have our tests not be dependant on an external triple store, we have implemented a stub triple store which listens for requests on a pre-defined port. This stub implementation is a simple java `HttpServer` which translate a RDF `Model` to the turtle format, and simulates what a SPARQL endpoint would return, given simular requests. In order to influence the resulting result set, you can provide your own result model when starting your integration test.

For example:

First we need to decorate our test with the start and stop method. After this, the service starts listening on port 8900. 

	```
    @BeforeClass
	public static void startStub() {
	  SparqlHttpStub.start();
	}

	@AfterClass
	public static void stopStub() {
	  SparqlHttpStub.stop();
	}
	
    ```
	
Then you need to tell the SparqlHttpStub which data you wish to return, should a query be executed:
	```
	@Test
	public void getBreweryCollection() {
	  // Arrange
	  Model model = new ModelBuilder().subject(DBEERPEDIA.BREWERIES).add(RDFS.LABEL,
		DBEERPEDIA.BREWERIES_LABEL).build();
	  SparqlHttpStub.returnModel(model);
	  
	  ...
	  
	```
