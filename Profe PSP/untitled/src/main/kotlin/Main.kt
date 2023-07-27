fun main(args: Array<String>) {

    val setOfItems = mutableSetOf<Vehiculo>()
    var motoInit = Motocicleta("sgdfg", "", "dgdfgdf", 4)

    setOfItems.add(motoInit)
    setOfItems.add(Motocicleta("sgdfg", "", "dgdfgdf", 4, false))


    setOfItems.forEach {
        print("Vehiculo ${it.matricula} ${motoInit.getNumMatricula()} ${it.modelo} ${it.color} ${it.marca}")
        when (it) {
            is Motocicleta ->  println(" Motocicleta ${it.numeroPlazas} ${it.tieneMaletero}")
            is Coche ->  println(" coche ${it.numeroPlazas} ${it.numeroPuertas}")
        }
    }

    print("Vehiculo ${motoInit.matricula} ${motoInit.getNumMatricula()}")
    /*var nombreUsuario = MiObject.usuario
    var nombreUsuario2 = MiObject.usuario
    var nombreUsuario3 = MiObject.usuario
    var nombreUsuario4 = MiObject.usuario
    println(nombreUsuario)
    println(nombreUsuario2)
    println(nombreUsuario3)
    println(nombreUsuario4)

    MiObject.funcionDeMiObjeto()*/

}
