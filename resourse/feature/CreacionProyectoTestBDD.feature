Feature: Crear un Proyecto Nuevo
  Como usuario crear un nuevo proyecto para poder gestionarlo y hacer un seguimiento de este

  Scenario Outline: creacion completa
    Given que el usuario ingresó un nombre: <nombre>
    And fecha de finalización estimada: <finalizacionEstimada>
    And fecha de finalización pedida: <finalizacionPedida>
    And fecha de comienzo: <inicio>
    And exposición de riesgo inicial: <riesgo>
    When indica que desea crear el proyecto
    Then el sistema crea el proyecto y notifica al usuario:

    Examples:
      | nombre | finalizacionEstimada | finalizacionPedida | inicio | riesgo |
      | asdfff | finalizacionEstimada | finalizacionPedida | inicio | 0.5 |
      | torta | finalizacionEstimada | finalizacionPedida | inicio | 0.75 |
      | automovil | finalizacionEstimada | finalizacionPedida | inicio | 0.12 |

  Scenario: creacion simple
    Given que el usuario ingresó un nombre:
    When indica que desea crear el proyecto
    Then el sistema crea el proyecto con la información incompleta. Finalmente notifica al usuario

  Scenario: creacion sin nombre
    Given que el usuario no ingresó un nombre
    When indica que desea crear el proyecto
    Then el sistema le avisa al usuario que debe ingresar un nombre para poder crear el proyecto
