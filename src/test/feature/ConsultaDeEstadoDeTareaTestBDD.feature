Feature: Consultar estado de tarea
  Como usuario quiero conocer el estado de una tarea para saber si tengo que trabajar en ella

  Scenario Outline: Consulta de estado de tarea correcta
    Given se seleccionó una tarea
      | <codigo> |
    When indica que desea conocer su estado
    Then el sistema informa al usuario cuál es el estado de la misma

    Examples:
      |  codigo   |
      |     2      |