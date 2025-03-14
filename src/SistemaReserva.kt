class SistemaReserva {

    private val reservas = mutableListOf<Reserva>()
    private var idSiguiente = 1

    fun registrarReserva(idHuesped: Int, nombreHuesped: String, emailHuesped: String, numeroHabitacion: Int, tipoHabitacion: String, precioXNoche: Int, cantidadNoches: Int):Boolean{
        fun habitacionOcupada(numeroHabitacion: Int):Boolean{
            return reservas.any { it.numHabitacion == numeroHabitacion }
        }
        if (habitacionOcupada(numeroHabitacion)) {
            println("ERROR ❌, la habitacion: $numeroHabitacion ya ha sido reservada")
            return false
        }
        val nuevaReserva = Reserva(idSiguiente, idHuesped, nombreHuesped, emailHuesped, numeroHabitacion, tipoHabitacion, precioXNoche, cantidadNoches)
        reservas.add(nuevaReserva)
        idSiguiente++
        println("la habitacion ha sido reservada con exito ✅. Id de la reserva: ${nuevaReserva.idReserva}")
        return true
    }
    fun cancelarReserva(idReserva: Int):Boolean{
        val reservaEncontrada = reservas.find { it.idReserva == idReserva }
        if(reservaEncontrada != null){
            reservas.remove(reservaEncontrada)
            println("La reserva con id: $idReserva ha sido cancelada con exito ✅")
            return true
        }
        println("No se encontro ninguna reserva con el id: $idReserva")
        return false
    }
    fun mostrarReservasActivas(){
        if (reservas.isEmpty()){
            println("No hay reservas activas en este momento")
            return
        }
        println("RESERVAS ACTIVAS")
        reservas.forEach { reserva ->
            println("Id de la reserva: ${reserva.idReserva}")
            println("Nombre del huesped: ${reserva.nombreHuesped} ID: ${reserva.idHuesped}")
            println("Email del huesped: ${reserva.emailHuesped}")
            println("Habitacion reservada numero: ${reserva.numHabitacion} Tipo de habitacion: ${reserva.tipoHabitacion}")
            println("Precio por noche: $${reserva.precioXNoche}")
            println("Noches Reservadas: ${reserva.cantidadNochesReserva}")
            println("Monto total: ${reserva.calcularMontoTotal()}")
        }
    }
}