

class Coche (marca: String, modelo: String, color: String,numeroP: Int, numeroPlazas: Int)
    : Vehiculo(marca, modelo, color) {
    var numeroPuertas: Int = 0
    var numeroPlazas: Int = 0

    init {
        this.numeroPuertas = numeroP
        this.numeroPlazas = numeroPlazas
    }
}