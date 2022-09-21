package groupId.artifactId.controller;

import groupId.artifactId.service.ProductService;
import groupId.artifactId.util.Helper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductForm", urlPatterns = "/product_form")
public class ProductFormServlet extends HttpServlet {
    private final ProductService productService = ProductService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productData", productService.getById());
        RequestDispatcher form = req.getRequestDispatcher("/NewProductForm.jsp");
        form.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String discount = req.getParameter("discount");
        String description = req.getParameter("description");
        if (price==null || !price.matches("\\d+")){
            throw new IllegalArgumentException("Error code 400. Product price is not a number");
        }
        if (discount==null || !discount.matches("\\d+")){
            throw new IllegalArgumentException("Error code 400. Product discount is not a number");
        }
        try {
            productService.add(Helper.createProductDTO(name,price,discount,description));
        } catch (Exception e){
            throw new ServletException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/product");
    }
}
