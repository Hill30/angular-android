Angular Android
===============
This project is built as a proof of concept for the android application using html/css/javascript ([angular](angularjs.org)] for UI logic. The overall application architecture follows the MVC paradigm.
The application itself consists of a single Activity called MainActivity hosting a  [webView](http://developer.android.com/reference/android/webkit/WebView.html) and a MVCControlllers class. 

The UI part of the application is implemented as a self contained angular based single page application and is located in the `./Angular Android/src/main/assets/application` subdirectory. 

The code in the MainActivity provides hook up necessary to intercept the web api requests coming from the angular application and respond to them from the android application code. The most straight forward way to intercept http requests would be using [shouldInterceptRequest](http://developer.android.com/reference/android/webkit/WebViewClient.html#shouldInterceptRequest(android.webkit.WebView, java.lang.String)) method of the WebViewClient class. Unfortunately this method was only introduced in the API level 11.

So to support older devices (Android 2.3.*) Java object injection was chosen as the mechanism for the http interception. The actual interception is based on the angular dependency injection architecture and is done by injecting custom implementation of the $httpBackendProvider ([see application.js](https://github.com/Hill30/angular-android/blob/master/Angular%20Android/src/main/assets/application/scripts/application.js)).

The application provides examples of both pull requests (see web api implementation in the MVCControllers class) as well as push (see UpdateWatchThread internal class in the MainActivity)

To run the android application:
-------------------------------

1. Install [Android Studio v0.5.*](http://tools.android.com/recent/androidstudio053released)
2. Clone the project
3. Open the project in the studio and run it
 
To run the angular application directly:
----------------------------------------

1. Install [nodejs](nodejs.org)
2. Install grunt cli 
       `npm install -g grunt-cli`
3. change directory to `./Angular Android/grunt`
4. Install necessary modules
       `npm install`
5. Run the server
       `grunt`
6. in your browser open the following URL: `http://localhost:5001`


