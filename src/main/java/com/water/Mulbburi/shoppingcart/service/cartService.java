package com.water.Mulbburi.shoppingcart.service;

import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.water.Mulbburi.shoppingcart.DAO.CartMapper;
import com.water.Mulbburi.shoppingcart.DTO.cartDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class cartService {
	private final CartMapper cartDAO;

	public cartService(CartMapper cartDAO) {
		this.cartDAO = cartDAO;
	}

	public void addCart(cartDTO addCart) {
		cartDAO.addCart(addCart);
	}

	public void deleteCart(cartDTO deletesbNo) {
		cartDAO.deleteCart(deletesbNo);
	}

	public List<cartDTO> getCartList(Long memberNo) {
		List<cartDTO> cart = cartDAO.getCart(memberNo);
		for (cartDTO dto : cart) {
			dto.initTotal();
		}
		return cart;
	}

	public void modifyCount(cartDTO updateCartPost) {
		cartDAO.modifyCount(updateCartPost);
	}

	public List<cartDTO> getSelectedCartList(Long memberNo, List<String> selectedItems) {
		List<cartDTO> cartList = cartDAO.getSelectedCart(memberNo, selectedItems);
		System.out.println(cartList);
		return cartList;
	}
}