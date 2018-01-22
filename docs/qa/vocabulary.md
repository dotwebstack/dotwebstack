# Vocabulary guidelines

Guidelines how to extend the elmo vocabulary with new terms (classes, properties and instances).

## Language and syntax
1. Terms for classes use UpperCamelCase.
2. Terms for properties use lowerCamelCase.
3. Terms for instances use UpperCamelCase.
4. All terms consist of one or more US English words.
5. Reuse elements of existing, widely used vocabularies. New terms are only introduced when an applicable term isn't available in an existing vocabulary (a term is "applicable" if the intended meaning is the same as the defined meaning in the existing vocabulary).

The elmo vocabulary exists, because no vocabulary for an application like the dotwebstack exists at this moment. However, some particular classes and properties are already available and should be used. At least elements from the following vocabularies should be considered before extending the elmo vocabulary:

- [RDF](http://www.w3.org/1999/02/22-rdf-syntax-ns#), [RDFS](http://www.w3.org/2000/01/rdf-schema#) and [OWL](http://www.w3.org/2002/07/owl#);
- [SKOS](http://www.w3.org/2004/02/skos/core#) and [DublinCore](http://purl.org/dc/elements/1.1/);
- [SHACL](http://www.w3.org/ns/shacl#) and [XSD](http://www.w3.org/2001/XMLSchema#);
- [XHTML](http://www.w3.org/1999/xhtml/vocab#) and [HTTP](http://www.w3.org/2011/http#).

## General

1. Terms should refer to the actual meaning of a class or property as it is understood by the person that uses the vocabulary for dotwebstack configurations. The "most commonly understood term" should be used.
2. Terms should be as short as possible, while upholding guideline 1.
3. Introduction of new terms should not be taken lightly. Terms are reused, except when reuse would violate general guideline 1. The vocabulary should not contain synonyms.
4. The meaning of a term should be understood from a declarative perspective, and not from an implementation perspective (for example: the class *InformationProduct* classifies something as a product of information. *SparqlBackendInformationProduct* should not be introduced, because the particular backend is only an implementation concern). 
5. The vocabulary should not contain term that are homonyms within the scope of the vocabulary (any single term should not refer to multiple intended meanings), except in the case as described by property guideline 2.

## Classes

1. Class terms should be singular nouns.
2. The term of a subclass should end with the term of the superclass, except when general guideline 1 dictates otherwise.
3. If a class is used in a specific role with respect to another class, a new term (and subclass) **should not** be introduced. In such cases, a term that indicates the role should be part of the property (see also property guideline 3).
4. If a class term consists of multiple words, the fundamental meaning should be contained in the last word (for example: A *ParameterMapper* is a mapper and not a parameter, a *SubjectParameter* is a parameter and not a subject).

## Properties

1. Property terms should be predicates (in most cases this means a verb with a preposition, like `appliesTo`), except in cases where property guideline 2 or 3 applies.
2. Property terms should be equal (in lowerCamelCase) to the class of the object if the predicate verb would be `has`, (like `appearance` instead of `hasAppearance`). The property term should be singular except when the object is a rdf:List of objects (in such a case the term should be plural).
3. Property terms should end with the class of the object if the predicate verb would be `has` **and** refer to the role of the class with regard to the class of the subject. For example `defaultBackend` is a property that links a class to an object of the class `Backend` that performs the role of the `defaultBackend` with regard to the former class.
4. Guideline 3 also applies to properties that refer to literals that play a specific role with regard to the class of the subject.
5. The term of a property should refer to the complete meaning of a property, independent of the class for which the property is used (properties are first-class in a linked data vocabulary, this differs from UML attributes in UML class diagrams, whose meaning is dependent on the meaning of the corresponding UML class).
6. The same property (and term) should be used for properties in different classes, if the fundamental meaning of those properties is the same (like properties as `elmo:name`, `elmo:index` and `rdfs:label`).

## Edge cases

The table below gives examples of terms that are part of the elmo vocabulary and explains how the guidelines are used for these terms and why alternative terms are not used:

Correct term | Wrong term | Rationale | Guideline
-------------|------------|-----------|-----------
pathPattern | urlPattern | The property refers to a pattern of paths, and not a pattern of URLs | G1
pathPattern | path | The property refers to a pattern and not (only) to a path. Although the JAX-RS implementation uses path, the implemention may not be known to the user. | G1, G4, P4
TermParameter | TermFilter | TermParameter is a subclass of Parameter | C2
shape | nodeShape, propertyShape | Only one property is necessary | G3
xhtml:stylesheet | elmo:stylesheet | Existing vocabulary | L5
redirectTemplate | redirectUrl | The property refers to a template. It is a template of URL's.| G1, P4
redirectTemplate | redirectUrlTemplate | A redirection is always to a Url|G2
redirectTemplate | redirectPattern | Pattern is confusing, because a pattern is used to 'match' something, a template is used to 'create' something. The used of pattern and template should be the same for the whole vocabulary| G1, G5
redirectTemplate | template | It is not simply a template, but a template used in a specific role, to create the redirect URL| G1, G5, P4
Backend | DefaultBackend | Role should be part of property (defaultBackend) | C3