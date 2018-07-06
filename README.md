#  Floating Action Button OverHTTPS

## Overview
A web proxy implementation that overlays a floating action button over HTTP/HTTPS sites.

## Credits

* Material Floating Button by nobitagit: https://github.com/nobitagit/material-floating-button

* Anti-Frame-Braker based on https://stackoverflow.com/questions/8700636/how-to-show-google-com-in-an-iframe/2014541 / http://jsfiddle.net/2gou4yen/2228/

## Know Issues

* Might need to refresh page. Possible fix is to add one time page refresh after first page load, based on https://stackoverflow.com/questions/6985507/one-time-page-refresh-after-first-page-load

* Some websites (e.g., Facebook or YouTube will falsely alert that this brower is unsupported). Possible fix is to spoof the broswer user-agent.

* URL is static. For a seamless browsing experince, one might want to change the browser URL/Title to reflect the site.

## Additional Information

Written as a Heroku-compatible JSP application
Created by Alon Grinshpoon
Made with <3 for Routier
