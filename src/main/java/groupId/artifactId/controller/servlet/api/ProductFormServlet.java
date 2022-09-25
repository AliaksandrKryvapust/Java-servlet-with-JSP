package groupId.artifactId.controller.servlet.api;

import groupId.artifactId.service.ProductService;
import groupId.artifactId.service.api.IProductService;
import groupId.artifactId.util.Helper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductForm", urlPatterns = "/product_form")
public class ProductFormServlet extends HttpServlet {
    private final IProductService productService = ProductService.getInstance();

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
