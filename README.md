# Rick & Morty Browsing Characters Application
Android application for browsing Rick &amp; Morty's TV show characters 

## Dependencies

- Retrofit -  HTTP client for Android and Java used for connecting to REST web services by transforming JSON into Java.
- GSON - part of Retrofit library, used for translating JSON data
- RecyclerView - Enhanced version of ListView library.
- ViewModel - library for preparing and sharing UI data throughout the activities and fragments.
- Glide - image loading library used for fetching and displaying images with simple implementation.
- Paging - library for part-loading and displaying small amount of data at a time with less bandwidth.

## About app

This app is developed as part of the job interview assignment. It uses Rick & Morty's API: https://rickandmortyapi.com/api/ for fetching all character informations and displaying it as a scrollable card list. The application is compiled with latest Android version and supported from KitKat (API 19).

## Methods

#### Rertrofit
- getApi() - method for invoking GET API call with the endpoint.
- getInstance() - method for creating single RetrofitClient object.

#### AlertDialog
- showInfoDialog() - method for showing an alert dialog with character details.
- setInfoText() - method for setting TextView texts from API call results.
- checkType() - method which check if type of character exist.

#### DataSource
- getCharacterLiveDataSource() - method for retrieving live data source.

#### InternetCheck
- accept() - method for returning boolean info whether the device is connected to internet by pinging Google's public DNS.

#### MainActivity
- initList() - method that initialize RecyclerView and fill it with data from the API.

## Other tools
http://www.jsonschema2pojo.org/ for creating Java classes based on JSON schema
