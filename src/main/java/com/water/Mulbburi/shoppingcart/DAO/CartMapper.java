package com.water.Mulbburi.shoppingcart.DAO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.water.Mulbburi.shoppingcart.DTO.cartDTO;
@Mapper
public interface CartMapper {
	public void addCart(cartDTO addCart);
	public void deleteCart(cartDTO deletesbNo);
	
	public cartDTO checkCart(cartDTO cart);
	public List<cartDTO> getCart(Long memberNo);
	public void modifyCount(cartDTO updateCartPost);
	public List<cartDTO> getSelectedCart(Long memberNo, List<String> selectedItems);
	
	 
	
}