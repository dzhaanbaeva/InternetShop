package euphoria.kg.parfum.controller;

import euphoria.kg.parfum.exception.ResourceNotFoundException;
import euphoria.kg.parfum.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MainController {

        @Autowired
        private final ProductsService productsService;

    public MainController(ProductsService productsService) {
        this.productsService = productsService;
    }


    @RequestMapping("/")
        public String getMainPage(Model model) {
            model.addAttribute("products", productsService.getProducts());
            return "index";
        }
        @RequestMapping("/jql/{name}")
        public String getMainPageJql(Model model, @PathVariable("name") String name) {
            model.addAttribute("products", productsService.getProductsName(name));
            return "index";
        }

        @ExceptionHandler(ResourceNotFoundException.class)
        @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)

        private  String handlRNF(ResourceNotFoundException ex, Model model){
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("name", ex.getName());

            return "resource not found";
        }


    }
