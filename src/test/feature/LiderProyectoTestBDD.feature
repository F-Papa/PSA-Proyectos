Feature: Agregar lider al proyecto
  Como usuario quiero agregar un lider al proyecto para que lo supervise

  Scenario Outline: agregar lider a un proyecto sin lider
    Given existe un proyecto
    But no tiene lider
    When indica que desea agregarlo en forma de lider <legajoLider>
    Then el sistema agrega al usuario seleccionado al proyecto en forma de lider
    And el sistema le informa al usuario
    And el sistema le informa a quién lo agrego del exito
    Examples:
      | legajoLider |
      |     035          |

  Scenario Outline: agregar lider a un proyecto con lider
    Given existe un proyecto
    And tiene lider
    When indica que desea agregarlo en forma de lider <legajoLider>
    Then el sistema le informa a quién lo agrego que el proyecto ya tiene lider
    Examples:
      | legajoLider |
      |     035          |