Feature: Crear una Tarea nueva
  Como usuario quiero agregar nuevas tareas al proyecto para avanzar con la realización del proyecto

 Scenario Outline:  CAMPOS_OBLIGATORIOS
    Given que el usuario ingresó la información obligatoria: nombre de la tarea
      |  <nombre>  |
   And el proyecto al que pertenecerá
     | <codigo_proyecto> |
    When el usuario indica que desea crearla
    Then el sistema registra la tarea
    And la vincula al proyecto ingresado
   | <codigo_proyecto> |
    And informa a quienes fueron agregados
    And informa a quien la creo del exito

   Examples:
     |nombre          |    codigo_proyecto     |
     | "ingresado" |       10        |

  Scenario Outline: CAMPOS_OBLIGATORIOS_VACÍOS
    Given que el usuario ingresó la información obligatoria: nombre de la tarea
      | <nombre>  |
    And no el proyecto al que pertenecerá
      |<codigo_proyecto>|
    When el usuario indica que desea crearla
    Then El sistema no registra la tarea e informa al usuario que debe ingresar la información obligatoria

    Examples:
      |nombre      |   codigo_proyecto       |
      | "no_ingresado" |      no_ingresado          |


  Scenario Outline: CAMPOS_OPCIONALES
    Given que el usuario ingresó además de la obligatoria la información opcional: <nombre> , <empleado> , <duracion_estimada>, <descripcion>
    When el usuario indica que desea crearla
    Then El sistema registra la tarea con la información ingresada y notifica al usuario
    Examples:
      |nombre  | empleado       | duracion_estimada|  descripcion |
      | "ingresado" |      3          |  2        |  "ingresado"   |
