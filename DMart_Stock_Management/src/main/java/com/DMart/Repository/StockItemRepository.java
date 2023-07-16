package com.DMart.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DMart.Model.StockItem;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem,Long>{
	
	List<StockItem> findByLocation(String location);
	
	Optional<StockItem> findByName(String name);
}
