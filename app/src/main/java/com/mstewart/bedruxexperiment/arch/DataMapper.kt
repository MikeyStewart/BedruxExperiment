package com.mstewart.bedruxexperiment.arch

import org.json.JSONArray
import org.json.JSONObject

/***
 * Maps a JSON representation of the app to the data required to render the app.
 */
fun mapJsonToScreens(input: String): List<ViewData> {
    val screens = JSONArray(input)

    return mutableListOf<ViewData>().apply {
        for (i in 0 until screens.length()) {
            val screenData = buildViewData(screens.getJSONObject(i))
            add(screenData)
        }
    }
}

fun buildViewData(screenJSON: JSONObject): ViewData {
    return ViewData(
        content = mutableListOf<Pair<String, Any>>().apply {
            screenJSON.keys().forEach {
                when (val value = screenJSON.get(it)) {
                    is JSONObject -> {
                        add(Pair(it, buildViewData(value).content))
                    }
                    is JSONArray -> {
                        add(Pair(it, mutableListOf<Any>().apply {
                            for (i in 0 until value.length()) {
                                add(value.get(i))
                            }
                        }))
                    }
                    else -> {
                        add(Pair(it, screenJSON.get(it)))
                    }
                }
            }
        })
}

const val dummyData: String =
    """
[
  {
    "name": "Home",
    "header": "Home title",
    "body": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. Vel fringilla est ullamcorper eget nulla facilisi etiam dignissim. In cursus turpis massa tincidunt dui. In fermentum posuere urna nec tincidunt praesent semper. Sit amet est placerat in egestas erat imperdiet sed euismod. Volutpat consequat mauris nunc congue. Pellentesque habitant morbi tristique senectus et netus. Blandit libero volutpat sed cras ornare arcu. Mollis nunc sed id semper risus. Porttitor lacus luctus accumsan tortor posuere ac ut. Felis donec et odio pellentesque diam volutpat commodo. Penatibus et magnis dis parturient montes nascetur ridiculus.",
    "carousel": {
      "title": "Dog breeds",
      "items": [
        "https://www.akc.org/wp-content/uploads/2017/11/American-Leopard-Hound-On-White-01.jpg",
        "https://www.akc.org/wp-content/uploads/2017/11/Longhaired-Dachshund-standing-outdoors.jpg",
        "https://www.akc.org/wp-content/uploads/2017/11/Dogue-de-Bordeaux-On-White-03.jpg",
        "https://www.akc.org/wp-content/uploads/2017/11/Kuvasz-standing-outdoors.jpg",
        "https://www.akc.org/wp-content/uploads/2017/11/Keeshond-exploring-in-the-backyard.jpg",
        "https://www.akc.org/wp-content/uploads/2017/11/Norfolk-Terrier-sitting-in-the-grass.1.jpg"
      ]
    },
    "button": {
      "text": "Press me!",
      "colour": "#e28743"
    }
  },
  {
    "name": "Search",
    "header": "What are you looking for?",
    "button": {
      "text": "Run search",
      "colour": "#DE5053"
    }
  }
]
    """