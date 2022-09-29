package groupId.artifactId.controller.servlet.api;

import groupId.artifactId.core.dto.ProductCreationDtoBuilder;
import groupId.artifactId.service.ProductService;
import groupId.artifactId.service.api.IProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductFormData", urlPatterns = "/api/product_form")
public class ApiProductFormServlet extends HttpServlet {
    private final IProductService productService = ProductService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
            productService.add(ProductCreationDtoBuilder.create().setName(name).setPrice(Integer.parseInt(price)).
                    setDiscount(Integer.parseInt(discount)).setDescription(description).build());
        } catch (Exception e){
            resp.setStatus(500);
        }
        resp.setStatus(201);
        resp.sendRedirect(req.getContextPath() + "/ui/product");
    }
}
