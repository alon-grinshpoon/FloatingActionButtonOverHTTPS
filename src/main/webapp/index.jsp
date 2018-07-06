<!DOCTYPE HTML>
<html class="">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.1/normalize.min.css">
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link href='http://fonts.googleapis.com/css?family=Raleway:100,200,300,400' rel='stylesheet' type='text/css'>

    <!-- build:js modernizr.touch.js -->
    <script src="../dist/lib/modernizr.touch.js"></script>
    <!-- endbuild -->

    <link href="index.css" rel="stylesheet">
    <!-- build:css mfb.css -->
    <link href="../dist/mfb.css" rel="stylesheet">
    <!-- endbuild -->

    <title>FAB over HTTP/HTTPS Demo</title>
</head>
<body>

<!-- Material Fab based on
https://github.com/nobitagit/material-floating-button -->
<ul id="menu" class="mfb-component--br mfb-zoomin" data-mfb-toggle="hover">
    <li class="mfb-component__wrap">
        <a href="#" class="mfb-component__button--main">
            <i class="mfb-component__main-icon--resting ion-plus-round"></i>
            <i class="mfb-component__main-icon--active ion-close-round"></i>
        </a>
        <ul class="mfb-component__list">
            <li>
                <a href="https://github.com/alon-grinshpoon/FloatingActionButtonOverHTTPS" data-mfb-label="View on Github" class="mfb-component__button--child">
                    <i class="mfb-component__child-icon ion-social-github"></i>
                </a>
            </li>
            <li>
                <a href="https://github.com/alon-grinshpoon/" data-mfb-label="Follow me on Github" class="mfb-component__button--child">
                    <i class="mfb-component__child-icon ion-social-octocat"></i>
                </a>
            </li>

            <li>
                <a href="http://twitter.com/share?text=Check this FAB over HTTP/HTTPS demo!&url=https://github.com/alon-grinshpoon/&hashtags=NothingIsImpossible"
                   data-mfb-label="Share on Twitter" class="mfb-component__button--child">
                    <i class="mfb-component__child-icon ion-social-twitter"></i>
                </a>
            </li>
        </ul>
    </li>
</ul>

<!-- IFrame -->
<iframe src="https://www.wikipedia.org/" style="border: 0; width: 100%; height: 100%" sandbox="allow-forms allow-pointer-lock allow-popups allow-same-origin allow-scripts allow-top-navigation" seamless security></iframe>

<!-- build:js mfb.js -->
<script src="../dist/mfb.js"></script>

<!-- Fab Script -->
<script>

    var panel = document.getElementById('panel'),
        menu = document.getElementById('menu'),
        showcode = document.getElementById('showcode'),
        selectFx = document.getElementById('selections-fx'),
        selectPos = document.getElementById('selections-pos'),
        // demo defaults
        effect = 'mfb-zoomin',
        pos = 'mfb-component--br';

    showcode.addEventListener('click', _toggleCode);
    selectFx.addEventListener('change', switchEffect);
    selectPos.addEventListener('change', switchPos);

    function _toggleCode() {
        panel.classList.toggle('viewCode');
    }

    function switchEffect(e){
        effect = this.options[this.selectedIndex].value;
        renderMenu();
    }

    function switchPos(e){
        pos = this.options[this.selectedIndex].value;
        renderMenu();
    }

    function renderMenu() {
        menu.style.display = 'none';
        // ?:-)
        setTimeout(function() {
            menu.style.display = 'block';
            menu.className = pos + effect;
        },1);
    }
</script>

<!--
Anti-Frame-Braker based on:
 https://stackoverflow.com/questions/8700636/how-to-show-google-com-in-an-iframe/20145417
 http://jsfiddle.net/2gou4yen/2228/
 -->

<script>
    var iframe = document.getElementsByTagName('iframe')[0];
    var url = iframe.src;
    var getData = function (data) {
        if (data && data.query && data.query.results && data.query.results.resources && data.query.results.resources.content && data.query.results.resources.status == 200) loadHTML(data.query.results.resources.content);
        else if (data && data.error && data.error.description) loadHTML(data.error.description);
        else loadHTML('Error: Cannot load ' + url);
    };
    var loadURL = function (src) {
        url = src;
        var script = document.createElement('script');
        script.src = 'http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20data.headers%20where%20url%3D%22' + encodeURIComponent(url) + '%22&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=getData';
        document.body.appendChild(script);
    };
    var loadHTML = function (html) {
        iframe.src = 'about:blank';
        iframe.width = '100%';
        iframe.contentWindow.document.open();
        iframe.contentWindow.document.write(html.replace(/<head>/i, '<head><base href="' + url + '"><scr' + 'ipt>document.addEventListener("click", function(e) { if(e.target && e.target.nodeName == "A") { e.preventDefault(); parent.loadURL(e.target.href); } });</scr' + 'ipt>'));
        iframe.contentWindow.document.close();
    }

    loadURL(iframe.src);
</script>
<!-- @include ga.html -->
</body>
</html>
