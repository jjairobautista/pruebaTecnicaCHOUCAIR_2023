#language: es

Característica:  Agregar productos al carrito e compras
  como usuario requiero la validacion del carrito de compras al agregar productos


  Escenario:  Agregar productos
    Dado :Que el usuario ingrese a la platafroma y elija categoria y subcategoria
    Cuando : Agregar productos aleatorios y cantidades aleatorias
    Entonces : Validar carrito de compras