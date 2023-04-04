package com.example.enidemo.api

import com.squareup.moshi.Json

// joke récupéré sur https://api.chucknorris.io/jokes/random?category={category}
// joke nommé "value" dans le Json envoyé par l'API
class Joke(@Json(name="value") val value: String) {

}