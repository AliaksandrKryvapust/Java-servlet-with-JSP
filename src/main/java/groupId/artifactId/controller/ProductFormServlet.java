package groupId.artifactId.controller;

import groupId.artifactId.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;


@WebServlet(name = "ProductForm", urlPatterns = "/product_form")
public class ProductFormServlet extends HttpServlet {
    private final ProductService productService = ProductService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productData", productService.get());
        RequestDispatcher form = req.getRequestDispatcher("/NewProductForm.jsp");
        form.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String discount = req.getParameter("discount");
        String description = req.getParameter("description");
        try {
            productService.addNewProduct(parseInt(id),name, parseInt(price), parseInt(discount),description);
        } catch (Exception e){
            throw new ServletException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/product");
    }
}
