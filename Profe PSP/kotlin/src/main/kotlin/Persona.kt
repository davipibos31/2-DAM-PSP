open class Persona(nombre: String, apellido: String) {
    var nombre: String = ""
        get() {
            return if (field.isEmpty()) "Sin nombre" else field
        }
        set(value) {
            field = if (value.isEmpty()) "Sin nombre" else value
        }
    var apellido: String = ""
    var edad: Int = 0

    init {
        this.nombre = nombre
        this.apellido = apellido
        this.edad = 0
    }

    fun printNombre() = "Mi nombre es $nombre $apellido"

}