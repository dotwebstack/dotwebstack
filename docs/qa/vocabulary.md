# Vocabulary guidelines

Guidelines how to extend the elmo vocabulary with new terms (properties or classes).

## General

1. All terms are consists of one or more US english words.
2. Terms for classes use UpperCamelCase.
3. Terms for properties use lowerCamelCase.
4. Terms should refer to the actual meaning of a class or property as it should be understood by the person that uses the vocabulary for dotwebstack configurations. The "most commonly understood term" should be used.
5. Terms should be as short as possible, while upholding guideline 4.
6. As a general rule, introduction of new terms should not be taken lightly. If it is possible to reuse the same term (while upholding guideline 4), we should.
7. New terms are only introduced when an applicable term isn't available in an already widely used vocabulary.

The elmo vocabulary exists, because no vocabulary for an application like the dotwebstack exists at this moment. However, some particular classes and properties are already available and should be used. At least terms from the following vocabularies should be considered before extending the elmo vocabulary:

- [RDF](http://www.w3.org/1999/02/22-rdf-syntax-ns#), [RDFS](http://www.w3.org/2000/01/rdf-schema#) and [OWL](http://www.w3.org/2002/07/owl#);
- [SKOS](http://www.w3.org/2004/02/skos/core#) and [DublinCore](http://purl.org/dc/elements/1.1/);
- [SHACL](http://www.w3.org/ns/shacl#) and [XSD](http://www.w3.org/2001/XMLSchema#);
- [XHTML](http://www.w3.org/1999/xhtml/vocab#) and [HTTP](http://www.w3.org/2011/http#).

## Classes

1. Class terms should be singular nouns.
2. The meaning of a class should be understood from a declarative perspective, and not from an implementation perspective (for example: the class *InformationProduct* classifies something as a product of information, no subclass for particular backends should be introduced, because the particular backend is only an implementation concern). 
3. The terms of two classes should not be synonyms (a clear distinction in meaning based on the terms should be possible).
4. The terms of subclasses of a superclass should end with the term of the superclass, except when general guideline 4 dictates otherwise.
5. If a class is used in a specific role with respect to another class, a new term (and subclass) **should not** be introduced. In such cases, a term that indicates the role should be part of the property (see also property guideline 3).
6. If a class term consists of multiple words, the fundamental meaning should be contained in the last world (for example: A *ParameterMapper* is a mapper and not a parameter, a *SubjectParameter* is a parameter and not a subject).

## Properties

1. Property terms should be predicates (in most cases this means a verb with a preposition, like `appliesTo`), except...
2. Property terms should be equal (in lowerCamelCase) to the class of the object if the predicate verb would be `has`, (like `appearance` instead of `hasAppearance`). The property term should be singular in most cases, and plural when the object is a rdf:List of objects.
3. Property terms should end with the class of the object if the predicate verb would be `has` **and** start with a term that refers to the role of the class with regard to the class of the subject. For example `defaultBackend` is a property that links a class to an object of the class `Backend` that performs the role of the `defaultBackend` with regard to the former class.
4. The term of a property should refer to the complete meaning of a property, independent of the class for which the property is used (properties are first-class in a linked data vocabulary, this differs from UML attributes in UML class diagrams, whose meaning is dependent on the meaning of the corresponding UML class).
5. The same property (and term) should be used for properties in different classes, if the fundamental meaning of those properties is the same (like properties as `elmo:name`, `elmo:index` and `rdfs:label`).

## Edge cases

The table below gives examples of terms that are part of the elmo vocabulary and explains how the guidelines are used for these terms and why alternative terms are not used:

Term | Alternative | Rationale | Guideline
-----|-------------|-----------|-----------
pathPattern | urlPattern | The property refers to a pattern of paths, and not a pattern of URLs | G4
pathPattern | path | The property refers to a pattern and not (only) to a path. Although the JAX-RS implementation uses path, the implemention may not be known to the user. | G4, C2, P3
TermParameter | TermFilter | TermParameter is a subclass of Parameter | C4
shape | NodeShape, PropertyShape | Only one property is necessary | G6
xhtml:stylesheet | elmo:stylesheet | Existing vocabulary | G7
redirectTemplate | redirectUrl | The property refers to a template. It is a template of URL's.| G4, P3
redirectTemplate | redirectUrlTemplate | A redirection is always to a Url|G5
redirectTemplate | redirectPattern | Pattern is confusing, because a pattern is used to 'match' something, a template is used to 'create' something. The used of pattern and template should be the same for the whole vocabulary|G4,C3
