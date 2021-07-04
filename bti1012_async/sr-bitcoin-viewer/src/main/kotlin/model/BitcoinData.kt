package model

data class BitcoinData(val time: TimeStamps, val disclaimer: String, val chartName: String, val bpi: Bpi) {
    override fun toString(): String {
        return "Rates on ${time.updated}: ${bpi.EUR.rate_float} ${bpi.EUR.code}" + ", ${bpi.GBP.rate_float} ${bpi.GBP.code}, ${bpi.USD.rate_float} ${bpi.USD.code}"
    }
}