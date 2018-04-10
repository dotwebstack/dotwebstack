# Information products

Information products are used to define a specific set of information that can be published via a specific front-end channel.

Two kinds of information products are defined:

- A graph result, containing triples: the result of a CONSTRUCT or DESCRIBE sparql query;
- A tuple result, containing tuples: the result of a SELECT or ASK sparql query.

Information products are stored in native RDF4j java objects: [GraphQueryResult](http://docs.rdf4j.org/javadoc/latest/org/eclipse/rdf4j/query/GraphQueryResult.html) for graph results, and [TupleQueryResult](http://docs.rdf4j.org/javadoc/latest/org/eclipse/rdf4j/query/TupleQueryResult.html) for tuple resuls. This means that it is technically possible to return quads as part of a graph query result. At this moment, this feature is not available, due to the fact that SPARQL 1.1 doesn't support CONSTRUCT queries that return quads.

The definition of an information products is specified using the syntax of the underlying backend. For example: to specify an information product that accesses a SPARQL backend, you write a SPARQL query, to specifiy an information product that accesses a Elastic Search backend, you write an elastic search query. At this moment, only SPARQL queries are supported.

Information products may specify multiple SPARQL backends, using the SPARQL 1.1 SERVICE clause.