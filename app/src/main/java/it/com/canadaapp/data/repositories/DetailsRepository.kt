


class DetailsRepository(
    private val api: ConnectionApi
) : SafeApiRequest() {

    suspend fun getDetails() = apiRequest { api.getDetails() }

}