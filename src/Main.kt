

fun main() {
    val sistema = SistemaReserva()
    var opcion: Int = -1

    while (opcion != 0) {
        println("SISTEMA DE RESERVAS DE HABITACIONES DEL HOREL ")
        println("1. Registrar una nueva reserva.")
        println("2. Cancelar una reserva.")
        println("3. Mostrar las reservas activas.")
        println("4. Salir")

        println("Ingrese una opcion: ")
        opcion = readln()?.toIntOrNull() ?: -1

        when(opcion){
            1 -> registrarReserva(sistema)
            2 -> cancelarReserva(sistema)
            3 -> sistema.mostrarReservasActivas()
            4 -> println("GRACIAS POR USAR EL SISTEMA, VIELVA PRONTO")
            else -> "Opcion invalida, ingrese un numero valido"
        }
    }
    fun registrarNuevaReserva(sistema: SistemaReserva) {
        println("\n=== REGISTRAR NUEVA RESERVA ===")

        print("ID del huésped: ")
        val idHuesped = readLine()?.toIntOrNull() ?: return println("Error: ID inválido.")

        print("Nombre del huésped: ")
        val nombreHuesped = readLine()?.takeIf { it.isNotBlank() } ?: return println("Error: Nombre inválido.")

        print("Email del huésped: ")
        val emailHuesped = readLine()?.takeIf { it.contains("@") } ?: return println("Error: Email inválido.")

        print("Número de habitación: ")
        val numeroHabitacion = readLine()?.toIntOrNull() ?: return println("Error: Número de habitación inválido.")

        print("Tipo de habitación: ")
        val tipoHabitacion = readLine()?.takeIf { it.isNotBlank() } ?: return println("Error: Tipo de habitación inválido.")

        print("Precio por noche: ")
        val precioXNoche = readLine()?.toDoubleOrNull() ?: return println("Error: Precio inválido.")

        print("Cantidad de noches: ")
        val cantidadNoches = readLine()?.toIntOrNull() ?: return println("Error: Cantidad de noches inválida.")

        val resultado = sistema.registrarReserva(
            idHuesped,
            nombreHuesped,
            emailHuesped,
            numeroHabitacion,
            tipoHabitacion,
            precioXNoche,
            cantidadNoches
        )

        if (resultado) println("Reserva creada exitosamente.") else println("No se pudo realizar la reserva.")
    }
    fun cancelarReservaExistente(sistema: SistemaReserva) {
        println("\n=== CANCELAR RESERVA ===")
        print("Ingrese el ID de la reserva a cancelar: ")

        val idReserva = readLine()?.toIntOrNull() ?: return println("Error: ID de reserva inválido.")

        if (sistema.cancelarReserva(idReserva)) {
            println("Reserva cancelada con éxito.")
        } else {
            println("No se encontró una reserva con ese ID.")
        }
    }


}