Android Proficiency Exercise

Specification

1. This App Ingests a json feed from https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json
 The feed contains a title and a list of rows.
 Third party apis such as Retrofit, Gson and Picasso are used
2. The content is displayed (including image, title and description) in a ListView
 The title in the ActionBar is updated from the json data.
 Each row should is dynamically sized to the right height to display its content - no clipping, no
extraneous white-space etc. This means some rows will are larger than others.
3. Loaded the images lazily (Used Picasso library for that).
4. Implemented pull to refresh function allowing the data & view to be updated
5. Non blocking UI while the data is being loaded.
