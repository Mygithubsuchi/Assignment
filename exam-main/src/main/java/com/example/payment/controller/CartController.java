package com.example.payment.controller;

import com.example.payment.model.CartModel;
import com.example.payment.model.CartModelAmount;
import com.example.payment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/cart")

public class CartController {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CardRepository cardRepository;



    @PostMapping(value = "addCart")
    public List<Cart> addCart(@RequestBody CartModel cartModel){
        String cartId = UUID.randomUUID().toString();
    for(String productId :cartModel.getProductId()){
        Cart cart =new Cart();
        cart.setCartId(cartId);
        cart.setName(cartModel.getName());
        cart.setProductId(Integer.parseInt(productId));
        cartRepository.save(cart);
    }
return cartRepository.findByCartId(cartId);
    }

    @PostMapping(value = "populateAmount")
    public int addCart(@RequestBody CartModelAmount cartModel){

       List<Cart> cartContent= cartRepository.findByCartId(cartModel.getCartId());
       Card card = cardRepository.findByName(cartModel.getCardType()).get(0);
       int amt =0;
       for(Cart cart:cartContent){
           Product product = productRepository.findById(cart.getProductId()).get();
           int discount = (card.getPercentage()*product.getPrice())/100;

           amt = amt+ (product.getPrice() - discount);
       }

        return amt;
    }
    
    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable(value = "id") Integer id) {
    	Cart cart = cartRepository.findById(id).get();
    	cartRepository.delete(cart);
   }

}
