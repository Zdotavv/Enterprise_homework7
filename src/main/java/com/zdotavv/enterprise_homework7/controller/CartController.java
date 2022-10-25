package com.zdotavv.enterprise_homework7.controller;

import com.zdotavv.enterprise_homework7.converters.CartConverter;
import com.zdotavv.enterprise_homework7.dto.CartDto;
import com.zdotavv.enterprise_homework7.dto.PersonDto;
import com.zdotavv.enterprise_homework7.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework7.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.stream.Collectors;

import static com.zdotavv.enterprise_homework7.converters.CartConverter.convertCartToCartDto;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Slf4j
@Controller
@RequestMapping(path="/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String cartIndex(Model model) {
        String message = "Cart control page";
        model.addAttribute("message", message);
        return "/cart/cartIndex";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createCartView(Model model){
        model.addAttribute("person", new PersonDto());
        model.addAttribute("cart", new CartDto());
        return "/cart/createCart";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCart(@ModelAttribute("person") PersonDto personDto) throws NotFoundException {
        log.debug("createCart() Controller - start: idPerson = {}",personDto.getIdPerson());
        cartService.createCartByPersonId(personDto.getIdPerson());
        log.debug("createCart() Controller - end: idPerson = {}",personDto.getIdPerson());
        return "/cart/createCartSuccess";
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProductView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "/cart/addProductToCart";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.PUT, RequestMethod.POST})
    public String addProductByProductIdAndCartId(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {
        log.debug("addProductByProductIdAndCartId() Controller - start: idProduct = {},idCart = {} ",cartDto.getIdProduct(),cartDto.getIdCart());
        cartService.addProductByProductIdAndCartId(cartDto.getIdCart(),cartDto.getIdProduct());
        log.debug("addProductByProductIdAndCartId() Controller - end: idProduct = {},idCart = {} ",cartDto.getIdProduct(),cartDto.getIdCart());
        return "/cart/addProductToCartSuccess";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCartView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "/cart/deleteCart";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteCart(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {

        cartService.removeCartById(cartDto.getIdCart());
        return "/cart/deleteCartSuccess";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllCarts(Model model) {
        model.addAttribute("all", cartService.getAllCarts().stream()
                .map(CartConverter::convertCartToCartDto).collect(Collectors.toList()));
        return "/cart/allCarts";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getCartByIdView(Model model) {
        model.addAttribute("cartById", new CartDto());
        return "/cart/getCart";
    }
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getCartById(@ModelAttribute("cartById") CartDto cartDto, Model model) throws NotFoundException {
        CartDto cartById = convertCartToCartDto(cartService.getCartById(cartDto.getIdCart()));
        model.addAttribute("cartById", cartById);
        return "/cart/getCartSuccess";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeProductByProductIdAndCartIdView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "/cart/removeProductFromCart";
    }

    @RequestMapping(value = "/remove", method = {RequestMethod.PUT, RequestMethod.POST})
    public String removeProductByProductIdAndCartId(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {
        cartService.removeProductByProductIdAndCartId(cartDto.getIdCart(),cartDto.getIdProduct());
        return "/cart/removeProductFromCartSuccess";
    }

    @RequestMapping(value = "/clean", method = RequestMethod.GET)
    public String removeAllProductsFromCartByIdView(Model model) {
        model.addAttribute("cart", new CartDto());
        return "/cart/cleanCart";
    }

    @RequestMapping(value = "/clean", method = RequestMethod.POST)
    public String removeAllProductsFromCartById(@ModelAttribute("cart") CartDto cartDto) throws NotFoundException {
        cartService.removeAllProductsFromCartById(cartDto.getIdCart());
        return "/cart/cleanCartSuccess";
    }
}

