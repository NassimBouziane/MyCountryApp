import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@ExperimentalCoroutinesApi
class CountriesViewModel : ViewModel() {
    private val _states = MutableStateFlow(CountryState.Loading)
    val states: StateFlow<CountryState>
        get() = _states

    init {
        viewModelScope.launch {
            try {
                val countries = getCountries()
                _states.value = CountryState.Success(countries)
            } catch (e: Exception) {
                _states.value = CountryState.Error(e.message ?: "Unknown error")
            }
        }
    }

    private suspend fun getCountries(): List<Country> {
        return withContext(Dispatchers.IO) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://restcountries.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val api = retrofit.create(CountriesApi::class.java)
            api.getAllCountries().await().map { it.name }
        }
    }
}

sealed class CountryState {
    object Loading : CountryState()
    data class Success(val countries: List<Country>) : CountryState()
    data class Error(val message: String) : CountryState()
}

data class Country(val name: String)

interface CountriesApi {
    @GET("all")
    fun getAllCountries(): Deferred<List<Country>>
}
