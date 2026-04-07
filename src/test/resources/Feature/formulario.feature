Feature: Registrar Formulario Novus Technology
  Yo como alumno de novus technology
  Quiero registrar el formulario de novus technology
  Para poder practicar lo que aprendi

  @Prueba
  Scenario: Se registra el formulario de Novus Technology con datos válidos
    Given que ingreso a la web de Novus Technology
    When Ingreso el nombre
    And Ingreso el apellido
    And ingreso el pasatiempo
    And ingreso el genero
    And ingreso el telefono
    And ingreso el correo
    And selecciono el departamento
    And selecciono la ciudad
    And selecciono el tipo de comando
    And ingreso un documento
    And doy click en enviar
    Then se muestra un pop up con el mensaje
    #And valido que el nombre sea el mismo que se ingreso en el formulario
    #And valido que el apellido sea el mismo que se ingreso en el formulario
    And doy click en close

  @Prueba2
  Scenario: Se registra el formulario de Novus Technology con datos válidos
    Given que ingreso a la web de Novus Technology
    When ingreso los datos del formulario
    And doy click en enviar
    Then se muestra un pop up con el mensaje
    And doy click en close

  @Prueba3
  Scenario: Se valida datos desde el escenario
    Given que ingreso a la web de Novus Technology
    When ingreso el datos en nombre de "Georgiana"
    And ingreso el datos en apellido de "Paz Villavicencio"
    And ingreso el pasatiempo "musica"
      #And ingreso el pasatiempo "musica" y "lectura"
    And doy en el genero "masculino"
    And ingreso el dato de telefono "1234567890"
    And ingreso el datos de correo "jpaz@test.com"
    And selecciono el departamento "LIMA"
    And selecciono la ciudad "LIMA"
    And selecciono "WebElement Commands"
    And ingreso un documento desde la ruta "/Users/jorgepazdiaz/Downloads/Formulario de solicitud de gastos.pdf"
    And doy click en enviar
    Then se muestra un pop up con el mensaje
    And valido que el nombre sea el mismo que se ingreso al inicio
    And valido que el apellido sea el mismo que se ingreso al inicio
    And doy click en close

  @Prueba4
  Scenario: 004 - Un alumno ingresa los datos al formulario
    Given que ingreso a la web de Novus Technology
    When Ingreso datos del usuario
      | nombre | apellido | pasatiempo | genero    | telefono | correo        | departamento | ciudad | ruta                                                                | comando         |
      | Jorge  | Paz      | deporte    | Masculino | 55555555 | jpaz@test.com | LIMA         | LIMA   | /Users/jorgepazdiaz/Downloads/Formulario de solicitud de gastos.pdf | Switch Commands |
    And doy click en enviar
    Then se muestra un pop up con el mensaje
    And valido los datos
      | nombre | apellido |
      | Jorge  | Paz      |
    And doy click en close


  @Prueba5
  Scenario Outline: Se valida datos desde el escenario
    Given que ingreso a la web de Novus Technology
    When ingreso el datos en nombre de "<nombre>"
    And ingreso el datos en apellido de "<apellido>"
    And ingreso el pasatiempo "<pasatiempo>"
    And doy en el genero "<genero>"
    And ingreso el dato de telefono "<telefono>"
    And ingreso el datos de correo "<correo>"
    And selecciono el departamento "<departamento>"
    And selecciono la ciudad "<ciudad>"
    And selecciono "<comando>"
    And ingreso un documento desde la ruta "<ruta>"
    And doy click en enviar
    Then se muestra un pop up con el mensaje
    And valido que el nombre sea el mismo que se ingreso al inicio
    And valido que el apellido sea el mismo que se ingreso al inicio
    And doy click en close
    Examples:
      | nombre    | apellido   | pasatiempo | genero    | telefono   | correo               | departamento | ciudad | comando             | ruta                                                                |
      | Georgiana | Paz        | musica     | femenino  | 1234567890 | jpaz@test.com        | LIMA         | LIMA   | Switch Commands     | /Users/jorgepazdiaz/Downloads/Formulario de solicitud de gastos.pdf |
      | Bryan     | Villegas   | deporte    | masculino | 1234567890 | bvillegas@test.com   | PIURA        | PIURA  | Browser Commands    | /Users/jorgepazdiaz/Downloads/Formulario de solicitud de gastos.pdf |
      | Evelyn    | Francisco  | lectura    | femenino  | 1234567890 | efrancisco@test.com  | LIMA         | CAÑETE | Navigation Commands | /Users/jorgepazdiaz/Downloads/Formulario de solicitud de gastos.pdf |
      | Fernando  | Cuadros    | deporte    | masculino | 1234567890 | fcuadroz@test.com    | LIMA         | LIMA   | Switch Commands     | /Users/jorgepazdiaz/Downloads/Formulario de solicitud de gastos.pdf |
      | Pedro     | Rodriguez  | musica     | masculino | 1234567890 | prodriguez@test.com  | LIMA         | LIMA   | Wait Commands       | /Users/jorgepazdiaz/Downloads/Formulario de solicitud de gastos.pdf |
      | Karola    | Hinostroza | lectura    | femenino  | 1234567890 | khinostroza@test.com | LIMA         | LIMA   | WebElement Commands | /Users/jorgepazdiaz/Downloads/Formulario de solicitud de gastos.pdf |


    @Prueba6
    Scenario: Probar con carga desde CSV
      Given que ingreso a la web de Novus Technology
      When ingreso los datos del formulario desde el archivo csv
      Then se procesan correctamente todos los registros del csv
