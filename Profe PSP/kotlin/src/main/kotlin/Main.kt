

fun main(args: Array<String>) {
    var persona: Conductor = Conductor("Nombre", "apellido")
    var persona2: Conductor = Conductor("Nombre", "apellido","B")
    persona.permiso = ""
    println(persona.printNombre())
    persona2.printNombres()

    var listPersona = mutableListOf<kotlin.Any>()
    listPersona.add(Conductor("",""))
    listPersona.add("")
}