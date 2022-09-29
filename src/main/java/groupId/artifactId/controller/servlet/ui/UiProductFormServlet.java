package groupId.artifactId.controller.servlet.ui;

import groupId.artifactId.service.ProductService;
import groupId.artifactId.service.api.IProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductForm", urlPatterns = "/ui/product_form")
public class UiProductFormServlet extends HttpServlet {
    private final IProductService productService = ProductService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("productData", productService.getById());
        RequestDispatcher form = req.getRequestDispatcher("/NewProductForm.jsp");
        form.forward(req, resp);
        resp.setStatus(200);
    }
}
