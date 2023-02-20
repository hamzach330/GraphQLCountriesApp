package com.hamza.graphqlcountriesapp.data

import com.apollographql.apollo3.ApolloClient
import com.hamza.CountriesQuery
import com.hamza.CountryQuery
import com.hamza.graphqlcountriesapp.domain.*

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getDetailedCountry(countryCode: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(countryCode))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }

}