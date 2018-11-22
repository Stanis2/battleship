package lv.tsi.battleship;

import lv.tsi.battleship.model.Game;
import lv.tsi.battleship.model.GameManager;
import lv.tsi.battleship.model.MyGame;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WaitPlacementServlet", urlPatterns = "/waitplacement")
public class WaitPlacementServlet extends HttpServlet {
    @Inject
    private MyGame myGame;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Game game = myGame.getGame();

        if (game.isReady()) {
            response.sendRedirect("/battleship/game");
            System.out.println("Players are playing.");
        } else {
            request.getRequestDispatcher("WEB-INF/pages/waitplacement.jsp").include(request, response);
        }
    }
}
