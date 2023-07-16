package com.DMart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DMart.Exeption.StockException;
import com.DMart.Model.StockItem;
import com.DMart.Service.StockItemService;

@RestController
@RequestMapping("/api/stock")
public class StockItemController {
	
	  @Autowired
	  private StockItemService stockItemService;

	  @PostMapping
	  public ResponseEntity<StockItem> addStockItem(@RequestBody StockItem stockItem) throws StockException {
	    StockItem addedStockItem = stockItemService.addStockItem(stockItem);
	    return ResponseEntity.ok(addedStockItem);
	  }

	  @PutMapping("/{itemId}")
	  public ResponseEntity<StockItem> updateStockItemQuantity(
	      @PathVariable Long itemId,
	      @RequestParam int newQuantity) throws StockException {
	    StockItem updatedStockItem = stockItemService.updateStockItemQuantity(itemId, newQuantity);
	    return ResponseEntity.ok(updatedStockItem);
	  }

	  @DeleteMapping("/{itemId}")
	  public ResponseEntity<Void> deleteStockItem(@PathVariable Long itemId) throws StockException {
	    stockItemService.deleteStockItem(itemId);
	    return ResponseEntity.noContent().build();
	  }

	  @GetMapping("/{location}")
	  public ResponseEntity<List<StockItem>> getStockItemsByLocation(@PathVariable String location) {
	    List<StockItem> stockItems = stockItemService.getStockItemsByLocation(location);
	    return ResponseEntity.ok(stockItems);
	  }

}
