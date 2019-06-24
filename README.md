# Rick & Morty Browsing Characters Application
Android application for browsing Rick &amp; Morty's TV show characters 

## Dependencies

- Retrofit -  HTTP client for Android and Java used for connecting to REST web services by transforming JSON into Java.
- GSON - part of Retrofit library, used for translating JSON data
- RecyclerView - Enchanced version of ListView library.
- ViewModel - library for preparing and sharing UI data throughout activities and fragments.
- Glide - image loading library used for fetching and displaying images with simple implementation.
- Paging - library for partialy loading and displaying small amount of data at a time with less bandwidth.

## About app

This app is developed as part of job interview assigment. It uses Rick & Morty's API: https://rickandmortyapi.com/api/character/ for fetching all characters informations and displaying it as scrollable card list

## Methods

#### Rertrofit
- getApi() - method for invoking GET API call with endpoint.
- getInstance() - method for creating single RetrofitClient object.

#### Paging Adapter
- getInfoDialog() - method for showing alert dialog with character details.
- setInfoText() - method for setting TextView texts from API call results.

#### DataSource
- getCharacterLiveDataSource() - method for retrieving live data source.

## Other tools
http://www.jsonschema2pojo.org/ for creating Java classes based on JSON schema
