# Android Mini Project

### Table of Contents
Section headers will be used to reference location of destination

- [Description](#description)
- [Approach](#approach)
- [How To Use](#how-to-use)
- [Show Case](#showcase)


## Description

Android project that aims to simulate a Weather App which when built will show a list of weather data retrieved using the [OpenWeather API](https://openweathermap.org/api) representing a five day weather forecast for the city of Cape Town. The implementation of the project uses the [MVVM](https://developer.android.com/jetpack/guide#recommended-app-arch) architectural pattern to separate app logic into different sections to allow for separation of concern further allowing the project to be easily maintained and scalable.

## Approach 

The weather data retrieved from the [OpenWeather API](https://openweathermap.org/api) is stored in a **Room** database used as a single source of truth where the data source is decided in a **Repository** which has the logic for calling the api and storing the data in the database based on whether the api call resulted in a success or not and always has the database as the data source for the app. The app uses a single **Activity** architecture with 2 fragments, one for the Overview Screen showing the weather data in a vertical list using a **RecyclerView** and a Detail Screen which is a detailed view for a selected weather item on the weather forecast list. Each **Fragment** has a **ViewModel** and each view model has **ViewModelFactory** which knows how to create an instance of these view models as they each take custom parameters. Unit tests for the ViewModels are also included in the project.

---

#### Technologies

- Android Architectural Components
- [Retrofit library](https://square.github.io/retrofit/)
- [Room library](https://developer.android.com/training/data-storage/room)
- Coroutines

---


## How To Use

Install the latest build of Android Studio, import the project then build.

#### Showcase

- [OpenWeather App Demo](https://drive.google.com/file/d/1cH6oghJU34sj2VMUlulKml_gY5gxYuiz/view?usp=sharing)

