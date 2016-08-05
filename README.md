https://github.com/triveous/vodafone

# AndroidTraining
Android Training programe
- Ninja Mock
- Wear
- TV
- butterknief
- Android TV
- Glass
- Change Scrum Application Version Android 23 API to Lower Version
- SVG
- Vysar Chrome Plug in
- Sketch Tool (MAC), Adobe comets, 
- pipete studio
- pop prototyping
-zeplin
- invensionapp - prototype
- marvelapp
- RX -W/S call in loop
- Retrofit - -W/S call in loop
- Picaso android api
- Glide
	- REcycler view
	- CenterCrap with percentage view
- keypromoter 

- Step to install Git hub
install git hub desktop from net i.e. https://desktop.github.com	
---Git Hub
C:\Users\admin\AppData\Local\GitHub\PortableGit_624c8416ee51e205b3f892d1d904e06e6f3c57c8\cmd\git.exe init
- inside folder where all source code is kept
C:\Users\admin\AppData\Local\GitHub\PortableGit_624c8416ee51e205b3f892d1d904e06e6f3c57c8\cmd\git.exe add .
C:\Users\admin\AppData\Local\GitHub\PortableGit_624c8416ee51e205b3f892d1d904e06e6f3c57c8\cmd\git.exe commit -m "first commit"
C:\Users\admin\AppData\Local\GitHub\PortableGit_624c8416ee51e205b3f892d1d904e06e6f3c57c8\cmd\git.exe remote add origin https://github.com/shdhumale/AndroidTraining.git
C:\Users\admin\AppData\Local\GitHub\PortableGit_624c8416ee51e205b3f892d1d904e06e6f3c57c8\cmd\git.exe push -u origin master


- Universal Image Loader
- google tool box
- newsapi.org
- https://github.com/triveous/vodafone
- https://gist.github.com/s0h4m/00da1fac9059bf405e2b33e40c44e8e4

======

1- Create an adapter
2- Create viewHolder inside adapter
3- make the adapter of type viewholder
4- create the constructor and the local list
5- implement the 3 methods
6- use glide in onBindViewHolder (add dependency)
7- in MainActivity add a layout mananger for the recycleView
8- set adapter to teh RecycleView
9- add internet permission to the manifest

- Adding handler to card
1- Create Activity
2- Override onCreate
3- Design Layout with WebView
4- Mention in menifest
5- use setcontentview in DetailsActivity
6- add id to cardview
7- update adapter: viewholder
8- add an onclicklistener in onBindViewHolder
9.show toast with position

==========
things to do

In the details activity get the position from the intent
Based on the position get the NewsObject at that position
Based on the news object a) change the title of the activity b) load the url (you have to initialize the webview)
Create a horizontal progress bar in the details activity
Show/Hide the progress bar when the page starts loading/finishes loading
Implement "up functionality" in your details activity so that when you click on "up", you go back to the previous screen



------Day 3
1- Get the response from newsapi
2- Make sure it is valid (jsonparseronline or other parsing tools): http://www.jsoneditoronline.org/
3- Go to jsonschematopojo: http://www.jsonschema2pojo.org/
4- Paste the response (valid)
5- Change the source type to json
6- Give the correct packagename
7- Give the correct class name (any class name)
8- Change the annotation style to gson
9- Download and extract the zip file
9- Copy the files to the object package
10- Include the gson dependency: compile 'com.google.code.gson:gson:2.7'
11- Remove the generated annotation as well as the generated import to remove all errors


http://square.github.io/retrofit/
https://android-arsenal.com/


--- Day 3 retrofit

Add the following to build.gradle
```
    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'
```
Create a networking package
Create a NewsAPI class inside the networking package
Define the API_KEY and BASE_URL as constants
Define an interface: NewsAPIInterface
Create a method for each endpoint, pass source and sortBy as query parameters
Annotate it with GET with the particular endpoint url along with the KEY
define a static NewsAPIInterface object
Create a static getNewsAPI method which will help us in accessing the singleton
in case the NewsAPIInterface is null, create an instance of Retrofit with a) the basurl b) the gson converter
create an instance of the newsapiinterface
In MainActivity, use NewsAPI.getNewsAPI().getArticles to get Call
use call.enqueue to get a callback for the network response
in the onResponse callback, use response.body() to get the NewsApiArticleResponse object
Use breakpoints/debugging to verify the response