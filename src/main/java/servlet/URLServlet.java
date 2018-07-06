package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;

@WebServlet(
        name = "URLServlet",
        urlPatterns = {"/browse"}
    )
public class URLServlet extends HttpServlet {

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{

        // Get parameters
        String[] parameters = {"url"};
        String[] values = {
                request.getParameter(parameters[0])
        };
        int numberOfNulls = numberOfNulls(values);
        // Check for valid parameters
        if (numberOfNulls >= parameters.length){
            // Output error
            respondText(response,
                    "Invalid request! Parameter " + Arrays.toString(parameters) + " not found.");
            // Return
            return;
        } else if (values[0] == null) {
            // Output error
            respondText(response, "Invalid request! No URL found in request.");
            // Return
            return;
        }

        // Redirect response
        // response.sendRedirect("index.jsp");

        // Write response
        respondHTML(response, values[0]);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        handleRequest(request, response);
    }

    // Do the same thing for GET and POST requests
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doTrace(req, resp);
    }

    /**
     * Count the number of null members in a string array
     * @param array A string array
     * @return The number of nulls in the array
     */
    public static final int numberOfNulls(String[] array){
        int nulls = 0;
        for (String parameter : array)
            if (parameter == null) ++nulls;
        return nulls;
    }

    /**
     * Update the servlet's response with a text output
     * @param response The servlet's response
     * @param message The text message
     * @throws IOException
     */
    public static final void respondText(HttpServletResponse response, String message) throws IOException {
        PrintWriter outText = response.getWriter();
        response.setContentType("text/plain");
        outText.write(message);
        // Close output
        outText.close();
    }

    /**
     * Update the servlet's response with a costume HTML output
     * @param response The servlet's response
     * @param url The URL the browse to
     * @throws IOException
     */
    public static final void respondHTML(HttpServletResponse response, String url) throws IOException {
        PrintWriter outText = response.getWriter();
        response.setContentType("text/html");
        outText.write("<!DOCTYPE HTML>\n" +
                "<html class=\"\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.1/normalize.min.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css\">\n" +
                "    <link href='http://fonts.googleapis.com/css?family=Raleway:100,200,300,400' rel='stylesheet' type='text/css'>\n" +
                "\n" +
                "    <!-- build:js modernizr.touch.js -->\n" +
                "    <script src=\"../dist/lib/modernizr.touch.js\"></script>\n" +
                "    <!-- endbuild -->\n" +
                "\n" +
                "    <link href=\"index.css\" rel=\"stylesheet\">\n" +
                "    <!-- build:css mfb.css -->\n" +
                "    <link href=\"../dist/mfb.css\" rel=\"stylesheet\">\n" +
                "    <!-- endbuild -->\n" +
                "\n" +
                "    <title>Material floating button. The index.</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<!-- Material Fab based on\n" +
                "https://github.com/nobitagit/material-floating-button -->" +
                "<ul id=\"menu\" class=\"mfb-component--br mfb-zoomin\" data-mfb-toggle=\"hover\">\n" +
                "    <li class=\"mfb-component__wrap\">\n" +
                "        <a href=\"#\" class=\"mfb-component__button--main\">\n" +
                "            <i class=\"mfb-component__main-icon--resting ion-plus-round\"></i>\n" +
                "            <i class=\"mfb-component__main-icon--active ion-close-round\"></i>\n" +
                "        </a>\n" +
                "        <ul class=\"mfb-component__list\">\n" +
                "            <li>\n" +
                "                <a href=\"https://github.com/alon-grinshpoon/FloatingActionButtonOverHTTPS\" data-mfb-label=\"View on Github\" class=\"mfb-component__button--child\">\n" +
                "                    <i class=\"mfb-component__child-icon ion-social-github\"></i>\n" +
                "                </a>\n" +
                "            </li>\n" +
                "            <li>\n" +
                "                <a href=\"https://github.com/alon-grinshpoon/\" data-mfb-label=\"Follow me on Github\" class=\"mfb-component__button--child\">\n" +
                "                    <i class=\"mfb-component__child-icon ion-social-octocat\"></i>\n" +
                "                </a>\n" +
                "            </li>\n" +
                "\n" +
                "            <li>\n" +
                "                <a href=\"http://twitter.com/share?text=Check this FAB over HTTPS demo!&url=https://github.com/alon-grinshpoon/&hashtags=nothingisimpossible\"\n" +
                "                   data-mfb-label=\"Share on Twitter\" class=\"mfb-component__button--child\">\n" +
                "                    <i class=\"mfb-component__child-icon ion-social-twitter\"></i>\n" +
                "                </a>\n" +
                "            </li>\n" +
                "        </ul>\n" +
                "    </li>\n" +
                "</ul>\n" +
                "\n" +
                "<!-- IFrame -->\n" +
                "<iframe src=\"" + url + "\" style=\"border: 0; width: 100%; height: 100%\" sandbox=\"allow-forms allow-pointer-lock allow-popups allow-same-origin allow-scripts allow-top-navigation\" seamless security></iframe>\n" +
                "\n" +
                "<!-- build:js mfb.js -->\n" +
                "<script src=\"../dist/mfb.js\"></script>\n" +
                "\n" +
                "<!-- Fab Script -->\n" +
                "<script>\n" +
                "\n" +
                "    var panel = document.getElementById('panel'),\n" +
                "        menu = document.getElementById('menu'),\n" +
                "        showcode = document.getElementById('showcode'),\n" +
                "        selectFx = document.getElementById('selections-fx'),\n" +
                "        selectPos = document.getElementById('selections-pos'),\n" +
                "        // demo defaults\n" +
                "        effect = 'mfb-zoomin',\n" +
                "        pos = 'mfb-component--br';\n" +
                "\n" +
                "    showcode.addEventListener('click', _toggleCode);\n" +
                "    selectFx.addEventListener('change', switchEffect);\n" +
                "    selectPos.addEventListener('change', switchPos);\n" +
                "\n" +
                "    function _toggleCode() {\n" +
                "        panel.classList.toggle('viewCode');\n" +
                "    }\n" +
                "\n" +
                "    function switchEffect(e){\n" +
                "        effect = this.options[this.selectedIndex].value;\n" +
                "        renderMenu();\n" +
                "    }\n" +
                "\n" +
                "    function switchPos(e){\n" +
                "        pos = this.options[this.selectedIndex].value;\n" +
                "        renderMenu();\n" +
                "    }\n" +
                "\n" +
                "    function renderMenu() {\n" +
                "        menu.style.display = 'none';\n" +
                "        // ?:-)\n" +
                "        setTimeout(function() {\n" +
                "            menu.style.display = 'block';\n" +
                "            menu.className = pos + effect;\n" +
                "        },1);\n" +
                "    }\n" +
                "</script>\n" +
                "\n" +
                "<!--\n" +
                "Anti-Frame-Braker based on:\n" +
                " https://stackoverflow.com/questions/8700636/how-to-show-google-com-in-an-iframe/20145417\n" +
                " http://jsfiddle.net/2gou4yen/2228/\n" +
                " -->\n" +
                "\n" +
                "<script>\n" +
                "    var iframe = document.getElementsByTagName('iframe')[0];\n" +
                "    var url = iframe.src;\n" +
                "    var getData = function (data) {\n" +
                "        if (data && data.query && data.query.results && data.query.results.resources && data.query.results.resources.content && data.query.results.resources.status == 200) loadHTML(data.query.results.resources.content);\n" +
                "        else if (data && data.error && data.error.description) loadHTML(data.error.description);\n" +
                "        else loadHTML('Error: Cannot load ' + url);\n" +
                "    };\n" +
                "    var loadURL = function (src) {\n" +
                "        url = src;\n" +
                "        var script = document.createElement('script');\n" +
                "        script.src = 'http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20data.headers%20where%20url%3D%22' + encodeURIComponent(url) + '%22&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=getData';\n" +
                "        document.body.appendChild(script);\n" +
                "    };\n" +
                "    var loadHTML = function (html) {\n" +
                "        iframe.src = 'about:blank';\n" +
                "        iframe.width = '100%';\n" +
                "        iframe.contentWindow.document.open();\n" +
                "        iframe.contentWindow.document.write(html.replace(/<head>/i, '<head><base href=\"' + url + '\"><scr' + 'ipt>document.addEventListener(\"click\", function(e) { if(e.target && e.target.nodeName == \"A\") { e.preventDefault(); parent.loadURL(e.target.href); } });</scr' + 'ipt>'));\n" +
                "        iframe.contentWindow.document.close();\n" +
                "    }\n" +
                "\n" +
                "    loadURL(iframe.src);\n" +
                "</script>\n" +
                "<!-- @include ga.html -->\n" +
                "</body>\n" +
                "</html>\n");
        // Close output
        outText.close();
    }
}