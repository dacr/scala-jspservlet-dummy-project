package dummy

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class DummyServlet extends HttpServlet {

  override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
    response.setContentType("text/html")
    response.setCharacterEncoding("UTF-8")
    val responseBody =
      <html>
        <body>
          <h1>Hello world!</h1>
        </body>
      </html>
      
    response.getWriter.write(responseBody.toString)
  }
}