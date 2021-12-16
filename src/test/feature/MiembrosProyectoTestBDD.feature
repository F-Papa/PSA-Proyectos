Feature: Agregar miembros al proyecto
  Como usuario quiero agregar nuevos miembros al proyecto para poder incluir atodos los integrantes
"""
  Scenario: agregando correcto de un miembreo al equipo
    Given existe un proyecto
    And se selecciona un usuario que no es miembro del proyecto
    When indica que desea agregarlo
    Then el sistema agrega al usuario seleccionado al proyecto
    And el sistema le informa al usuario
    And el sistema le informa a quién lo agrego del exito

  Scenario: agregando correcto de varios miembreo al equipo
    Given existe un proyecto
    And se seleccionan varios usuario que no son miembros del proyecto
    When indica que desea agregarlos
    Then el sistema agrega a los usuarios seleccionados al proyecto
    And el sistema le informa a los usuarios
    And el sistema le informa a quién lo agrego

  Scenario: agregando incorrecto de un miembreo al equipo
    Given existe un proyecto
    And se selecciona un usuario que es miembro del proyecto
    When indica que desea agregarlo
    Then el sistema le informa a quién lo agrego que ya estaba agregado

  Scenario: agregando incorrecto de varios miembreo al equipo
    Given existe un proyecto
    And se seleccionan varios usuario que son miembros del proyecto
    When indica que desea agregarlos
    Then el sistema le informa a quién lo agrego que ya estaban agregadon

  Scenario: agregando de varios miembreo con algunos agregados y otros no al equipo
    Given existe un proyecto
    And se seleccionan varios usuario que son miembros del proyecto
    And se seleccionan varios usuario que no son miembros del proyecto
    When indica que desea agregarlos
    Then el sistema agrega a los usuarios seleccionados que no eran miembros al proyecto
    And el sistema le informa a los usuarios que no eran miembros del proyecto
    And el sistema le informa a quién lo agrego que habia miembros que ya estaban agregados

  Scenario: sin seleccion
    Given existe un proyecto
    But no se selecciona a nadie
    When indica que desea agregarlos
    Then el sistema informa al usuario que debe seleccionar a algún usuario para poder agregarlo al proyecto
"""
  Scenario: agregar lider a un proyecto sin lider
    Given existe un proyecto
    But no tiene lider
    When indica que desea agregarlo en forma de lider
    Then el sistema agrega al usuario seleccionado al proyecto en forma de lider
    And el sistema le informa al usuario
    And el sistema le informa a quién lo agrego del exito

  Scenario: agregar lider a un proyecto con lider
    Given existe un proyecto
    And tiene lider
    When indica que desea agregarlo en forma de lider
    Then el sistema le informa a quién lo agrego que el proyecto ya tiene lider

