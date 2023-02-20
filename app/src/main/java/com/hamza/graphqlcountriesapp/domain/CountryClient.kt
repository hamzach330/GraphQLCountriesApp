package com.hamza.graphqlcountriesapp.domain

import com.hamza.CountryQuery

/**+
 * Define abstract Function To interact with the graphQL APIs
 */
interface CountryClient {

    /**+
     * In the code below the CountryQuery.Country Data is auto generated from GraphQl Library.
     * For making the code consistant and for achieving the complete control on dataclasses I will define my own Dataclass.
     */

    //suspend fun getCountries() : List<CountryQuery.Country>


    /**+
     * @return list of countries with minimal information
     */
    suspend fun getCountries(): List<SimpleCountry>

    /**+
     * @param countryCode for the required country
     * @return the details of the required country
     * it could be possible that detailed country could be nullabe thats why added ?
     */
    suspend fun getDetailedCountry(countryCode: String): DetailedCountry?


}