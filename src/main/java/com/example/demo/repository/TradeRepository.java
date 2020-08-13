package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.TradeEntity;

public interface TradeRepository extends JpaRepository<TradeEntity, Integer> {
	Optional<TradeEntity> findByStockSymbol(String stockSymbol);
	List<TradeEntity> findByStockType(String stockType);

	//@Query("SELECT id,stock_price,stock_quantity,stock_symbol,stock_type FROM trade_entity  where stock_price <= :stock_price") 
	@Query("SELECT trade FROM TradeEntity trade where trade.stockPrice<= :stockPrice")
    List<TradeEntity> findByTradePrice(@Param("stockPrice") Double stockPrice);
}
