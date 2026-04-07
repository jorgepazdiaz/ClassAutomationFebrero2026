Feature: Comprar con el carrito de compras

  @Funcionalidad1
    Scenario: El usuario agrega productos y realiza una compra
    Given el usuario ingresa a la pagina de productos
    When el usuario obtiene el numero de tajeta
    And el usuario obtiene el numero de CVV
    And el mes y año de vencimiento
    And el usuario agrega un productos
    And da click en comprar
    And ingresa el numero de tarjeta
    And ingresa el numero de CVV
    And ingresa el mes y año de vencimiento
    And dar click en comprar
    Then visualiza un mensaje de compra exitosa
      And el numero de orden de compra
    And da click en home

    #Trabajo Final del Proyecto de Automatizacion de Pruebas con Selenium WebDriver y Cucumber
    #1. crear un scenario de forma declarativa en el archivo .feature
    #2. crear un scenario que envie los datos de numero de compra desde el feature.
    #3. crear un scenario usando DataTable en el archivo .feature
    #4. crear un scenario usando Scenario Outline con varios ejemplos en el archivo .feature
    #5 crear un scenario usando tags en el archivo .feature que carga informacion desde un archivo .csv
    #6. agregar pagos en el escenario usar Assert y validaciones de los datos de tarjeta y compra en el check credit card limit