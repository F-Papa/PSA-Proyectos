Feature: Crear una Tarea nueva
  Como usuario quiero agregar nuevas tareas al proyecto para avanzar con la realización del proyecto

  Scenario: creacion correcta
    Given que el usuario ingresó un nombre para la tarea
    And las horas estimadas
    And el proyecto al que pertenecerá
    When el usuario indica que desea crearla
    Then el sistema registra la tarea
    And la vincula al proyecto ingresado
    And informa a quienes fueron agregados
    And informa a quien la creo del exito

  Scenario: sin horas estimadas
    Given que el usuario ingresó un nombre para la tarea
    And el proyecto al que pertenecerá
    But no las horas estimadas
    When el usuario indica que desea crearla
    Then el sistema registra la tarea
    And la vincula al proyecto ingresado
    And informa a quienes fueron agregados
    And informa a quien la creo del exito

  Scenario: sin proyecto
    Given que el usuario ingresó un nombre para la tarea
    And no las horas estimadas
    But no el proyecto al que pertenecerá
    When el usuario indica que desea crearla
    Then el sistema no registra la tarea
    And informa a quien la creo de la nesesidad de vincularla a un proyecto
