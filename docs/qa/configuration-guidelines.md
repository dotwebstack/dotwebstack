# Configuratie-guidelines
## Inspringen
* Inspringen gebeurt met twee spaties
* Na elk haakje/andere delimiter dient te worden ingespringen op de volgende regel. Dit geldt in ieder geval voor:
  * {
  * (
  * [
  * '''
* Ook na het openen van een klasse dient te worden ingesprongen (bijvoorbeeld na elmo:Representation)
* De openingshaakjes staan op de regel van het statement waar ze bijhoren
* Als een ‘blok’ weer afgesloten wordt, dan dient die afsluiting op een nieuwe regel, maar niet langer ingesprongen te gebeuren

Voorbeeld van correct inspringen:
```
GRAPH config:CatalogusTheatre {
  config:WeergavePaginaProducten a elmo:Representation;
    # Bereikbaarheid
    elmo:urlPattern “/producten”;

    # Beschrijving appearance
    elmo:appearance config:WeergavePaginaProductenAppearance;
    elmo:informationProduct config:IPProducten;

    # Overige onderdelen
    elmo:contains config:DSOMenu
  .
}
```

## Representations
*	Representations bevatten drie onderdelen:
  *	Bereikbaarheid (optioneel). Hieronder vallen de volgende statements:
    *	elmo:urlPattern
    *	elmo:uriPattern
    *	elmo:appliesTo
    *	elmo:stage
  *	Beschrijving representation (verplicht). Hieronder vallen:
    *	elmo:appearance
    *	elmo:informationProduct
 *	Overige onderdelen (optioneel). Hieronder vallen:
    *	elmo:contains
*	De drie onderdelen dienen middels een comment van elkaar onderscheiden te worden
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
*	Bestanden met informatieproducten hebben als prefix ip_
*	elmo:InformationProducts hebben een naam die begint met IP en verder zoveel mogelijk identiek is aan de elmo:Representation waar het informatieproduct bijhoort
*	elmo:Representations hebben een zo kort mogelijk, maar beschrijvende naam.
*	Appearances krijgen dezelfde naam als de Representations waar ze bijhoren, met Appearance als postfix. Bijvoorbeeld bij de representation config:WeergavePaginaConcepten hoort de appearance config:WeergavePaginaConceptenAppearance.

## Overig
*	Bij het opleveren van InformationProducts moet de keuze gemaakt worden of het InformationProduct ook via de API beschikbaar moet zijn.
  *	Zo ja, dan dient ook catalogus.yml geupdate te worden.