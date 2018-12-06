package lv.tsi.battleship;

import lv.tsi.battleship.model.MyGame;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResultServlet", urlPatterns = "/result")
public class ResultServlet extends HttpServlet {
    @Inject
    private MyGame myGame;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        if (myGame.getUser().isWinner()) {
            page = "winner.jsp";
        } else {
            page = "loser.jsp";
        }
        request.getRequestDispatcher("/WEB-INF/pages/" + page).include(request, response);
    }
}
