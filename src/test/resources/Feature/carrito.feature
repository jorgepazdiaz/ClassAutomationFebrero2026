Feature: Comprar con el carrito de compras

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