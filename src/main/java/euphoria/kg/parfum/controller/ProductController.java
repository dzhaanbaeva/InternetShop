package euphoria.kg.parfum.controller;

import euphoria.kg.parfum.exception.ResourceNotFoundException;
import euphoria.kg.parfum.service.CartService;
import euphoria.kg.parfum.service.ProductsService;
import euphoria.kg.parfum.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

    @Autowired
    private final ProductsService productsService;
    private final PropertiesService propertiesService;
    private final CartService cartService;


    public ProductController(ProductsService productsService, PropertiesService propertiesService, CartService cartService) {
        this.productsService = productsService;
        this.propertiesService = propertiesService;
        this.cartService = cartService;
    }

    private static <T> void constructPageable(Page<T> list, int pageSize, Model model, String uri) {
        if (list.hasNext()) {
            model.addAttribute("nextPageLink", constructPageUri(uri, list.nextPageable().getPageNumber(), list.nextPageable().getPageSize()));
        }

        if (list.hasPrevious()) {
            model.addAttribute("prevPageLink", constructPageUri(uri, list.previousPageable().getPageNumber(), list.previousPageable().getPageSize()));
        }

        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        model.addAttribute("items", list.getContent());
        model.addAttribute("defaultPageSize", pageSize);
    }

    private static String constructPageUri(String uri, int page, int size) {
        return String.format("%s?page=%s&size=%s", uri, page, size);
    }


    @RequestMapping("/main")
    public String getMainPage(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var product = productsService.getProducts(pageable);
        var uri = uriBuilder.getRequestURI();
        constructPageable(product, propertiesService.getDefaultPageSize(), model, uri);
        model.addAttribute("products", productsService.getProducts());
        return "general";
    }

    @GetMapping("/page/{id:\\d+?}")
    public String placePage(@PathVariable int id, Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        model.addAttribute("products", productsService.getProduct(id));
        var uri = uriBuilder.getRequestURI();
        var prod = productsService.getProd(id, pageable);
        constructPageable(prod, propertiesService.getDefaultPageSize(), model, uri);

        return "page";
    }

//    @PostMapping("/page/add")
//    @ResponseStatus(HttpStatus.SEE_OTHER)
//    public String handleAddProduct(@RequestParam(defaultValue = "--no-value--") String productId) {
//        System.out.println(productId + "+=+++++++++++++++++++++++++++++++++++++=");
////        cartService.addProduct(productId);
//        return "redirect:/page/";
//    }

//    @RequestMapping("/product/{name}")
//        public String getMainPageJql(Model model, @PathVariable("name") String name) {
//        model.addAttribute("items", productsService.selectProducts(name));
//            return "page";
//        }

//    @RequestMapping("/product/name")
////    public String selectProducts(Model model, @RequestParam("name") String name,
////                                             @RequestParam("description") String description
////                                          ){
////        model.addAttribute("items", productsService.selectProductsByName(name));
////        model.addAttribute("items", productsService.selectProductsByDescription(description));
////        model.addAttribute("items", productsService.selectProductsByName(name));
////        model.addAttribute("items", productsService.selectProductsByName(name));
////        return "page";
////    };

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)

    private String handlRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("name", ex.getId());

        return "resource not found";
    }


}
