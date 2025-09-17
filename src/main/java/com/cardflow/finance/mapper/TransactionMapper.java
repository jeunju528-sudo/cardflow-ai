package com.cardflow.finance.mapper;

import com.cardflow.finance.domain.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;
import java.util.List;

@Mapper // 붙여도 되고, @MapperScan으로만 처리해도 됨
public interface TransactionMapper {
    List<Transaction> selectTransactions(
            @Param("userId") Long userId,
            @Param("country") String country,
            @Param("channel") String channel,
            @Param("status") String status,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("limit") int limit,
            @Param("offset") int offset
    );
    long countTransactions(
            @Param("userId") Long userId,
            @Param("country") String country,
            @Param("channel") String channel,
            @Param("status") String status,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
