class Reserva(
    val idReserva: Int,
    val idHuesped: Int,
    val nombreHuesped: String,
    val emailHuesped: String,
    val numHabitacion: Int,
    val tipoHabitacion: String,
    val precioXNoche: Int,
    val cantidadNochesReserva: Int
){
    fun calcularMontoTotal(): Int{
        return precioXNoche * cantidadNochesReserva

    }

}