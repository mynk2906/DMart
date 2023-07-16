package com.DMart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DMart.Exeption.StockException;
import com.DMart.Model.StockItem;
import com.DMart.Repository.StockItemRepository;

@Service
public class StockItemService {
	
	  @Autowired
	  private StockItemRepository stockItemRepository;
	  
	  //  Add new stock item
	  public StockItem addStockItem(StockItem stockItem) throws StockException {
		  
		 Optional<StockItem> existingItem = stockItemRepository.findByName(stockItem.getName());
	     if (existingItem.isPresent()) {
	          throw new StockException("Stock item with the same name already exists.");
	     }
		  
	    return stockItemRepository.save(stockItem);
	  }
	
	  // Update the quantity
	  public StockItem updateStockItemQuantity(Long itemId, int newQuantity) throws StockException {
	    StockItem stockItem = stockItemRepository.findById(itemId)
	        .orElseThrow(() -> new StockException("Stock item not found"));
	
	    stockItem.setQuantity(newQuantity);
	    return stockItemRepository.save(stockItem);
	  }
	
  	  // Delete a stock item
	  public void deleteStockItem(Long itemId) throws StockException {
	    
		  stockItemRepository.findById(itemId)
          .orElseThrow(() -> new StockException("Stock item not found"));

		  stockItemRepository.deleteById(itemId);
	  }
	  
	  // Retrieve stock items by location	
	  public List<StockItem> getStockItemsByLocation(String location) {

	    return stockItemRepository.findByLocation(location);
	  }
}
