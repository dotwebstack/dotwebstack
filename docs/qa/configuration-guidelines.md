# Configuratie-guidelines
## Inspringen
* Inspringen gebeurt met twee spaties
* In ieder geval wordt er bij de volgende tekens ingesprongen op een volgende regel:
  * {
  * (
  * [
* Drie opeenvolgende quotes (''' of """) hebben een specifieke betekenis als ze gebruikt worden om een volledig statement uit te schrijven. Als dat het geval is, dan dient ook ingesprongen te worden op een volgende regel, tenzij dit de betekenis van het volledige statement verandert.
* Ook na geconcateneerde triple-statements (typisch na een ;) dient te worden ingesprongen.
* De openingshaakjes staan op de regel van het statement waar ze bijhoren
* Als een ‘blok’ weer afgesloten wordt, dan dient die afsluiting op een nieuwe regel, maar niet langer ingesprongen te gebeuren

Voorbeeld van correct inspringen:
```
GRAPH config:CatalogusTheatre {
  config:WeergavePaginaProducten a elmo:Representation;
    elmo:pathPattern “/producten”;

    elmo:appearance config:WeergavePaginaProductenAppearance;
    elmo:informationProduct config:IPProducten;
    elmo:parametermapper config:SubjectFromUrl;

    elmo:contains config:DSOMenu
  .
}
```

## Representations
*	Representations kunnen drie onderdelen bevatten. Als deze aanwezig zijn, dan worden ze in de hieronder vermelde volgorde opgenomen. Deze onderdelen zijn:
  *	Bereikbaarheid (verplicht). Hieronder vallen de volgende statements:
    *	elmo:stage (verplicht)
    *	elmo:pathPattern (optioneel)
    *	elmo:uriPattern (optioneel)
    *	elmo:appliesTo (optioneel)
  *	Beschrijving representation (verplicht). Hieronder vallen:
    *	elmo:appearance (verplicht)
    *	elmo:informationProduct (verplicht)
    * elmo:parameterMapper (optioneel)
 *	Overige onderdelen (optioneel). Hieronder vallen:
    *	elmo:contains (optioneel)
*	De drie onderdelen dienen middels een witregel van elkaar onderscheiden te worden
*	Zie voorbeeld hierboven

## Query’s
*	SPARQL-commando’s dienen met hoofdletters geschreven te worden. Bijvoorbeeld GRAPH ipv graph, SELECT ipv select etc.
*	Triples met hetzelfde subject dienen zoveel mogelijk ‘samengetrokken’ te worden. Zie onderstaande voorbeeld.

```
# Niet correct
?subject rdfs:label ?label.
?subject skos:prefLabel ?prefLabel.
?subject skos:definition ?definition.

# Correct
?subject rdfs:label ?label;
  skos:prefLabel ?prefLabel;
  skos:definition ?definition
.
```

## Naamgeving
*	Er zijn drie mappen waarin configuratiebestanden gezet kunnen worden:
  *	system. Deze bevat:
    *	system.trig
    * parameters.trig
  *	frontend. Deze bevat:
    *	alle bestanden met representaties
  *	backend. Deze bevat:
    *	backend.trig
    *	alle bestanden met informatieproducten
* Bovendien is er één bestand dat in de root map van de configuratiebestanden gezet moet worden:
  *	_prefixes.trig
*	Bestanden met informatieproducten hebben als prefix IP
*	elmo:InformationProducts hebben een naam die begint met IP en verder zoveel mogelijk identiek is aan de elmo:Representation waar het informatieproduct bijhoort
*	elmo:Representations hebben een zo kort mogelijk, maar beschrijvende naam.
*	elmo:Appearances hebben een naam die begint met App en verder zoveel mogelijk identiek is aan de elmo:Representation waar de appearance bijhoort. Bijvoorbeeld bij de representation config:WeergavePaginaConcepten hoort de appearance config:AppWeergavePaginaConcepten.

## Overig
* De configuratie dient voldoende gedocumenteerd te zijn, middels comments (#) waar nodig.
*	Bij het opleveren van InformationProducts moet de keuze gemaakt worden of het InformationProduct ook via de API beschikbaar moet zijn. Zo ja, dan dient ook catalogus.yml geupdate te worden.
