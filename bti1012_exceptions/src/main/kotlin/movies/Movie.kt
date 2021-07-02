package movies

data class Movie(val id: String = "xx", val title: String = "No name", val country: String = "unknown", val year: Int = 0) {
    override fun toString() = "$id\t$title\t$country\t$year\n"
}