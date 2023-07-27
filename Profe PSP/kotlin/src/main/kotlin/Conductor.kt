

class Conductor(nombre: String, apellido: String, permiso: String)
    : Persona(nombre, apellido) {
    var permiso: String = ""
        get() {
            return "Permiso: $field"
        }
        set(value) {
            field = if (value.isEmpty()) "Sin Permiso" else value
        }
    init {
        this.permiso = permiso
    }

   constructor(nombre: String, apellido: String)
           : this(nombre, apellido,""){

   }


}