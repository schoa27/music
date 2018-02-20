Feature: In deze feature worden alle albums aanwezig in de database
  opgehaald. Verder kan er een aan zoek filters worden toegepast

  Scenario Outline: : Alle albums ophalen met met eventueel een gesorteerd
    Given Haal alle albums op uit de database met of zonder sortering
    When Naam sortering is ingevuld met <naam>
    When Tietel sortering is ingevuld met <tietel>
    When Jaartal sortering is ingevuld met <jaartal>
    Then Album lijst bevat  albums
    Examples:
      |naam   | tietel | jaartal |
      |  "a"  |  ""    | ""      |
      |  ""   | "B "   | "1977"  |