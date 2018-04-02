package project2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Servlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(Servlet.class);


    @EJB
    EjbModelService ejbModelService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<TariffModel> tariffModelList = ejbModelService.getModel().getTariffs();
        TariffModel tariffModel = tariffModelList.get(0);
        req.setAttribute("resp", tariffModelList);
        req.setAttribute("option", tariffModel.getOptionModels());
        req.getRequestDispatcher("index.xhtml").forward(req,resp);
    }


}
