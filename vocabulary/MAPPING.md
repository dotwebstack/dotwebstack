# Mapping Elmo 1.0 and Elmo 2.0

The table below describes how elements from elmo-1 are mapped to elements of elmo-2, and whether or not these elements have already been incorporated into the dotwebstack 2.0 framework.

The following prefixes are used:

	elmo1: <htp://bp4mc2.org/elmo/def#>
	elmo2: <http://dotwebstack.org/def/elmo#>

A value of "legacy" in the column realised means that the particular element is only available in the legacy implementation of the theatre.

## Classes

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|---------|------------
`elmo1:Representation`|`elmo2:Representation`|Only some parts, see also `elmo2:InformationProduct` and `elmo2:Appearance`|Yes
`elmo1:Representation`|`elmo2:Appearance`|with regard to `elmo1:fragment` elements|Legacy
`elmo1:Representation`|`elmo2:InformationProduct`|with regard to `elmo:query`|Yes

## Properties

### `elmo1:Representation`

|elmo 1.0 term|elmo 2.0 term|Comment|Realised
|-------------|-------------|-------|--------
|`elmo1:appearance`|`elmo2:appearance`|`elmo2:appearance maps to instances of `elmo2:Appearance`, not to classes as does `elmo1:apearance`
|`elmo1:contains`|`elmo2:contains`||No
||`elmo2:informationProduct`|Links an `elmo2:Representation` to its `elmo2:InformationProduct`|Yes
|`elmo1:query`|`elmo2:query`|Moved to `elmo2:InformationProduct`. Only literals are supported at this moment|Yes (literals)
|`elmo1:endpoint`|`elmo2:backend`|A separate class `elmo:Backend` is used.|Yes
|`elmo1:adapter`|||No
