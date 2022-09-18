package groupId.artifactId.controller;

import groupId.artifactId.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Product", urlPatterns = "/product")
public class ProductsServlet extends HttpServlet {

    private final ProductService productService = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("productData", productService.get());
        RequestDispatcher form = req.getRequestDispatcher("/ProductForm.jsp");
        form.forward(req, resp);
    }
}
