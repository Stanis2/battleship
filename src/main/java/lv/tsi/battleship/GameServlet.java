package lv.tsi.battleship;

import lv.tsi.battleship.model.MyGame;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GameServlet", urlPatterns = "/game")
public class GameServlet extends HttpServlet {
    @Inject
    private MyGame myGame;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addr = request.getParameter("cell");
        if (!myGame.isMyTurn()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        myGame.getGame().fire(addr);
        if (myGame.getGame().isFinished()) {
            response.sendRedirect("/battleship/result");
        } else if (myGame.getUser().isLoser()) {
            response.sendRedirect("/battleship/result");
        } else {
            doGet(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/game.jsp").include(request, response);
    }
}
