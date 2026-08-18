package com.example.newtest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newtest.ui.theme.NewTestTheme

//Tarea 10. Declaracion e implementacion de interfaces en android
interface MiInterfazOperaciones{
    fun ejecutarTareaInicial()
    fun procesarResultado(codigo: Int)
}

class MainActivity : ComponentActivity(), MiInterfazOperaciones {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }

            //EJERCICIOS DEL 1 AL 8
            Ejecutando1al8()

            //EJERCICIO 9
            var auto = CocheDeportivo("Ferrari", 2)
            auto.acelerar()

            //EJERCICIO 10
            ejecutarTareaInicial()
            procesarResultado(10)
        }
    }

    override fun ejecutarTareaInicial() {
        Log.i("Android Studio", "Tarea inicial de la interfaz ejecutada con exito")
    }

    override fun procesarResultado(codigo: Int) {
        Log.i("Android Studio", "Resultado procesado. Codigo de estado: $codigo")
    }
}

fun Ejecutando1al8(){
    Tarea1()
    Tarea2()
    Tarea3()
    Tarea4()
    Tarea5(10)
    Tarea6(10, "Es un string")
    Tarea7()
    Tarea8()
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewTestTheme {
        Greeting("Android")
    }
}

//1. Declaracion de variables, constantes y concatenacion
fun Tarea1(){

    val nombre: String = "Aristides"
    var edad: Int = 24
    val activo: Boolean = true

    edad = 25

    Log.i("Ejemplo1","Me llamo $nombre y tengo $edad años. Estado activo: $activo")
}

//2. Operaciones aritmeticas y convesion de tipos (Cast)
fun Tarea2(){
    val numero1:Int = 20
    val numero2:Float = 8.4f

    val resultadoSuma = numero1 + numero2.toInt()

    val resta = numero1 - 5
    val multiplicacion = numero1 * 2
    val division = numero1 / 4
    val modulo = numero1 % 3 //Resto de la division

    println("Suma con casteo: $resultadoSuma")
    println("Resta: $resta | Multiplicacion: $multiplicacion")
    println("Division: $division | Modulo: $modulo")
}

//3. Manejo de array y listas (Inmutable y Mutable) con filtro
fun Tarea3(){

    val mesesArray = arrayOf("Enero","Febrero","Marzo","Abril")
    mesesArray[0] = "Mes de cumpleaños" //modificaciones permitidas

    val mesesLista = listOf("Enero","Febrero","Marzo","Abrir","Mayo","Junio")

    val mesesLargos = mesesLista.filter { it.length>5 }
    println("Meses con mas de 5 letras: $mesesLargos")

    val listaCompras : MutableList<String> = mutableListOf()

    listaCompras.add("Potatoes")
    listaCompras.add("Beers")
    listaCompras.add("Bread")

    listaCompras.add(0,"salad")

    println("Lista de compras actual: $listaCompras")
}

//4. Funciones con parametros de entrada y salida
fun Tarea4() {
    MostrarDatosUsuario("Florangel","21")
    FormatearNombre("Flor")
    ObtenerSaludoCorto("Hola, como esta?")
}

fun MostrarDatosUsuario(name: String, age: String){
    println("Me llamo $name y tengo $age años")
}

fun FormatearNombre(name: String) :  String {
    val miNombreFormateado = "Me llamo $name"

    return miNombreFormateado
}

fun ObtenerSaludoCorto(name: String) : String = "Hola de nuevo, $name"


//5. Estructuras De Control Condicional(if-else anidados)
fun Tarea5(number: Int){
    if(number>10 && number < 50){
        println("$number esta entre 11 y 49")
    }
    else if(number<10 || number>50){
        println("$number es menor que 10 o mayor que 50")
    }
    else{
        println("$number es exactamente 10 o 50")
    }
}

//6.Control de flujo avanzado con la estructura when
fun Tarea6(month: Int, objetivoCualquiera: Any){

    when(month){
        in 1..3 -> println("Primer trimestre del año")
        in 4..6 -> println("Segundo trimestre del año")
        in 7..12 -> println("Tercero semestre del año")
        else -> println("No es un mes valido")
    }

    val resultadoTipo: String = when (objetivoCualquiera){
        is Int -> "Es una variable de tipo Int"
        is String -> "Es una variable de tipo String"
        is Boolean -> "Es una variable de tipo Boolean"
        else -> "Es otro tipo de variable"
    }

    println(resultadoTipo)
}

//7. EstructurasIterativas(Bucle for y do while)
fun Tarea7(){
    val meses = listOf("Enero", "Febrero","Marzo", "Abril")

    for((posicion, Valor) in meses.withIndex()){
        println("La posicion $posicion contiene el valor $Valor")
    }

    var contador = 1
    do{
        println("El contador actual va por: $contador")
        contador++
    }while (contador<=5)

}

//8. Manejo Seguro de Nulos(null safety y Operador Elvis)
fun Tarea8(){
    var apellidos: String? = "Aris"
    apellidos = null //Es valido

    val longitudSegura: Int? = apellidos?.length
    println("Longitud segura o nula: $longitudSegura")

    val longitudConDefault: Int = apellidos?.length?: -1
    println("Longitud controlada con Elvis: $longitudConDefault")
}


//9. Clase de objetos, data clases y herencia

//1. Definicion de una data clases (autogenera toString, equals(), copy())
data class CarroContenedor(val model: String, val Power: Int)

//2.Clase base  marcada como 'open' para permitir que otras hereden de ella
open class vehiculo(val model:String){
    open fun acelerar(){
        println("El vehiculo base esta accelerando")
    }
}

//3.Subclase que hereda de vehiculo y sobreescribe un  metodo usando 'Override'
class CocheDeportivo(model:String, val asientos: Int) : vehiculo(model){
    override fun acelerar(){
        super.acelerar() //ejecuta el comportamiento del padre
        println("El coche deportvo $model con $asientos asientos acelera a gran velocidad!")
    }
}
