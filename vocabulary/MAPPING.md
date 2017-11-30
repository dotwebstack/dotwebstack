# Mapping Elmo 1.0 and Elmo 2.0

The table below describes how elements from elmo-1 are mapped to elements of elmo-2, and whether or not these elements have already been incorporated into the dotwebstack 2.0 framework.

The following prefixes are used:

    elmo1: <htp://bp4mc2.org/elmo/def#>
    elmo2: <http://dotwebstack.org/def/elmo#>
    rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
    rdfs: <http://www.w3.org/2000/01/rdf-schema#>
    geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>
    yed: <http://bp4mc2.org/yed#>
    xhtml: <http://www.w3.org/1999/xhtml/vocab#>

A value of "legacy" in the column realised means that the particular element is only available in the legacy implementation of the theatre.

## Classes

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|---------|------------
`elmo1:Assertion`|||No
`elmo1:Container`|`elmo2:Representation`|with regard to the URI matching|No
`elmo1:Container`|`elmo2:Transaction`|with regard to the processing|No
`elmo1:VersionContainer`|`elmo2:VersionContainer`|see `elmo1:Container`|No
`elmo1:Fragment`|`elmo2:Fragment`||Legacy
`elmo1:Form`|||No
`elmo1:GeoLocator`|||No
`elmo1:Part`|`elmo2:Representation`|No need for specific class `elmo1:Part` anymore|Yes
`elmo1:Production`|`elmo2:Representation`|with regard to the URI matching|No
`elmo1:Production`|`elmo2:Transaction`|with regard to the processing|No
`elmo1:Query`|`elmo2:InformationProduct`|The need for an `elmo:Query` class is gone with the availability of `elmo2:InformationProduct`|Yes
`elmo1:Representation`|`elmo2:Representation`|Only some parts, see also `elmo2:InformationProduct` and `elmo2:Appearance`|Yes
`elmo1:Representation`|`elmo2:Appearance`|with regard to `elmo1:index` and `elmo1:fragment` elements|Legacy
`elmo1:Representation`|`elmo2:InformationProduct`|with regard to `elmo:query`|Yes
`elmo1:Scene`|`elmo2:Production`|scenes are `preQueries` or `postQueries`|No


## Properties

### `elmo1:Representation` and `elmo1:Part`

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
||`elmo2:informationProduct`|Links an `elmo2:Representation` to its `elmo2:InformationProduct`|Yes
|`rdfs:label`|`rdfs:label`||Yes
|`elmo1:accept`|||No
|`elmo1:appearance`|`elmo2:appearance`|`elmo2:appearance` maps to instances of `elmo2:Appearance`, not to classes as does `elmo1:appearance`|Yes
|`elmo1:applies-to`|`elmo2:appliesTo`||No
|`elmo1:container`|||No
|`elmo1:contains`|`elmo2:contains`||Yes
|`elmo1:data`|`elmo2:data`|Static data is net yet supported. You might use an IP that delivers only static content|No
|`elmo1:endpoint`|`elmo2:backend`|Moved to `elmo2:InformationProduct`. A separate class `elmo:Backend` is used.|Moved
|`elmo1:fragment`|`elmo2:fragment`|Moved to `elmo2:Appearance`|Moved
|`elmo1:index`|`elmo2:index`|Moved to `elmo2:Appearance`|Legacy, not yet
|`elmo1:layer`||Representation collision cannot occur at this moment, so no need (yet) for `elmo:layer`|No
|`elmo1:name`|||No
|`elmo1:query`|`elmo2:query`|Moved to `elmo2:InformationProduct`|Moved
|`elmo1:queryForm`|||No
|`elmo1:service`|||No
|`elmo1:translator`|||No
|`xhtml:stylesheet`|`xhtml:stylesheet`|Moved to `elmo2:Appearance`|Legacy, not yet
|`elmo1:url-pattern`|`elmo2:urlPattern`||Yes
|`elmo1:uri-pattern`|`elmo2:uriPattern`||No
|`elmo1:webpage`|||No
|`elmo1:with-parameter`|||No
|`elmo1:without-parameter`|||No

