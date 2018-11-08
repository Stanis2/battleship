package lv.tsi.battleship;

import lv.tsi.battleship.model.MyGame;
import lv.tsi.battleship.model.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegServlet", urlPatterns = "/registration")
public class RegServlet extends HttpServlet {
    @Inject
    private MyGame myGame;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String un = request.getParameter("username");
        System.out.println(un);

        User user = new User();
        user.setName(un);
        myGame.setUser(user);
        response.sendRedirect("/battleship/waitregistration");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/registration.jsp").include(request, response);
    }
}
