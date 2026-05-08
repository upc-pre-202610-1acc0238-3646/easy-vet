package pe.edu.upc.easyvet.home.data.repository

sealed class Resource {
    data object Success : Resource()
    data class Error(val message: String) : Resource()
}