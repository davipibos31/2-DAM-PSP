open class Vehiculo(marca: String, modelo: String, color: String) {
    var marca: String = ""
        set(value) {
            if (value.isEmpty()) {
                field = "EMPTY"
            } else {
                field = value
            }
        }
        get() {
            if (field.isEmpty()) {
                return "EMPTY"
            } else {
                return field
            }
        }
    var modelo: String = ""
        set(value) {
            if (value.isEmpty()) {
                field = "EMPTY"
            } else {
                field = value
            }
        }
        get() {
            if (field.isEmpty()) {
                return "EMPTY"
            } else {
                return field
            }
        }
    var color: String = ""
        set(value) {
            if (value.isEmpty()) {
                field = "EMPTY"
            } else {
                field = value
            }
        }
        get() {
            if (field.isEmpty()) {
                return "EMPTY"
            } else {
                return field
            }
        }
    var matricula: Int = 0 //TODO lateinit

    init {
        this.marca = marca
        this.modelo = modelo
        this.color = color
        contador++
        this.matricula = contador
    }
    fun getNumMatricula(): Int {
        return contador
    }

    companion object {
        var contador: Int = 0

        init {
            println("INIT Vehiculo Companion object")
        }
    }
}