Feature: Crear un Proyecto Nuevo
  Como usuario crear un nuevo proyecto para poder gestionarlo y hacer un seguimiento de este

  Scenario Outline: CAMPOS_OBLIGATORIOS
    Given el usuario ingreso la informacion obligatoria
      |<nombre>|
    When indica que desea crear el proyecto

    Then El sistema crea el proyecto con la información ingresada y notifica al usuario.
    Examples:
      |        nombre |
      |  SistemaDeInscripcion  |


  Scenario Outline: CAMPOS_OBLIGATORIOS_VACÍOS
    Given que el usuario no ingresó la información obligatoria: Nombre del proyecto
      |  <nombre>  |
    When indica que desea crear el proyecto
    Then  El sistema no crea el proyecto e informa al usuario que debe ingresar la información obligatoria.
    Examples:
      | nombre |
      | no_ingresado |


  Scenario Outline: CAMPOS_OPCIONALES
    Given que el usuario ingresó además de la obligatoria la información opcional, <nombre> , <legajoLider> , <estado>
    When indica que desea crear el proyecto
    Then El sistema crea el proyecto con la información ingresada y notifica al usuario.
    Examples:
      |nombre | legajoLider | estado |
      | "ingresado" |  010    | 0 |
