# Mapping Elmo 1.0 and Elmo 2.0

The table below describes how elements from elmo-1 are mapped to elements of elmo-2, and whether or not these elements have already been incorporated into the dotwebstack 2.0 framework.

The following prefixes are used:

    elmo1: <htp://bp4mc2.org/elmo/def#>
    elmo2: <http://dotwebstack.org/def/elmo#>

A value of "legacy" in the column realised means that the particular element is only available in the legacy implementation of the theatre.

## Classes

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|---------|------------
`elmo1:Fragment`|`elmo2:Fragment`||Legacy
`elmo1:Query`|`elmo2:InformationProduct`|The need for a `elmo:Query` class is not necessary any more with the availability of `elmo2:InformationProduct`|Yes
`elmo1:Representation`|`elmo2:Representation`|Only some parts, see also `elmo2:InformationProduct` and `elmo2:Appearance`|Yes
`elmo1:Representation`|`elmo2:Appearance`|with regard to `elmo1:index` and `elmo1:fragment` elements|Legacy
`elmo1:Representation`|`elmo2:InformationProduct`|with regard to `elmo:query`|Yes


## Properties

### `elmo1:Representation`

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
||`elmo2:informationProduct`|Links an `elmo2:Representation` to its `elmo2:InformationProduct`|Yes
|`elmo1:adapter`||Unknown|No
|`elmo1:appearance`|`elmo2:appearance`|`elmo2:appearance maps` to instances of `elmo2:Appearance`, not to classes as does `elmo1:apearance`|Yes
|`elmo1:applies-to`|`elmo2:appliesTo`||No
|`elmo1:contains`|`elmo2:contains`||Yes
|`elmo1:data`|`elmo2:data`|Static data is net yet supported. You might use an IP dat delivers only static content|No
|`elmo1:endpoint`|`elmo2:backend`|Moved to `elmo2:InformationProduct`. A separate class `elmo:Backend` is used.|Moved
|`elmo1:fragment`|`elmo2:fragment`|Moved to `elmo2:Appearance`|Moved
|`elmo1:index`|`elmo2:index`|Moved to `elmo2:Appearance`|Legacy, not yet
|`elmo1:layer`||Representation collision cannot occur at this moment, so no need (yet) for `elmo:layer`|No
|`elmo1:product`||Unknown|No
|`elmo1:query`|`elmo2:query`|Moved to `elmo2:InformationProduct`|Moved
|`elmo1:queryForm`|||No
|`xhtml:stylesheet`|`xhtml:stylesheet`|Moved to `elmo2:Appearance`|Legacy, not yet
|`elmo1:url-pattern`|`elmo2:urlPattern`||Yes
|`elmo1:uri-pattern`|`elmo2:uriPattern`||No

### `elmo1:Fragment`

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
|`rdfs:label`|`rdfs:label`||Yes
|`elmo1:applies-to`|`elmo2:appliesTo`||Yes
|`elmo1:index`|`elmo2:index`||Legacy, not yet
|`elmo1:appearance`|||Legacy, not yet
|`elmo1:glossary`|||Legacy, not yet
|`xhtml:stylesheet`|`xhtml:stylesheet`||Legacy, not yet
|`xhtml:link`|`xhtml:link`||Legacy, not yet
|`rdf:value`|`rdf:value`||Legacy, not yet
