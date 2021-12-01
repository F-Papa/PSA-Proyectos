Feature: Consultar miembros de un proyecto
  Como usuario quiero consultar los miembros del proyecto para saber quién es parte del mismo

  Scenario: Consulta de proyecto sin miembros
    Given se selecciona un proyecto sin miembros
    When indica que desea consultar sus miembros
    Then el sistema informa al usuario que el proyecto no tiene miembros

  Scenario: Consulta de proyecto con miembros
    Given se selecciona un proyecto con miembros
    When indica que desea consultar sus miembros
    Then el sistema informa al usuario quiénes son los miembros del proyecto