### `elmo1:Fragment`

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
|`rdfs:label`|`rdfs:label`||Yes
|`elmo1:applies-to`|`elmo2:appliesTo`||Yes
|`elmo1:backmap`|`elmo2:backmap`||Legacy, not yet
|`elmo1:index`|`elmo2:index`||Legacy, not yet
|`elmo1:appearance`|`elmo2:appearance`||Legacy, not yet
|`xhtml:glossary`|`xhtml:glossary`||Legacy, not yet
|`elmo1:name`|`elmo2:name`||Legacy, not yet
|`xhtml:stylesheet`|`xhtml:stylesheet`||Legacy, not yet
|`xhtml:link`|`xhtml:link`||Legacy, not yet
|`rdf:value`|`rdf:value`||Legacy, not yet

### `elmo1:Fragment` (with forms)

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
|`elmo1:constraint`|||No
|`elmo1:valueDatatype`|||No
|`elmo1:valueFormat`|||No
|`elmo1:valuesFrom`|||No
|`elmo1:valueHint`|||No
|`elmo1:valuePattern`|||No

### `elmo1:Fragment` (in case of yed representation)

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
|`yed:backgroundcolor`|||No
|`yed:edge`|||No
|`yed:line`|||No
|`yed:sourceArrow`|||No
|`yed:targetArrow`|||No

### `elmo1:Fragment` (in case of a Geo layer)

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
|`elmo1:applies-to`|`elmo2:appliesTo`||Yes
|`elmo1:appearance`|`elmo2:appearance`||Legacy, not yet
|`elmo1:service`|`elmo2:service`||Legacy, not yet
|`elmo1:layer`|`elmo2:layer`||Legacy, not yet

### `elmo1:Fragment` (in case of plain json formatting)

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
|`elmo1:name`|||No
|`elmo1:path`|||No

### `elmo1:Container` and `elmo1:VersionContainer`
Translates to `elmo2:Transaction`, except when explictly stated otherwise.

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
||`elmo2:putTransaction`|links a `elmo2:Representation` to its `elmo2:Transaction` in case of a PUT method|No
||`elmo2:postTransaction`|links a `elmo2:Representation` to its `elmo2:Transaction` in case of a POST method|No
||`elmo2:deleteTransaction`|links a `elmo2:Representation` to its `elmo2:Transaction` in case of a DELETE method|No
|`rdfs:label`|`rdfs:label`||No
|`elmo1:assertion`|||No
|`elmo1:contains`|`elmo2:contains`|As part of the elmo2:Representation|Yes
|`elmo1:fragment`|||No
|`elmo1:partOf`|`elmo2:storageProtocol`|Multiple storage protocols are available to get the desired result|No
|`elmo1:query`|`elmo2:postQueries`||No
|`elmo1:replaces`|`elmo2:storageProtocol`|Multiple storage protocols are available to get the desired result|No
|`elmo1:representation`||Not needed any more, because an elmo2:Representation is already available|No
|`elmo1:shape`|||No
|`elmo1:translator`|`elmo2:transformer`||No
|`elmo1:updates`|`elmo2:storageProtocol`|Multiple storage protocols are available to get the desired result|No

### `elmo1:Production`
Translates to `elmo2:Transaction`, except when explictly stated otherwise.

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
|`elmo1:contains`|`elmo2:contains`|As part of the elmo2:Representation|Yes
|`elmo1:queryForm`|||No

### `elmo:Scene`
|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
|`rdfs:label`||||No
|`elmo:index`||No need for index: postQueries is an ordered list|No
|`elmo1:query`||An item from the `elmo2:postQueries` list as part of an `elmo2:Transaction`|No

### `elmo1:Form`
|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
|`elmo1:fragment`|||No


### `elmo1:GeoLocator`
|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
|`rdf:value`|||No
|`rdfs:label`|||No
|`geo:lat`|||No
|`geo:long`|||No

### `elmo1:Assertion`
|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
|`elmo1:assert`|||No
|`elmo1:assert-not`|||No
