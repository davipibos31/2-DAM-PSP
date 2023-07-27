


class Motocicleta(marca: String, modelo: String, color: String, numeroPlazas: Int) : Vehiculo(marca, modelo, color) {
    var numeroPlazas: Int = 0
    var tieneMaletero: Boolean = true

    init {
        this.numeroPlazas = numeroPlazas
        this.tieneMaletero = true
    }

    constructor(marca: String, modelo: String, color: String, numeroPlazas: Int, tieneMaletero: Boolean)
            : this(marca, modelo, color, numeroPlazas) {

        this.tieneMaletero = tieneMaletero

    }
}