package com.hamza.graphqlcountriesapp.domain

import com.hamza.CountriesQuery
import com.hamza.CountryQuery

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        name = name,
        code = code,
        capital = capital ?: "No capital",
        emoji = emoji,
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = code

    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        name = name,
        code = code,
        capital = capital ?: "No capital",
        emoji = emoji,
    )
}